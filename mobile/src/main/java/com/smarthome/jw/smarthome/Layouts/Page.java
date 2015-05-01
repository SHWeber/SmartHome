package com.smarthome.jw.smarthome.Layouts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.widget.GridView;
import android.widget.ScrollView;

import com.smarthome.jw.smarthome.Devices.Gerät;
import com.smarthome.jw.smarthome.Devices.Licht;
import com.smarthome.jw.smarthome.Template.RelativeRect;
import com.smarthome.jw.smarthome.Template.Template;

import java.util.ArrayList;

/**
 * Created by jonas on 19.04.15.
 */
public class Page extends View {

    public ArrayList<Gerät> Devices = new ArrayList<Gerät>();
    public Template Template;
    public String Name;
    public GridView gridView;
    public ScrollView scrollView;

    public Page(Context context,String name) {
        super(context);
        Name = name;
        Template = new Template();
        Devices.clear();
        gridView = new GridView(context);
        scrollView = new ScrollView(context);

    }

    public boolean AddDevice(Gerät device) {

        Devices.add(device);
        Template.setTemplate(Devices.size());
        return true;
    }

    public boolean UpdatePageState() {

        for (int i = 0; i < Devices.size() ; i++) {

            Devices.get(i).Update();


        }

        return true;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Template.setTemplate(Devices.size());
        UpdatePageState();

        for (int i = 0; i < Devices.size(); i++) {
            Rect aRect = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
            RelativeRect relativeRect = Template.RelRect.get(i);
            Rect bRect = relativeRect.CalcRect(aRect);

            Gerät gerät = Devices.get(i);
            Licht light = (Licht) gerät;

            light.Draw(canvas, bRect);
        }

    }





}
