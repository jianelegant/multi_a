package com.yy.adam.server.interfaces;

import android.os.RemoteException;

import com.yy.adam.remote.VDeviceInfo;

/**
 * @author yy
 */
public interface IDeviceInfoManager {

    VDeviceInfo getDeviceInfo(int userId) throws RemoteException;

    void updateDeviceInfo(int userId, VDeviceInfo info) throws RemoteException;

}
