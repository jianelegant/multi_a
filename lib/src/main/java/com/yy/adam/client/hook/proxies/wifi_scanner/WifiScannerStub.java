package com.yy.adam.client.hook.proxies.wifi_scanner;

import com.yy.adam.client.hook.base.BinderInvocationProxy;

/**
 * @author Lody
 */

public class WifiScannerStub extends BinderInvocationProxy {

    public WifiScannerStub() {
        super(new GhostWifiScannerImpl(), "wifiscanner");
    }

}
