package com.lawnappkhi.di.module;

import android.content.Context;
import com.lawnappkhi.data.Repository;
import com.lawnappkhi.data.local.LocalDataSource;
import com.lawnappkhi.data.remote.RemoteDataSource;
import com.lawnappkhi.di.Singleton;
import dagger.Module;
import dagger.Provides;
/*
 * Created by shayan.rais on 12/9/2017.
 */

@Module(includes = {ApplicationModule.class})
public class DataSourceModule {

    @Provides
    @Singleton
    Repository repository(RemoteDataSource remote, LocalDataSource local) {
        return new Repository(remote, local);
    }

    @Provides
    @Singleton
    RemoteDataSource remoteDataSource() {
        return new RemoteDataSource();
    }

    @Provides
    @Singleton
    LocalDataSource localDataSource(Context context) {
        return new LocalDataSource(context);
    }
}
