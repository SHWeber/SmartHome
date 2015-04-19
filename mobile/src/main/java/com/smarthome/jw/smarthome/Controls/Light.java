package com.smarthome.jw.smarthome.Controls;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Collection;

/**
 * Created by jonas on 19.04.15.
 */
public class Light extends Device {

    public Light() {

    }

    @Override
    public boolean Draw(Canvas canvas, Rect rect) {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rect,paint);


        return false;
    }
}
