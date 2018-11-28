package com.yy.adam.multi.home.models;

import android.graphics.drawable.Drawable;

/**
 * @author yy
 */

public interface AppData {

    boolean isLoading();

    boolean isFirstOpen();

    Drawable getIcon();

    String getName();

    boolean canReorder();

    boolean canLaunch();

    boolean canDelete();

    boolean canCreateShortcut();
}
