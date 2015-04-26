package com.smarthome.jw.smarthome.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

import com.smarthome.jw.smarthome.Devices.Gerät;
import com.smarthome.jw.smarthome.Devices.Licht;
import com.smarthome.jw.smarthome.Template.RelativeRect;

/**
 * Created by jonas on 19.04.15.
 */
public class ControlView extends View {


    private String test = "test";
    private com.smarthome.jw.smarthome.Layouts.Page Page;

    public ControlView(Context context, com.smarthome.jw.smarthome.Layouts.Page newPage) {
        super(context);
        Page = newPage;
       // Page.AddDevice(new Light("WZ","Wandlampe_L","Light","Wohnzimmer","Wandlampe Links"));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Page.Template.setTemplate(Page.Devices.size());

        for(int i = 0; i < Page.Devices.size(); i++) {
            Rect aRect = new Rect(0,0,canvas.getWidth(),canvas.getHeight());
            RelativeRect relativeRect =  Page.Template.RelRect.get(i);
            Rect bRect = relativeRect.CalcRect(aRect);

            Gerät gerät = Page.Devices.get(i);
            Licht light = (Licht) gerät;
            light.Draw(canvas, bRect);
        }
    }
}
