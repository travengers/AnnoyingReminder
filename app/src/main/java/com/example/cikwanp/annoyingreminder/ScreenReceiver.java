package com.example.cikwanp.annoyingreminder;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Bagus on 10/6/2015.
 */
public class ScreenReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("android.intent.action.USER_PRESENT")){
            Intent i = new Intent(context,AnnoyingService.class);
            context.startService(i);

            Intent pop = new Intent(context,PopupService.class);
            context.startService(pop);

        }
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
        if (keyguardManager.isKeyguardSecure()) {
            Intent i = new Intent(context, AnnoyingService.class);
            context.startService(i);

            Intent pop = new Intent(context,PopupService.class);
            context.startService(pop);
        }
    }
}
