package com.smarthome.jw.smarthome.Template;



import android.content.Context;
import android.graphics.Rect;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by jonas on 19.04.15.
 */
public class Template{

    private Integer NumOfDevices;
    public Double Margin;

    public ArrayList<RelativeRect> RelRect = new ArrayList<RelativeRect>();

    public Template() {
        NumOfDevices = 0;
        Margin = 0.02;
        RelRect.clear();
    }

    public void setTemplate(Integer numOfDevices) {

        NumOfDevices = numOfDevices;

        RelRect = getDoubleTemplate();
        /** for (int i = 0; i < numOfDevices ; i++) {
         }*/

    }


    public ArrayList<RelativeRect> getDoubleTemplate() {

        ArrayList<RelativeRect> relRect = new ArrayList<RelativeRect>();

        relRect.add(new RelativeRect(0.0 + Margin, 0.0 + Margin, 0.5 - Margin, 1.0 - Margin));
        relRect.add(new RelativeRect(0.5 + Margin, 0.0 + Margin, 1.0 - Margin, 1.0 - Margin));

        return relRect;

    }







    public RelativeRect getRelRect(int i) {
        return RelRect.get(i);
    }
}
