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

import com.smarthome.jw.smarthome.Devices.Gerät;

import java.util.ArrayList;

/**
 * Created by jonas on 19.04.15.
 */
public class Template extends GridLayout {

    private Integer NumOfDevices;
    public Double Margin;
    public Double ScaleFaktor;
    public Integer DeviceColunms;
    public DisplayMetrics displayMetrics;

    public boolean isLandscape;

    public ArrayList<RelativeRect> DeviceRect = new ArrayList<RelativeRect>();

    private final Integer dx= 100;
    private final Integer dy= 100;


    public Template(Context context) {
        super(context);
    }



    public Template(Context context, Integer numOfDevices) {
        super(context);
        Margin = 0.02;
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        displayMetrics = new DisplayMetrics();
        Point point = new Point();
        Display display = wm.getDefaultDisplay();
        display.getSize(point);
        display.getMetrics(displayMetrics);

        ScaleFaktor = (double) displayMetrics.density;






        setTemplateSize(numOfDevices);
    }

    public void setTemplateSize(Integer numOfDevices) {

        DeviceRect.clear();
        NumOfDevices = numOfDevices;
        Double displayWidth = (double) displayMetrics.widthPixels;
        Double sideMargin = displayMetrics.widthPixels * Margin * 2 + ((double)NumOfDevices - 1.0) * Margin;
        Double deviceWidth = dx * ScaleFaktor + displayMetrics.widthPixels * Margin ;

        long devicesCol = Math.round(displayWidth / deviceWidth);

        double devicesWidth = deviceWidth * devicesCol;



    }

    public void setDeviceColunms() {


    }


    public ArrayList<RelativeRect> getDoubleTemplate() {

        ArrayList<RelativeRect> relRect = new ArrayList<RelativeRect>();

        relRect.add(new RelativeRect(0.0 + Margin, 0.0 + Margin, 0.5 - Margin, 1.0 - Margin));
        relRect.add(new RelativeRect(0.5 + Margin, 0.0 + Margin, 1.0 - Margin, 1.0 - Margin));

        return relRect;

    }

    public void UpdateTemplate(Integer numOfDevices) {

        setTemplateSize(numOfDevices);



    }

    public RelativeRect getDeviceRect(int i) {

        return DeviceRect.get(i);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        Rect aRect = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
        int X = aRect.centerX();
        int Y = aRect.centerY();
        int k = 0;
        for (int j = 0; j < getChildCount(); j++) {
            View view2 = getChildAt(j);
            Rect bRect = new Rect(0, 0 + k * (150), 300, 0 + k * (150) + 150);
            if (view2 instanceof Gerät) {
                k = k + 1;
                Gerät gerät = (Gerät) view2;
                gerät.Draw(canvas, bRect);
            }
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = 3000 + 50;
        setMeasuredDimension(width, height);
    }




}
