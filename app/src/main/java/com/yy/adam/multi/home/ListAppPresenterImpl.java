package com.yy.adam.multi.home;

import android.app.Activity;
import android.content.Intent;

import java.io.File;

import com.yy.adam.multi.VCommends;
import com.yy.adam.multi.home.repo.AppDataSource;
import com.yy.adam.multi.home.models.PackageAppData;
import com.yy.adam.multi.home.repo.AppRepository;

/**
 * @author Lody
 */
class ListAppPresenterImpl implements ListAppContract.ListAppPresenter {

	private Activity mActivity;
	private ListAppContract.ListAppView mView;
	private AppDataSource mRepository;

	private File from;

	ListAppPresenterImpl(Activity activity, ListAppContract.ListAppView view, File fromWhere) {
		mActivity = activity;
		mView = view;
		mRepository = new AppRepository(activity);
		mView.setPresenter(this);
		this.from = fromWhere;
	}

	@Override
	public void start() {
		mView.setPresenter(this);
		mView.startLoading();
		if (from == null)
			mRepository.getInstalledApps(mActivity).done(mView::loadFinish);
		else
			mRepository.getStorageApps(mActivity, from).done(mView::loadFinish);
	}
}
