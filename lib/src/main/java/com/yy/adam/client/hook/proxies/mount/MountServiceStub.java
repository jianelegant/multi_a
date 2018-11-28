package com.yy.adam.client.hook.proxies.mount;

import android.os.IInterface;

import com.yy.adam.client.hook.base.Inject;
import com.yy.adam.client.hook.base.BinderInvocationProxy;
import com.yy.adam.helper.compat.BuildCompat;

import mirror.RefStaticMethod;
import mirror.android.os.mount.IMountService;
import mirror.android.os.storage.IStorageManager;

/**
 * @author yy
 */
@Inject(MethodProxies.class)
public class MountServiceStub extends BinderInvocationProxy {

    public MountServiceStub() {
        super(getInterfaceMethod(), "mount");
    }

    private static RefStaticMethod<IInterface> getInterfaceMethod() {
        if (BuildCompat.isOreo()) {
            return IStorageManager.Stub.asInterface;
        } else {
            return IMountService.Stub.asInterface;
        }
    }
}
