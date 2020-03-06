package com.lawnappkhi.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.lawnappkhi.constant.IntentConstant;
import com.lawnappkhi.data.model.Doctor;
import com.lawnappkhi.ui.feature.about.AboutActivity;
import com.lawnappkhi.ui.feature.lawndetail.LawnDetailActivity;

/*
 * Created by shayan.rais on 12/27/17.
 */

public class ActivityUtil {


    public static void openLawnDetail(Context ctx, Doctor doctor) {
        Intent intent = new Intent(ctx, LawnDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(IntentConstant.PARCELABLE_DOCTOR, doctor);
        intent.putExtra(IntentConstant.BUNDLE_DOCTOR, bundle);
        ctx.startActivity(intent);
    }

    public static void openAbout(Context ctx) {
        Intent intent = new Intent(ctx, AboutActivity.class);
        ctx.startActivity(intent);
    }
}
