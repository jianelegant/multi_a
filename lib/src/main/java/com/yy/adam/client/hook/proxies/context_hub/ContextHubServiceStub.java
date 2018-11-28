package com.yy.adam.client.hook.proxies.context_hub;

import android.os.Build;

import com.yy.adam.client.hook.base.BinderInvocationProxy;
import com.yy.adam.client.hook.base.ResultStaticMethodProxy;

import mirror.android.hardware.location.IContextHubService;

public class ContextHubServiceStub extends BinderInvocationProxy {

    public ContextHubServiceStub() {
        super(IContextHubService.Stub.asInterface, getServiceName());
    }

    private static String getServiceName() {
        return Build.VERSION.SDK_INT >= 26 ? "contexthub" : "contexthub_service";
    }

    @Override
    protected void onBindMethods() {
        super.onBindMethods();
        addMethodProxy(new ResultStaticMethodProxy("registerCallback", 0));
    }
}