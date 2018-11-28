package com.yy.adam.client.hook.proxies.dropbox;

import android.content.Context;

import com.yy.adam.client.hook.base.BinderInvocationProxy;
import com.yy.adam.client.hook.base.ResultStaticMethodProxy;

import mirror.com.android.internal.os.IDropBoxManagerService;

/**
 * @author yy
 */
public class DropBoxManagerStub extends BinderInvocationProxy {
	public DropBoxManagerStub() {
		super(IDropBoxManagerService.Stub.asInterface, Context.DROPBOX_SERVICE);
	}

	@Override
	protected void onBindMethods() {
		super.onBindMethods();
		addMethodProxy(new ResultStaticMethodProxy("getNextEntry", null));
	}
}
