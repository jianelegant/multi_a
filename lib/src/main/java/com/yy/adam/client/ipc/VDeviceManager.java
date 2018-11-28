package com.yy.adam.client.ipc;

import android.os.RemoteException;

import com.yy.adam.client.env.VirtualRuntime;
import com.yy.adam.helper.ipcbus.IPCSingleton;
import com.yy.adam.remote.VDeviceInfo;
import com.yy.adam.server.interfaces.IDeviceInfoManager;

/**
 * @author Lody
 */

public class VDeviceManager {

    private static final VDeviceManager sInstance = new VDeviceManager();
    private IPCSingleton<IDeviceInfoManager> singleton = new IPCSingleton<>(IDeviceInfoManager.class);


    public static VDeviceManager get() {
        return sInstance;
    }


    public IDeviceInfoManager getService() {
        return singleton.get();
    }

    public VDeviceInfo getDeviceInfo(int userId) {
        try {
            return getService().getDeviceInfo(userId);
        } catch (RemoteException e) {
            return VirtualRuntime.crash(e);
        }
    }
}