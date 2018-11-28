// IAppRequestListener.aidl
package com.yy.adam.server.interfaces;

interface IAppRequestListener {
    void onRequestInstall(in String path);
    void onRequestUninstall(in String pkg);
}
