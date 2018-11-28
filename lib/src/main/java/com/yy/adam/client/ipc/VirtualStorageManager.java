package com.yy.adam.client.ipc;


import android.os.RemoteException;

import com.yy.adam.client.env.VirtualRuntime;
import com.yy.adam.helper.ipcbus.IPCSingleton;
import com.yy.adam.server.interfaces.IVirtualStorageService;

/**
 * @author Lody
 */

public class VirtualStorageManager {

    private static final VirtualStorageManager sInstance = new VirtualStorageManager();
    private IPCSingleton<IVirtualStorageService> singleton = new IPCSingleton<>(IVirtualStorageService.class);


    public static VirtualStorageManager get() {
        return sInstance;
    }


    public IVirtualStorageService getRemote() {
        return singleton.get();
    }

    public void setVirtualStorage(String packageName, int userId, String vsPath) {
        try {
            getRemote().setVirtualStorage(packageName, userId, vsPath);
        } catch (RemoteException e) {
            VirtualRuntime.crash(e);
        }
    }

    public String getVirtualStorage(String packageName, int userId) {
        try {
            return getRemote().getVirtualStorage(packageName, userId);
        } catch (RemoteException e) {
            return VirtualRuntime.crash(e);
        }
    }

    public void setVirtualStorageState(String packageName, int userId, boolean enable) {
        try {
            getRemote().setVirtualStorageState(packageName, userId, enable);
        } catch (RemoteException e) {
            VirtualRuntime.crash(e);
        }
    }

    public boolean isVirtualStorageEnable(String packageName, int userId) {
        try {
            return getRemote().isVirtualStorageEnable(packageName, userId);
        } catch (RemoteException e) {
            return VirtualRuntime.crash(e);
        }
    }
}
