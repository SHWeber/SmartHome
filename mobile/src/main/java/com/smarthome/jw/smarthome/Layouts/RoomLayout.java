package com.smarthome.jw.smarthome.Layouts;

import android.content.Context;

import com.smarthome.jw.smarthome.Devices.Gerät;

import java.util.ArrayList;

/**
 * Created by jonas on 21.04.15.
 */
public class RoomLayout extends Page {

    public RoomLayout(Context context, String name) {
        super(context, name);
    }

    @Override
    public boolean AddDevice(Gerät device) {
        return super.AddDevice(device);
    }
}
