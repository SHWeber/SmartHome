package com.smarthome.jw.smarthome.Controls;

import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by jonas on 19.04.15.
 */
public abstract class Device  {

    private String Room;
    private String RoomAlias;
    private String Name;
    private String NameAlias;
    private String Type;
    private boolean isUpdated;



    public Device(String room, String name, String type, String roomAlias, String nameAlias) {

        Room = room;
        Name = name;
        Type = type;
        RoomAlias = roomAlias;
        NameAlias = nameAlias;

    }


    abstract public boolean Draw(Canvas canvas, Rect rect);
    abstract public boolean setState(String state);
    abstract public String getState();

    public String getRequest() {

        return null;
    }

    public String getRoom() {
        return Room;
    }

    public void setRoom(String room) {
        Room = room;
    }

    public String getRoomAlias() {
        return RoomAlias;
    }

    public void setRoomAlias(String roomAlias) {
        RoomAlias = roomAlias;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNameAlias() {
        return NameAlias;
    }

    public void setNameAlias(String nameAlias) {
        NameAlias = nameAlias;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public boolean isUpdated() {
        return isUpdated;
    }

    public void setUpdated(boolean isUpdated) {
        this.isUpdated = isUpdated;
    }
}
