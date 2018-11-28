package com.yy.adam.multi.splash;

import android.os.Bundle;
import android.view.WindowManager;

import com.yy.adam.client.core.VirtualCore;

import com.yy.adam.multi.R;
import com.yy.adam.multi.VCommends;
import com.yy.adam.multi.abs.ui.VActivity;
import com.yy.adam.multi.abs.ui.VUiKit;
import com.yy.adam.multi.home.HomeActivity;
import jonathanfinerty.once.Once;

public class SplashActivity extends VActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        @SuppressWarnings("unused")
        boolean enterGuide = !Once.beenDone(Once.THIS_APP_INSTALL, VCommends.TAG_NEW_VERSION);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        VUiKit.defer().when(() -> {
            if (!Once.beenDone("collect_flurry")) {
                Once.markDone("collect_flurry");
            }
            long time = System.currentTimeMillis();
            doActionInThread();
            time = System.currentTimeMillis() - time;
            long delta = 3000L - time;
            if (delta > 0) {
//                VUiKit.sleep(delta);
            }
        }).done((res) -> {
            HomeActivity.goHome(this);
            finish();
        });
    }


    private void doActionInThread() {
        if (!VirtualCore.get().isEngineLaunched()) {
            VirtualCore.get().waitForEngine();
        }
    }
}
