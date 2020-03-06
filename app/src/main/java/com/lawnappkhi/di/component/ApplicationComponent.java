package com.lawnappkhi.di.component;


import com.lawnappkhi.App;
import com.lawnappkhi.di.Singleton;
import com.lawnappkhi.di.module.DataSourceModule;
import com.lawnappkhi.ui.feature.about.AboutActivity;
import com.lawnappkhi.ui.feature.login.LoginActivity;
import com.lawnappkhi.ui.feature.home.HomeActivity;
import com.lawnappkhi.ui.feature.lawndetail.LawnDetailActivity;
import dagger.Component;
/*
 * Created by shayan.rais on 12/11/2017.
 */

@Singleton
@Component(modules = {DataSourceModule.class})
public interface ApplicationComponent {

    void inject(App app);

    //______________________________________________________________________________________________
    void injectCodeActivity(LoginActivity activity);
    void injectNewDoctorActivity(LawnDetailActivity activity);
    void injectAboutActivity(AboutActivity activity);
    void injectPatientListActivity(HomeActivity activity);
}