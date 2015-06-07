package com.smarthome.jw.smarthome.Template;



import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.BoringLayout;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.smarthome.jw.smarthome.Devices.Gerät;

import java.util.ArrayList;

/**
 * Created by jonas on 19.04.15.
 */
public class Template extends LinearLayout {

    private Integer NumOfDevices;
    private Integer Margin;
    private Double MarginRel;
    public Double ScaleFaktor;
    public DisplayMetrics displayMetrics;

    public boolean isLandscape;

    public ArrayList<Rect> DeviceRect = new ArrayList<Rect>();


    public Template(Context context) {
        super(context);

        MarginRel = 5.0;
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        displayMetrics = new DisplayMetrics();
        Point point = new Point();

        Display display = wm.getDefaultDisplay();
        display.getSize(point);
        display.getMetrics(displayMetrics);

        ScaleFaktor = (double) displayMetrics.density;

        Double margin = ScaleFaktor * MarginRel;
        Margin = margin.intValue();
    }


    public Rect getDeviceRect(int i) {

        return DeviceRect.get(i);
    }

    public void AddRect(int x, int y) {

        Double width = x * ScaleFaktor;
        Double height = y * ScaleFaktor;

        int minWidth = width.intValue() + 2 * Margin;
        int minHeight = height.intValue() + 2 * Margin;

        if(DeviceRect.size() == 0) {

            DeviceRect.add(new Rect(Margin+0,0+Margin,0+width.intValue()+Margin,height.intValue()+Margin));
        } else {

            Rect rect = DeviceRect.get(DeviceRect.size() - 1);

            if ((rect.right + minWidth ) < displayMetrics.widthPixels ) {
                DeviceRect.add(new Rect(rect.right + Margin+0,rect.top,rect.right+Margin+0+width.intValue(),rect.top+height.intValue()));
            } else {
                DeviceRect.add(new Rect(Margin+0,rect.bottom +Margin,Margin+0+width.intValue(),Margin+height.intValue()+rect.bottom));
            }
        }
    }

    public boolean DeleteRect(int index) {
        if(index < DeviceRect.size()) {

            return true;
        }
        return true;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = 3000 + 50;
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        for (int j = 0; j < getChildCount(); j++) {
            View view2 = getChildAt(j);
            if (view2 instanceof Gerät) {
                Gerät gerät = (Gerät) view2;
                gerät.Draw(canvas, getDeviceRect(j));
            }
        }

    }




}
