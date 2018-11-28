package com.yy.adam.client.core;

/**
 * @author yy
 */

public interface CrashHandler {

    void handleUncaughtException(Thread t, Throwable e);

}
