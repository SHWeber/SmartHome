package com.smarthome.jw.smarthome.Layouts;

import com.smarthome.jw.smarthome.Devices.Gerät;
import com.smarthome.jw.smarthome.Template.Template;

import java.util.ArrayList;

/**
 * Created by jonas on 19.04.15.
 */
public class Page {

    public  ArrayList<Gerät> Devices = new ArrayList<Gerät>();
    public  Template Template;
    public String Name;

    public Page(String name) {

        Name = name;
        Template = new Template();
        Devices.clear();
    }

    public Page(String name, Gerät gerät) {
       Name = name;
       Template = new Template();
       Devices.add(gerät);
    }

    public Page(String name, ArrayList<Gerät> devices) {

        Name = name;
        Template = new Template();
        for (int i = 0; i <devices.size(); i++) {
            AddDevice(devices.get(i));
        }
    }

    public boolean AddDevice(Gerät device) {

        Devices.add(device);
        Template.setTemplate(Devices.size());
        return true;
    }

    public boolean UpdatePage() {

        for (int i = 0; i < Devices.size() -1 ; i++) {

            Devices.get(i).Update();
        }

        return true;

    }


}
