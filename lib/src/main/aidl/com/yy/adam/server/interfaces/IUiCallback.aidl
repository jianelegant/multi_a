// IUiCallback.aidl
package com.yy.adam.server.interfaces;

interface IUiCallback {
    void onAppOpened(in String packageName, in int userId);
}
