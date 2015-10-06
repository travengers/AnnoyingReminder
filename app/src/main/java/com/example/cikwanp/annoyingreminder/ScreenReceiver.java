package com.example.cikwanp.annoyingreminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Bagus on 10/6/2015.
 */
public class ScreenReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_USER_PRESENT)){
            Intent i = new Intent(context,AnnoyingService.class);
            context.startService(i);
        }
    }
}
