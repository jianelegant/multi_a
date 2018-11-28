package com.yy.adam.client.hook.base;

import java.lang.reflect.Method;

import com.yy.adam.client.hook.utils.MethodParameterUtils;

/**
 * @author Lody
 */

public class ReplaceCallingPkgMethodProxy extends StaticMethodProxy {

	public ReplaceCallingPkgMethodProxy(String name) {
		super(name);
	}

	@Override
	public boolean beforeCall(Object who, Method method, Object... args) {
		MethodParameterUtils.replaceFirstAppPkg(args);
		return super.beforeCall(who, method, args);
	}
}
