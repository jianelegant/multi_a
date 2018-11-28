// IBinderDelegateService.aidl
package com.yy.adam.server;

import android.content.ComponentName;

interface IBinderDelegateService {

   ComponentName getComponent();

   IBinder getService();

}
