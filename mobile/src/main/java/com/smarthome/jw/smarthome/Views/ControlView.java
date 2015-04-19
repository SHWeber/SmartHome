package com.smarthome.jw.smarthome.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

import com.smarthome.jw.smarthome.Device.Device;
import com.smarthome.jw.smarthome.Template.Template;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 19.04.15.
 */
public class ControlView extends View {

    private ArrayList<Device> Devices = new ArrayList<Device>();
    private Template Template;

    public ControlView(Context context) {
        super(context);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for(int i = 0; i < Devices.size() - 1; i++) {

            Devices.get(i).Draw(canvas, Template.Rect.get(i));
        }
    }
}
