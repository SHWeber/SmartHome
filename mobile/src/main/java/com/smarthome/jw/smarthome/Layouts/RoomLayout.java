package com.smarthome.jw.smarthome.Layouts;

import com.smarthome.jw.smarthome.Controls.Device;
import com.smarthome.jw.smarthome.Controls.Page;

import java.util.ArrayList;

/**
 * Created by jonas on 21.04.15.
 */
public class RoomLayout extends Page {

    public RoomLayout(String name, Device device) {

        super(name, device);
    }

    public RoomLayout(String name) {
        super(name);
    }

    public RoomLayout(String name, ArrayList<Device> devices) {
        super(name, devices);
    }

    @Override
    public boolean AddDevice(Device device) {
        return super.AddDevice(device);
    }
}
