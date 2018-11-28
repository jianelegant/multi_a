package com.yy.adam.helper.compat;

import android.os.IBinder;
import android.os.IInterface;

import mirror.android.app.ApplicationThreadNative;
import mirror.android.app.IApplicationThreadOreo;

/**
 * @author yy
 */

public class ApplicationThreadCompat {

    public static IInterface asInterface(IBinder binder) {
        if (BuildCompat.isOreo()) {
            return IApplicationThreadOreo.Stub.asInterface.call(binder);
        }
        return ApplicationThreadNative.asInterface.call(binder);
    }
}
