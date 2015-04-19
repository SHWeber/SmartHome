package com.smarthome.jw.smarthome.Screen;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.smarthome.jw.smarthome.R;

/**
 * Created by jonas on 16.04.15.
 */
public class LoadingScreen extends Activity {

    private boolean isLoaded = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(LoadingScreen.this, OverviewScreen.class);
                startActivity(i);

                finish();
            }
        }, 5000);
    }

}



