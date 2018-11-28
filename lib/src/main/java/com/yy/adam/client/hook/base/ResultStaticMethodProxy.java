package com.yy.adam.client.hook.base;

import java.lang.reflect.Method;

/**
 * @author yy
 */

public class ResultStaticMethodProxy extends StaticMethodProxy {

	Object mResult;

	public ResultStaticMethodProxy(String name, Object result) {
		super(name);
		mResult = result;
	}

	public Object getResult() {
		return mResult;
	}

	@Override
	public Object call(Object who, Method method, Object... args) throws Throwable {
		return mResult;
	}
}
