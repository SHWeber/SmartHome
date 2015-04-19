package com.smarthome.jw.smarthome.Template;



import android.graphics.Rect;

import java.util.ArrayList;

/**
 * Created by jonas on 19.04.15.
 */
public class Template {

    private Integer NumOfDevices;

    public ArrayList<RelativeRect> RelRect = new ArrayList<RelativeRect>();

    public Template() {

        NumOfDevices = 0;
    }


    public void setTemplate(Integer numOfDevices) {

        NumOfDevices = numOfDevices;
        RelRect.clear();

        for (int i = 0; i < NumOfDevices ; i++) {
            if (NumOfDevices > RelRect.size()) {
                RelRect.add(new RelativeRect(0.25,0.25,0.75,0.75));
            }

        }


    }

    public void calcTemplate() {

        for(int i = 0; i < NumOfDevices; i++) {
            RelRect.add(new RelativeRect(0.25,0.25,0.75,0.75));

        }
    }

    public RelativeRect getRelRect(int i) {
        return RelRect.get(i);
    }
}
