package com.example.cikwanp.annoyingreminder;

import android.app.Activity;
import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Bagus on 10/6/2015.
 */
public class AnnoyingService extends IntentService {

    public AnnoyingService() {
        super("AnnoyingService");
    }

    ScreenReceiver receiver = new ScreenReceiver();

    @Override
    public void onCreate() {
        super.onCreate();

        IntentFilter filter = new IntentFilter("android.intent.action.USER_PRESENT");

        registerReceiver(receiver, filter);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        unregisterReceiver(receiver);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        createNotification(56, R.mipmap.ic_launcher, "tes", "CARI KERJA");
    }

   /* public MainActivity activity;
    public void launchService() {
        Intent intent = new Intent(this.activity, AnnoyingService.class);
        intent.putExtra("foo", "bar");
        startService(intent);
    }*/

    private void createNotification(int nId, int iconRes, String title, String body) {
        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                this).setSmallIcon(iconRes)
                .setContentTitle(title)
                .setContentText(body)
                .setSound(soundUri);

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // mId allows you to update the notification later on.
        mNotificationManager.notify(nId, mBuilder.build());
    }
}
