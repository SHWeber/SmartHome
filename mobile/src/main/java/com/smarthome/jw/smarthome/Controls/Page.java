package com.smarthome.jw.smarthome.Controls;

import com.smarthome.jw.smarthome.Template.Template;

import java.util.ArrayList;

/**
 * Created by jonas on 19.04.15.
 */
public class Page  {

    public  ArrayList<Device> Devices = new ArrayList<Device>();
    public  Template Template;
    public String Name;

    public Page(String name) {

        Name = name;
        Template = new Template();
        Devices.clear();
    }

    public Page(String name, Device device) {
       Name = name;
       Template = new Template();
       Devices.add(device);
    }

    public Page(String name, ArrayList<Device> devices) {

        Name = name;
        Template = new Template();
        for (int i = 0; i <devices.size(); i++) {
            AddDevice(devices.get(i));
        }
    }

    public boolean AddDevice(Device device) {

        Devices.add(device);
        Template.setTemplate(Devices.size());
        return true;
    }


}
