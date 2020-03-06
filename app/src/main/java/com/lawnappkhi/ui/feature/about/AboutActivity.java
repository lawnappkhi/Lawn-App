package com.lawnappkhi.ui.feature.about;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.lawnappkhi.App;
import com.lawnappkhi.R;
import com.lawnappkhi.data.Repository;
import com.lawnappkhi.databinding.ActivityAboutBinding;
import com.lawnappkhi.ui.base.BaseActivity;
import javax.inject.Inject;
/*
 * Created by shayan.rais on 20/12/2017.
 */

public class AboutActivity extends BaseActivity implements AboutContract.View {

    //5 lines
    ActivityAboutBinding binding;
    @Inject
    Repository repository;
    AboutPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_about);
        App.getInstance().getComponent().injectAboutActivity(this);
        presenter = new AboutPresenter(this, repository);
        presenter.setupIntent(getIntent());
    }


    //______________________________________________________________________________________________ CREATE
    @Override
    public void setupToolbar() {
    }

    @Override
    public void setupLayout() {
    }

    @Override
    public void setupClickListeners() {
    }
}
