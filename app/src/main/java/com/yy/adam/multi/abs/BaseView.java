package com.yy.adam.multi.abs;

import android.app.Activity;
import android.content.Context;

/**
 * @author yy
 */
public interface BaseView<T> {
    Activity getActivity();
    Context getContext();
	void setPresenter(T presenter);
}
