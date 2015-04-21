package com.smarthome.jw.smarthome.Controls;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.smarthome.jw.smarthome.Interfaces.Devices.LightInterface;

/**
 * Created by jonas on 19.04.15.
 */
public class Light extends Device implements LightInterface {


    private String actState;

    public Light(String room, String name,String type, String roomAlias, String nameAlias) {
        super(room, name,type,roomAlias,nameAlias);

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


}
