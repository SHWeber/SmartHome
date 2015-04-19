package com.smarthome.jw.smarthome.Device;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by jonas on 19.04.15.
 */
public abstract class Device  {

    protected Device() {
    }

    abstract public boolean Draw(Canvas canvas, Rect rect);

}
