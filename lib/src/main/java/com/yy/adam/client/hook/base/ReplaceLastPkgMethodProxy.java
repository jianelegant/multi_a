package com.yy.adam.client.hook.base;

import java.lang.reflect.Method;

import com.yy.adam.client.hook.utils.MethodParameterUtils;

/**
 * @author yy
 */

public class ReplaceLastPkgMethodProxy extends StaticMethodProxy {

	public ReplaceLastPkgMethodProxy(String name) {
		super(name);
	}

	@Override
	public boolean beforeCall(Object who, Method method, Object... args) {
		MethodParameterUtils.replaceLastAppPkg(args);
		return super.beforeCall(who, method, args);
	}
}
