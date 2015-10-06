package com.example.cikwanp.annoyingreminder;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Bagus on 10/6/2015.
 */
public class AnnoyingService extends IntentService {

    public AnnoyingService() {
        super("AnnoyingService");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        IntentFilter filter = new IntentFilter(Intent.ACTION_USER_PRESENT);
        ScreenReceiver receiver = new ScreenReceiver();
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        createNotification(56,R.mipmap.ic_launcher,"tes","CARI KERJA");
    }

    public void launchService() {
        Intent intent = new Intent(this, AnnoyingService.class);
        intent.putExtra("foo", "bar");
        startService(intent);
    }

    private void createNotification(int nId, int iconRes, String title, String body) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                this).setSmallIcon(iconRes)
                .setContentTitle(title)
                .setContentText(body);

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // mId allows you to update the notification later on.
        mNotificationManager.notify(nId, mBuilder.build());
    }
}
