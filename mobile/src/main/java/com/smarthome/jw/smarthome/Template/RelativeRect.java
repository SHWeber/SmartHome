package com.smarthome.jw.smarthome.Template;

import android.graphics.Rect;

import java.math.RoundingMode;

/**
 * Created by jonas on 19.04.15.
 */
public class RelativeRect {

    public Double Top;
    public Double Bottom;
    public Double Left;
    public Double Right;

    public RelativeRect(Double top, Double left,Double bottom, Double right) {

        Top = top;
        Bottom = bottom;
        Left = left;
        Right = right;
    }


    public Rect CalcRect(Rect rect) {

        Rect saveRect = new Rect(rect);
        Double fHeight = 1.0 * saveRect.height();
        Double fWidth = 1.0 * saveRect.width();
        rect.top = new Double(fHeight * Top).intValue();
        rect.bottom = new Double(fHeight * Bottom).intValue();

        rect.left = new Double(fWidth * Left).intValue();
        rect.right = new Double(fWidth * Right).intValue();

        return rect;
    }


}
