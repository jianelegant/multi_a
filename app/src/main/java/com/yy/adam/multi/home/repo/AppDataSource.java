package com.yy.adam.multi.home.repo;

import android.content.Context;

import com.yy.adam.remote.InstallResult;

import org.jdeferred.Promise;

import java.io.File;
import java.util.List;

import com.yy.adam.multi.home.models.AppData;
import com.yy.adam.multi.home.models.AppInfo;
import com.yy.adam.multi.home.models.AppInfoLite;

/**
 * @author yy
 * @version 1.0
 */
public interface AppDataSource {

    /**
     * @return All the Applications we Virtual.
     */
    Promise<List<AppData>, Throwable, Void> getVirtualApps();

    /**
     * @param context Context
     * @return All the Applications we Installed.
     */
    Promise<List<AppInfo>, Throwable, Void> getInstalledApps(Context context);

    Promise<List<AppInfo>, Throwable, Void> getStorageApps(Context context, File rootDir);

    InstallResult addVirtualApp(AppInfoLite info);

    boolean removeVirtualApp(String packageName, int userId);
}
