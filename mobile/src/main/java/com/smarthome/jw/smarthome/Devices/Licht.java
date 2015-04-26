package com.smarthome.jw.smarthome.Devices;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.smarthome.jw.smarthome.InputOutput.HttpIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jonas on 19.04.15.
 */
public class Licht extends Gerät {


    private String actState;

    public Licht(String type, String name, String roomAlias, String nameAlias) {
        super(type,name,roomAlias,nameAlias);

        actState = null;

    }



    @Override
    public boolean setState(String state) {
        if (state != null)  {

            actState = state;
            setUpdated(true);
            return true;
        }
        else {

            setUpdated(false);
            return false;
        }
    }


    @Override
    public String getState() {
        return actState;
    }

    @Override
    public boolean Draw(Canvas canvas, Rect rect) {
        if (actState != null) {

            int wdt = rect.centerX();
            int hgt = rect.centerY();
            Paint paint = new Paint();
            paint.setColor(Color.BLACK);
            paint.setTextSize(50);

            canvas.drawText(getNameAlias(), wdt, hgt, paint);
        }

        return false;
    }

    @Override
    public void Update() {

        HttpIO httpIO = new HttpIO();

        BufferedReader reader = null;
        String inputLine;

        try {
            reader = new BufferedReader(new InputStreamReader(httpIO.readLink(getName())));
            actState = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
