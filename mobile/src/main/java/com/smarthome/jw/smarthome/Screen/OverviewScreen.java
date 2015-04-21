package com.smarthome.jw.smarthome.Screen;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.StrictMode;

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



        if (isNetworkAvailable(this)) {
            page = new Page("First");
            ControlView controlView = new ControlView(this,page);
            setContentView(controlView);

        } else {

            setContentView(R.layout.overview_layout);

        }


    }


    public boolean isNetworkAvailable(Context context) {

        ConnectivityManager cm = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }


}
