package com.lawnappkhi.ui.feature.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lawnappkhi.App;
import com.lawnappkhi.R;
import com.lawnappkhi.data.Repository;
import com.lawnappkhi.data.local.pref.Pref;
import com.lawnappkhi.data.model.Patient;
import com.lawnappkhi.databinding.ActivityPatientListBinding;
import com.lawnappkhi.ui.base.BaseActivity;
import com.lawnappkhi.ui.feature.home.adapter.HomeAdapter;
import com.lawnappkhi.util.ActivityUtil;
import com.lawnappkhi.util.JsonUtil;

import java.util.ArrayList;
import javax.inject.Inject;
/*
 * Created by shayan.rais on 20/12/2017.
 */

public class HomeActivity extends BaseActivity implements HomeContract.View {

    //5 lines
    ActivityPatientListBinding binding;
    @Inject
    Repository repository;
    HomePresenter presenter;

    private HomeAdapter adapter;
    private DatabaseReference mFirebaseDatabase;
    final ArrayList<Patient> data = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_patient_list);
        mFirebaseDatabase = FirebaseDatabase.getInstance().getReference();
        App.getInstance().getComponent().injectPatientListActivity(this);
        presenter = new HomePresenter(this, repository);
        presenter.setupIntent(getIntent());
    }

    //______________________________________________________________________________________________
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_admin:
                ActivityUtil.openLawnDetail(HomeActivity.this, JsonUtil.convertDoctorStringToJson(Pref.getDoctor()));
                break;
            case R.id.menu_about:
                ActivityUtil.openAbout(HomeActivity.this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }


    //______________________________________________________________________________________________ CREATE
    @Override
    public void setupToolbar() {
        setSupportActionBar(binding.toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public void setupLayout() {
        DatabaseReference usersRef = mFirebaseDatabase.child("users");
        usersRef.addValueEventListener(new ValueEventListener() {
               @Override
               public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                   data.clear();
                   for (DataSnapshot user : dataSnapshot.getChildren()) {
                       Patient patient = user.getValue(Patient.class);
                       patient.setId(user.getKey()); //basically id
                       data.add(patient);
                       binding.recycler.setVisibility(View.VISIBLE);
                       binding.layoutLoader.loading.setVisibility(View.GONE);
                       adapter.notifyDataSetChanged();
                   }
               }
               @Override
               public void onCancelled(@NonNull DatabaseError databaseError) {
               }
            }
        );
        adapter = new HomeAdapter(this, data);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(layoutManager);
    }

    @Override
    public void setupClickListeners() {
    }
}
