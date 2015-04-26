package com.smarthome.jw.smarthome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;

import com.smarthome.jw.smarthome.Devices.Gerät;
import com.smarthome.jw.smarthome.Devices.Licht;
import com.smarthome.jw.smarthome.InputOutput.FileIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by jonas on 16.04.15.
 */
public class LoadScreen extends Activity {

    public boolean isDataLoaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_layout);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        FileIO fileIO = new FileIO(getApplicationContext());
        ArrayList<String> strList= new ArrayList<String>();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileIO.readAsset("Devices.txt")));

            String mLine = "";
            while ((mLine = reader.readLine()) != null) {

                strList.add(mLine);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

       ArrayList<Gerät> gerätArrayList = new ArrayList<Gerät>();
       String [] device = null;

        for (int i = 0; i < strList.size() - 1 ; i++) {

            device = strList.get(i).split(",");
            if (device[0].equalsIgnoreCase("Light")) {

                gerätArrayList.add(new Licht(device[0],device[1],device[2],device[3]));
            }

        }



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent mainIntent = new Intent(LoadScreen.this, Home.class);
                LoadScreen.this.startActivity(mainIntent);
                LoadScreen.this.finish();
            }
        }, 3000);


    }


}



