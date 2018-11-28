// IServiceFetcher.aidl
package com.yy.adam.server.interfaces;

interface IServiceFetcher {
    IBinder getService(String name);
    void addService(String name,in IBinder service);
    void removeService(String name);
}