package com.yy.adam.multi.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.widget.ImageView;
import android.widget.TextView;

import com.yy.adam.client.core.VirtualCore;
import com.yy.adam.client.ipc.VActivityManager;

import java.util.Locale;

import com.yy.adam.multi.R;
import com.yy.adam.multi.abs.ui.VActivity;
import com.yy.adam.multi.abs.ui.VUiKit;
import com.yy.adam.multi.home.models.PackageAppData;
import com.yy.adam.multi.home.repo.PackageAppDataStorage;
import com.yy.adam.multi.widgets.EatBeansView;

/**
 * @author Lody
 */

public class LoadingActivity extends VActivity {

    private static final String PKG_NAME_ARGUMENT = "MODEL_ARGUMENT";
    private static final String KEY_INTENT = "KEY_INTENT";
    private static final String KEY_USER = "KEY_USER";
    private PackageAppData appModel;
    private EatBeansView loadingView;

    public static void launch(Context context, String packageName, int userId) {
        Intent intent = VirtualCore.get().getLaunchIntent(packageName, userId);
        if (intent != null) {
            Intent loadingPageIntent = new Intent(context, LoadingActivity.class);
            loadingPageIntent.putExtra(PKG_NAME_ARGUMENT, packageName);
            loadingPageIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            loadingPageIntent.putExtra(KEY_INTENT, intent);
            loadingPageIntent.putExtra(KEY_USER, userId);
            context.startActivity(loadingPageIntent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        loadingView = (EatBeansView) findViewById(R.id.loading_anim);
        int userId = getIntent().getIntExtra(KEY_USER, -1);
        String pkg = getIntent().getStringExtra(PKG_NAME_ARGUMENT);
        appModel = PackageAppDataStorage.get().acquire(pkg);
        ImageView iconView = (ImageView) findViewById(R.id.app_icon);
        iconView.setImageDrawable(appModel.icon);
        TextView nameView = (TextView) findViewById(R.id.app_name);
        nameView.setText(String.format(Locale.ENGLISH, "Opening %s...", appModel.name));
        Intent intent = getIntent().getParcelableExtra(KEY_INTENT);
        if (intent == null) {
            return;
        }
        VirtualCore.get().setUiCallback(intent, mUiCallback);
        VUiKit.defer().when(() -> {
            if (!appModel.fastOpen) {
                try {
                    VirtualCore.get().preOpt(appModel.packageName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            VActivityManager.get().startActivity(intent, userId);
        });

    }

    private final VirtualCore.UiCallback mUiCallback = new VirtualCore.UiCallback() {

        @Override
        public void onAppOpened(String packageName, int userId) throws RemoteException {
            finish();
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        loadingView.startAnim();
    }

    @Override
    protected void onPause() {
        super.onPause();
        loadingView.stopAnim();
    }
}
