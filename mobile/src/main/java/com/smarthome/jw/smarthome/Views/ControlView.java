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

    public ControlView(Context context, com.smarthome.jw.smarthome.Layouts.Page newPageScroll) {
        super(context);
        Page = newPageScroll;
       // Page.AddDevice(new Light("WZ","Wandlampe_L","Light","Wohnzimmer","Wandlampe Links"));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


    }
}
