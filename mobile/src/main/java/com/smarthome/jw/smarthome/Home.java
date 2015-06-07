package com.smarthome.jw.smarthome;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.smarthome.jw.smarthome.Devices.Gerät;
import com.smarthome.jw.smarthome.InputOutput.HttpIO;
import com.smarthome.jw.smarthome.InputOutput.ReadFile;
import com.smarthome.jw.smarthome.Layouts.ContainerView;
import com.smarthome.jw.smarthome.Layouts.Page;

import java.util.ArrayList;

/**
 * Created by jonas on 22.04.15.
 */
public class Home extends Activity {

    private ContainerView containerView;
    private ReadFile readFile;

    WakeLock wakeLock;

    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = getApplicationContext();
        //setContentView(R.layout.overview_layout);





        readFile = new ReadFile(context);

        ArrayList<Gerät> GeräteListe = readFile.getRoomGeräte("Wohnzimmer");

        if (getResources().getBoolean(R.bool.isTablet)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
            containerView = new ContainerView(context,"First",GeräteListe,"GridView");
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            containerView = new ContainerView(context,"First",GeräteListe,"ListView");
        }

        setContentView(containerView);

        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "Motion");
        containerView.Update();

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
        containerView.Update();
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





