package com.smarthome.jw.smarthome.Template;

import android.graphics.Rect;

import java.util.ArrayList;

/**
 * Created by jonas on 19.04.15.
 */
public class Template {

    private Integer NumOfDevices;

    public ArrayList<Rect> Rect = new ArrayList<Rect>();

    public Template(Integer numOfDevices) {

        NumOfDevices = numOfDevices;
    }
}
