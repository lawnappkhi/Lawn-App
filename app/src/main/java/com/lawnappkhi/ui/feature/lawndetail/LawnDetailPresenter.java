package com.lawnappkhi.ui.feature.lawndetail;

import android.content.Intent;
import android.os.Bundle;

import com.lawnappkhi.constant.IntentConstant;
import com.lawnappkhi.data.Repository;
import com.lawnappkhi.data.model.Doctor;
/*
 * Created by shayan.rais on 20/12/2017.
 */

public class LawnDetailPresenter implements LawnDetailContract.Presenter {

    private final LawnDetailContract.View view;
    private final Repository repository;

    Doctor doctor;

    LawnDetailPresenter(LawnDetailContract.View view, Repository repository) {
        this.view = view;
        this.repository = repository;
    }

    //______________________________________________________________________________________________
    @Override
    public void setupIntent(Intent intent) {
        Bundle bundle = intent.getBundleExtra(IntentConstant.BUNDLE_DOCTOR);
        doctor = bundle.getParcelable(IntentConstant.PARCELABLE_DOCTOR);


        view.setupToolbar();
        view.setupLayout();
        view.setupClickListeners();
    }

    @Override
    public void setupFragmentIntent(Bundle bundle) {

    }
}
