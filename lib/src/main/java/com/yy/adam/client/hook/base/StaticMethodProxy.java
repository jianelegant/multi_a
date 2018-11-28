package com.yy.adam.client.hook.base;

/**
 * @author yy
 */

public class StaticMethodProxy extends MethodProxy {

	private String mName;

	public StaticMethodProxy(String name) {
		this.mName = name;
	}

	@Override
	public String getMethodName() {
		return mName;
	}
}
