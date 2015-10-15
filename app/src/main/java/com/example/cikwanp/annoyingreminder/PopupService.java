package com.example.cikwanp.annoyingreminder;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class PopupService extends Service {

    private WindowManager windowManager;
    private ImageView chatHead;
    ScreenReceiver receiver = new ScreenReceiver();

    @Override
    public void onCreate() {
        super.onCreate();

        IntentFilter filter = new IntentFilter("android.intent.action.USER_PRESENT");
        registerReceiver(receiver, filter);

        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        chatHead = new ImageView(this);
        chatHead.setImageResource(R.drawable.popups);

        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL;
        params.x = 0;
        params.y = 0;

        chatHead.animate().alpha(0.2f).scaleX(0.1f).scaleY(0.1f);

        windowManager.addView(chatHead, params);

        chatHead.animate().alpha(0.2f).scaleX(0.1f).scaleY(0.1f);


        chatHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chatHead.animate().alpha(0.2f).scaleX(0.1f).scaleY(0.1f);
                windowManager.removeView(chatHead);
                stopSelf();
            }
        });


    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        //if (chatHead != null) windowManager.removeView(chatHead);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
