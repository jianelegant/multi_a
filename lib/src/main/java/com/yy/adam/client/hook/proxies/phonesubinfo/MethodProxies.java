package com.yy.adam.client.hook.proxies.phonesubinfo;

import com.yy.adam.client.hook.base.MethodProxy;
import com.yy.adam.helper.utils.marks.FakeDeviceMark;

import java.lang.reflect.Method;

/**
 * @author yy
 */
@SuppressWarnings("ALL")
class MethodProxies {

    @FakeDeviceMark("fake device id")
    static class GetDeviceId extends MethodProxy {

        @Override
        public String getMethodName() {
            return "getDeviceId";
        }

        @Override
        public Object call(Object who, Method method, Object... args) throws Throwable {
            return getDeviceInfo().deviceId;
        }
    }

    static class GetDeviceIdForSubscriber extends GetDeviceId {

        @Override
        public String getMethodName() {
            return "getDeviceIdForSubscriber";
        }

    }

    @FakeDeviceMark("fake iccid")
    static class GetIccSerialNumber extends MethodProxy {

        @Override
        public String getMethodName() {
            return "getIccSerialNumber";
        }

        @Override
        public Object call(Object who, Method method, Object... args) throws Throwable {
            return getDeviceInfo().iccId;
        }
    }


    static class getIccSerialNumberForSubscriber extends GetIccSerialNumber {
        @Override
        public String getMethodName() {
            return "getIccSerialNumberForSubscriber";
        }
    }
}
