package com.smarthome.jw.smarthome.Devices;

import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by jonas on 26.04.15.
 */
public class Heizung extends Gerät {

    private String temperatur;
    private String luftfeuchtigkeit;

    public Heizung(String type, String name, String roomAlias, String nameAlias) {
        super(type, name, roomAlias, nameAlias);


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
    public void Update() {

    }
}
