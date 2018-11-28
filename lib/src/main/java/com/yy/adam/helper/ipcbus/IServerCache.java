package com.yy.adam.helper.ipcbus;

import android.os.IBinder;

/**
 * @author yy
 */
public interface IServerCache {
    void join(String serverName, IBinder binder);
    IBinder query(String serverName);
}
