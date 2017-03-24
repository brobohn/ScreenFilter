package com.brobohn.screenfilter;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by brobohn on 3/23/2017.
 */

public class MainService extends Service {
    ImageView filterView;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();

        filterView = new ImageView(this);
        filterView.setBackgroundColor(Color.rgb(255, 0, 0));

        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(.5f);
        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(cm);

        filterView.setColorFilter(filter);

        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
                0 | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        wm.addView(filterView, params);
    }

    public void onDestroy() {
        super.onDestroy();
        if(filterView !=null){
            WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
            wm.removeView(filterView);
        }

        filterView = null;
    }
}
