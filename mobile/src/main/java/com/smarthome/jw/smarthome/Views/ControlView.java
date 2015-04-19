package com.smarthome.jw.smarthome.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

import com.smarthome.jw.smarthome.Controls.Device;
import com.smarthome.jw.smarthome.Controls.Light;
import com.smarthome.jw.smarthome.Controls.Page;
import com.smarthome.jw.smarthome.Template.RelativeRect;
import com.smarthome.jw.smarthome.Template.Template;

import java.util.ArrayList;

/**
 * Created by jonas on 19.04.15.
 */
public class ControlView extends View {

    public Page Page;
    private String test = "test";

    public ControlView(Context context) {
        super(context);

        Page = new Page(test);
        Page.AddDevice(new Light());
        Page.AddDevice(new Light());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Page.Template.setTemplate(Page.Devices.size());

        for(int i = 0; i < Page.Devices.size(); i++) {
            Rect aRect = new Rect(0,0,canvas.getWidth(),canvas.getHeight());
            RelativeRect relativeRect =  Page.Template.RelRect.get(i);
            Rect bRect = relativeRect.CalcRect(aRect);

            Device device = Page.Devices.get(i);
            Light light = (Light) device;
            light.Draw(canvas, bRect);
        }
    }
}
