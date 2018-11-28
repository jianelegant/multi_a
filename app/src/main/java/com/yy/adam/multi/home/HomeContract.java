package com.yy.adam.multi.home;


import java.util.List;

import com.yy.adam.multi.abs.BasePresenter;
import com.yy.adam.multi.abs.BaseView;
import com.yy.adam.multi.home.models.AppData;
import com.yy.adam.multi.home.models.AppInfoLite;

/**
 * @author yy
 */
/* package */ class HomeContract {

	/* package */ interface HomeView extends BaseView<HomePresenter> {

        void showBottomAction();

        void hideBottomAction();

		void showLoading();

		void hideLoading();

		void loadFinish(List<AppData> appModels);

		void loadError(Throwable err);

		void showGuide();

		void addAppToLauncher(AppData model);

        void removeAppToLauncher(AppData model);

		void refreshLauncherItem(AppData model);

		void askInstallGms();
	}

	/* package */ interface HomePresenter extends BasePresenter {

		void launchApp(AppData data);

		void dataChanged();

		void addApp(AppInfoLite info);

		void deleteApp(AppData data);

        void createShortcut(AppData data);
    }

}
