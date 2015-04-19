package com.smarthome.jw.smarthome.Controls;

import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by jonas on 19.04.15.
 */
public abstract class Device  {

    protected Device() {
    }

    abstract public boolean Draw(Canvas canvas, Rect rect);


}
