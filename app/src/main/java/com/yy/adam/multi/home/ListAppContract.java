package com.yy.adam.multi.home;

import java.util.List;

import com.yy.adam.multi.abs.BasePresenter;
import com.yy.adam.multi.abs.BaseView;
import com.yy.adam.multi.home.models.AppInfo;

/**
 * @author Lody
 * @version 1.0
 */
/*package*/ class ListAppContract {
    interface ListAppView extends BaseView<ListAppPresenter> {

        void startLoading();

        void loadFinish(List<AppInfo> infoList);
    }

    interface ListAppPresenter extends BasePresenter {

    }
}
