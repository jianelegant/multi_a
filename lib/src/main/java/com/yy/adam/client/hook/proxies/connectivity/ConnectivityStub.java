package com.yy.adam.client.hook.proxies.connectivity;

import android.content.Context;

import com.yy.adam.client.hook.base.BinderInvocationProxy;
import com.yy.adam.client.hook.base.MethodProxy;
import com.yy.adam.client.hook.base.ReplaceLastPkgMethodProxy;
import com.yy.adam.client.hook.base.StaticMethodProxy;
import com.yy.adam.client.ipc.ServiceManagerNative;

import java.lang.reflect.Method;

import mirror.android.net.IConnectivityManager;

/**
 * @author legency
 */
public class ConnectivityStub extends BinderInvocationProxy {

    public ConnectivityStub() {
        super(IConnectivityManager.Stub.asInterface, Context.CONNECTIVITY_SERVICE);
    }

    @Override
    protected void onBindMethods() {
        super.onBindMethods();
    }
}
