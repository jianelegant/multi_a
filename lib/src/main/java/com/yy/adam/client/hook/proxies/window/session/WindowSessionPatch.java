package com.yy.adam.client.hook.proxies.window.session;

import android.os.IInterface;

import com.yy.adam.client.hook.base.MethodInvocationProxy;
import com.yy.adam.client.hook.base.MethodInvocationStub;
import com.yy.adam.client.hook.base.ReplaceCallingPkgMethodProxy;

/**
 * @author Lody
 */
public class WindowSessionPatch extends MethodInvocationProxy<MethodInvocationStub<IInterface>> {

	public WindowSessionPatch(IInterface session) {
		super(new MethodInvocationStub<>(session));
	}

	@Override
	public void onBindMethods() {
		addMethodProxy(new BaseMethodProxy("add"));
		addMethodProxy(new BaseMethodProxy("addToDisplay"));
		addMethodProxy(new BaseMethodProxy("addToDisplayWithoutInputChannel"));
		addMethodProxy(new BaseMethodProxy("addWithoutInputChannel"));
		addMethodProxy(new BaseMethodProxy("relayout"));
	}


	@Override
	public void inject() throws Throwable {
		// <EMPTY>
	}

	@Override
	public boolean isEnvBad() {
		return getInvocationStub().getProxyInterface() != null;
	}
}
