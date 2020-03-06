package com.lawnappkhi.ui.feature.login;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.lawnappkhi.App;
import com.lawnappkhi.R;
import com.lawnappkhi.data.Repository;
import com.lawnappkhi.data.local.pref.Pref;
import com.lawnappkhi.databinding.ActivityCodeBinding;
import com.lawnappkhi.ui.base.BaseActivity;
import com.lawnappkhi.util.ActivityUtil;
import javax.inject.Inject;
/*
 * Created by shayan.rais on 20/12/2017.
 */

public class LoginActivity extends BaseActivity implements LoginContract.View {

    //5 lines
    ActivityCodeBinding binding;
    @Inject
    Repository repository;
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_code);
        App.getInstance().getComponent().injectCodeActivity(this);

        if(Pref.getIsCodeVerified()) {
            //ActivityUtil.openHome(this);
            finish();
        }


        presenter = new LoginPresenter(this, repository);
        presenter.setupIntent(getIntent());
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(binding.editext, InputMethodManager.SHOW_IMPLICIT);
        binding.editext.requestFocus();
        binding.editext.setFocusableInTouchMode(true);
        binding.editext.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable mEdit) {
                if(binding.editext.getText().length() >= 5) {
                    if(binding.editext.getText().toString().equals("99887")) {
                        Toast.makeText(LoginActivity.this, "Verified", Toast.LENGTH_SHORT).show();
                        Pref.putIsCodeVerified(true);
                        //ActivityUtil.openHome(LoginActivity.this);
                        finish();
                    } else
                        Toast.makeText(LoginActivity.this, "Wrong code, Please try again", Toast.LENGTH_SHORT).show();

                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });
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
