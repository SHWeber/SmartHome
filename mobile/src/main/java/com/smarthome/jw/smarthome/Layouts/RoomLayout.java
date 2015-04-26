package com.smarthome.jw.smarthome.Layouts;

import com.smarthome.jw.smarthome.Devices.Gerät;

import java.util.ArrayList;

/**
 * Created by jonas on 21.04.15.
 */
public class RoomLayout extends Page {

    public RoomLayout(String name, Gerät device) {

        super(name, device);
    }

    public RoomLayout(String name) {
        super(name);
    }

    public RoomLayout(String name, ArrayList<Gerät> devices) {
        super(name, devices);
    }

    @Override
    public boolean AddDevice(Gerät device) {
        return super.AddDevice(device);
    }
}
