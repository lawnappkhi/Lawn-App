package com.lawnappkhi.ui.feature.login;

import android.content.Intent;
import android.os.Bundle;
import com.lawnappkhi.data.Repository;
/*
 * Created by shayan.rais on 20/12/2017.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private final LoginContract.View view;
    private final Repository repository;


    LoginPresenter(LoginContract.View view, Repository repository) {
        this.view = view;
        this.repository = repository;
    }

    //______________________________________________________________________________________________
    @Override
    public void setupIntent(Intent intent) {
        view.setupToolbar();
        view.setupLayout();
        view.setupClickListeners();
    }

    @Override
    public void setupFragmentIntent(Bundle bundle) {

    }
}
