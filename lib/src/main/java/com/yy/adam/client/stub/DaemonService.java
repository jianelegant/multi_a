package com.yy.adam.client.stub;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;


/**
 * @author Lody
 *
 */
public class DaemonService extends Service {

    private static final int NOTIFY_ID = 1001;

	public static void startup(Context context) {
		context.startService(new Intent(context, DaemonService.class));
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		startup(this);
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
        startService(new Intent(this, InnerService.class));
		startForegroundCompat(this);

	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return START_STICKY;
	}

	public static final class InnerService extends Service {

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
			startForegroundCompat(this);
            stopForeground(true);
            stopSelf();
            return super.onStartCommand(intent, flags, startId);
        }

		@Override
		public IBinder onBind(Intent intent) {
			return null;
		}
	}

	private static void startForegroundCompat(Service context) {
		String channelId = "";
		Notification.Builder builder;
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			channelId = createNotificationChannel(context, "my_service", "My_Background_Service");
			builder = new Notification.Builder(context, channelId);
		} else {
			builder = new Notification.Builder(context);
		}

		context.startForeground(NOTIFY_ID, builder.build());
	}

	@TargetApi(Build.VERSION_CODES.O)
	private static String createNotificationChannel(Context context, String channelId, String channelName) {
		NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_NONE);
		((NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE)).createNotificationChannel(channel);
		return channel.getId();
	}
}
