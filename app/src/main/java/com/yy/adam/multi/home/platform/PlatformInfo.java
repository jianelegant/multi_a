package com.yy.adam.multi.home.platform;

import android.content.pm.PackageInfo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yy
 */
public abstract class PlatformInfo {

    private final Set<String> platformPkgs = new HashSet<>();

    public PlatformInfo(String... pkgs) {
        Collections.addAll(platformPkgs, pkgs);
    }

    public abstract boolean relyOnPlatform(PackageInfo info);

}
