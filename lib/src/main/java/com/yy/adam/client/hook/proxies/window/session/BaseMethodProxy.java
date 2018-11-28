package com.yy.adam.client.hook.proxies.window.session;

import android.view.WindowManager;

import com.yy.adam.client.hook.base.StaticMethodProxy;
import com.yy.adam.helper.utils.ArrayUtils;

import java.lang.reflect.Method;

/**
 * @author yy
 */
/*package*/ class BaseMethodProxy extends StaticMethodProxy {

    public BaseMethodProxy(String name) {
        super(name);
    }

    @Override
    public Object call(Object who, Method method, Object... args) throws Throwable {
        int index = ArrayUtils.indexOfFirst(args, WindowManager.LayoutParams.class);
        if (index != -1) {
            WindowManager.LayoutParams attrs = (WindowManager.LayoutParams) args[index];
            if (attrs != null) {
                attrs.packageName = getHostPkg();
            }
        }
        return method.invoke(who, args);
    }
}
