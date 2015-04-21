package com.smarthome.jw.smarthome.Screen;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.smarthome.jw.smarthome.Controls.Page;
import com.smarthome.jw.smarthome.R;
import com.smarthome.jw.smarthome.Views.ControlView;

/**
 * Created by jonas on 16.04.15.
 */
public class OverviewScreen extends Activity {

    public Page page;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        page = new Page("First");
        ControlView controlView = new ControlView(this,page);
         setContentView(controlView);

    }

}
