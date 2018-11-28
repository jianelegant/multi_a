package com.yy.adam.client.hook.base;

import java.lang.reflect.Method;

import com.yy.adam.client.hook.utils.MethodParameterUtils;

/**
 * @author yy
 */

public class ReplaceSequencePkgMethodProxy extends StaticMethodProxy {

	private int sequence;

	public ReplaceSequencePkgMethodProxy(String name, int sequence) {
		super(name);
		this.sequence = sequence;
	}

	@Override
	public boolean beforeCall(Object who, Method method, Object... args) {
		MethodParameterUtils.replaceSequenceAppPkg(args, sequence);
		return super.beforeCall(who, method, args);
	}
}
