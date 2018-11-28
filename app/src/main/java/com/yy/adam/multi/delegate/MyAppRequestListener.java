package com.yy.adam.multi.delegate;

import android.content.Context;
import android.widget.Toast;

import com.yy.adam.client.core.InstallStrategy;
import com.yy.adam.client.core.VirtualCore;
import com.yy.adam.remote.InstallResult;

import java.io.IOException;

/**
 * @author yy
 */

public class MyAppRequestListener implements VirtualCore.AppRequestListener {

    private final Context context;

    public MyAppRequestListener(Context context) {
        this.context = context;
    }

    @Override
    public void onRequestInstall(String path) {
        Toast.makeText(context, "Installing: " + path, Toast.LENGTH_SHORT).show();
        InstallResult res = VirtualCore.get().installPackage(path, InstallStrategy.UPDATE_IF_EXIST);
        if (res.isSuccess) {
            try {
                VirtualCore.get().preOpt(res.packageName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (res.isUpdate) {
                Toast.makeText(context, "Update: " + res.packageName + " success!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Install: " + res.packageName + " success!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "Install failed: " + res.error, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestUninstall(String pkg) {
        Toast.makeText(context, "Uninstall: " + pkg, Toast.LENGTH_SHORT).show();

    }
}
