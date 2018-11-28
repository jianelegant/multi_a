// IProcessObserver.aidl
package com.yy.adam.server.interfaces;

interface IProcessObserver {
    void onProcessCreated(in String pkg, in String processName);

    void onProcessDied(in String pkg, in String processName);
}
