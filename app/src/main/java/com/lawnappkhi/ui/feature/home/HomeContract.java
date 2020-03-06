package com.lawnappkhi.ui.feature.home;

import com.lawnappkhi.ui.base.BasePresenter;
import com.lawnappkhi.ui.base.BaseView;
/*
 * Created by shayan.rais on 20/12/2017.
 */

public class HomeContract {

    public interface View extends BaseView<Presenter> {
        void setupToolbar();
        void setupLayout();
        void setupClickListeners();
    }

    public interface Presenter extends BasePresenter {

    }
}
