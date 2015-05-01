package com.smarthome.jw.smarthome;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;

import com.smarthome.jw.smarthome.Devices.Licht;
import com.smarthome.jw.smarthome.InputOutput.FileIO;
import com.smarthome.jw.smarthome.InputOutput.HttpIO;
import com.smarthome.jw.smarthome.Layouts.Page;
import com.smarthome.jw.smarthome.Views.ControlView;

/**
 * Created by jonas on 22.04.15.
 */
public class Home extends Activity {

    public Page page;

    Screen screen;
    FileIO fileIO;
    HttpIO httpIO;

    WakeLock wakeLock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = new Page(getApplicationContext(),"First");
        page.AddDevice(new Licht("Light","WZ_Vitrine","Wonhzimmer","Vitrine Licht"));
        page.AddDevice(new Licht("Light","WZ_Vitrine","Wonhzimmer","Vitrine Licht"));


        page.UpdatePageState();
        setContentView(page);

        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "Motion");




    }




}



