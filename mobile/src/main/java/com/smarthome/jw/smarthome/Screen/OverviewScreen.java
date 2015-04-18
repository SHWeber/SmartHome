package com.smarthome.jw.smarthome.Screen;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.smarthome.jw.smarthome.R;

/**
 * Created by jonas on 16.04.15.
 */
public class OverviewScreen extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.overview_layout);

    }

}
