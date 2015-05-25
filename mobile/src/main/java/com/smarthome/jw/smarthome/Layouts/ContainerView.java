package com.smarthome.jw.smarthome.Layouts;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.LinearLayout;

import com.smarthome.jw.smarthome.Devices.Gerät;

import java.util.ArrayList;

/**
 * Created by jonas on 26.05.15.
 */
public class ContainerView extends LinearLayout {

    private Page Page;

    public ContainerView(Context context, String name, ArrayList<Gerät> devices,String viewType) {
        super(context);

        Page = new Page(context, name, devices,viewType);
        addView(Page);
    }

    public void Update() {

        Page.UpdateDevices();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < getChildCount() - 1 ; i++) {
            if (getChildAt(i) instanceof Page ) {

                getChildAt(i).draw(canvas);
            }
        }
    }
}
