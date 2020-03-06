package com.lawnappkhi.ui.feature.about;

/*
 * Created by shayan.rais on 20/12/2017.
 */

import com.lawnappkhi.ui.base.BasePresenter;
import com.lawnappkhi.ui.base.BaseView;

public class AboutContract {

    public interface View extends BaseView<Presenter> {
        void setupToolbar();
        void setupLayout();
        void setupClickListeners();
    }

    public interface Presenter extends BasePresenter {

    }
}
