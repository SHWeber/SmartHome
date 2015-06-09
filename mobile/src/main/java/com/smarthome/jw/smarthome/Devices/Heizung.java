package com.smarthome.jw.smarthome.Devices;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by jonas on 26.04.15.
 */
public class Heizung extends Gerät {

    private String temperatur;
    private String luftfeuchtigkeit;

    public Heizung(Context context,String type, String name, String roomAlias, String nameAlias) {
        super(context,type, name, roomAlias, nameAlias);


    }

    @Override
    public boolean Draw(Canvas canvas, Rect rect) {
        return false;
    }

    @Override
    public boolean setState(String state) {
        return false;
    }

    @Override
    public String getState() {
        return null;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        invalidate();
        return false;
    }


    @Override
    public void processFinish(String output) {

    }


    @Override
    public void UpdateAsync() {

    }

    @Override
    public void UpdateSync() {

    }
}
