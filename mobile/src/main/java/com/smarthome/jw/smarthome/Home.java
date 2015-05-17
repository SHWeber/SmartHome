package com.smarthome.jw.smarthome;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

import com.smarthome.jw.smarthome.Devices.Gerät;
import com.smarthome.jw.smarthome.InputOutput.HttpIO;
import com.smarthome.jw.smarthome.InputOutput.ReadFile;
import com.smarthome.jw.smarthome.Layouts.Page;

import java.util.ArrayList;

/**
 * Created by jonas on 22.04.15.
 */
public class Home extends Activity {

    private Page page;
    private ReadFile readFile;

    WakeLock wakeLock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = getApplicationContext();
        setContentView(R.layout.overview_layout);

        readFile = new ReadFile(context);

        ArrayList<Gerät> GeräteListe = readFile.getRoomGeräte("Wohnzimmer");

        if (getResources().getBoolean(R.bool.isTablet)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
            page = new Page(context,"First",GeräteListe,"GridView");
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            page = new Page(context,"First",GeräteListe,"ListView");
        }

        setContentView(page);

        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "Motion");

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}



