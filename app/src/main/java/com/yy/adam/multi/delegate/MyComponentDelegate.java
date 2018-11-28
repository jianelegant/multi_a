package com.yy.adam.multi.delegate;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;

import com.yy.adam.client.hook.delegate.ComponentDelegate;
import com.yy.adam.helper.utils.Reflect;

import java.io.File;


public class MyComponentDelegate implements ComponentDelegate {

    @Override
    public void beforeApplicationCreate(Application application) {

    }

    @Override
    public void afterApplicationCreate(Application application) {

    }

    @Override
    public void beforeActivityCreate(Activity activity) {

    }

    @Override
    public void beforeActivityResume(Activity activity) {

    }

    @Override
    public void beforeActivityPause(Activity activity) {

    }

    @Override
    public void beforeActivityDestroy(Activity activity) {

    }

    @Override
    public void afterActivityCreate(Activity activity) {

    }

    @Override
    public void afterActivityResume(Activity activity) {

    }

    @Override
    public void afterActivityPause(Activity activity) {

    }

    @Override
    public void afterActivityDestroy(Activity activity) {

    }

    @Override
    public void onSendBroadcast(Intent intent) {

    }
}
