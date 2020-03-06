package com.lawnappkhi.data;

import com.lawnappkhi.data.local.LocalDataSource;
import com.lawnappkhi.data.remote.RemoteDataInterface;
import com.lawnappkhi.data.remote.RemoteDataSource;
import com.lawnappkhi.di.Local;
import com.lawnappkhi.di.Remote;
import javax.inject.Inject;
/*
 * Created by shayan.rais on 12/9/2017.
 */

public class Repository implements RemoteDataInterface {

    private final RemoteDataSource remote;
    private final LocalDataSource local;

    @Inject
    public Repository(@Remote RemoteDataSource remote, @Local LocalDataSource local) {
        this.remote = remote;
        this.local = local;
    }

}
