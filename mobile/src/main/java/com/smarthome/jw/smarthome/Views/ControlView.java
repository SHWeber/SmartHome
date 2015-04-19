package com.smarthome.jw.smarthome.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import com.smarthome.jw.smarthome.Controls.Device;
import com.smarthome.jw.smarthome.Controls.Page;
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


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for(int i = 0; i < Page.Devices.size() - 1; i++) {

            Page.Devices.get(i).Draw(canvas, Page.Template.Rect.get(i));
        }
    }
}
