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
    }

    public Page(String name, Device device) {
       Name = name;
       Devices.add(device);
    }

    public Page(String name, ArrayList<Device> devices) {
        Name = name;
        Devices.addAll(devices);
    }

    public boolean AddDevice(Device device) {

        Devices.add(device);
        return true;
    }


}
