package com.yy.adam.multi.abs.ui;

import org.jdeferred.android.AndroidDeferredManager;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.yy.adam.multi.abs.BasePresenter;

/**
 * @author yy
 */
public class VFragment<T extends BasePresenter> extends Fragment {

	protected T mPresenter;

	public T getPresenter() {
		return mPresenter;
	}

	public void setPresenter(T presenter) {
		this.mPresenter = presenter;
	}

	protected AndroidDeferredManager defer() {
		return VUiKit.defer();
	}

	public void finishActivity() {
		Activity activity = getActivity();
		if (activity != null) {
			activity.finish();
		}
	}

	public void destroy() {
		finishActivity();
	}
}
