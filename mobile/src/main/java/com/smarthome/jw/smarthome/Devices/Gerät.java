package com.smarthome.jw.smarthome.Devices;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.view.View;

import com.smarthome.jw.smarthome.Interfaces.AsyncResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by jonas on 19.04.15.
 */
public abstract class Gerät extends View implements AsyncResponse,View.OnTouchListener {

    private String RoomAlias;
    private String Name;
    private String NameAlias;
    private String Type;
    private boolean isUpdated;
    private Double deltaTimeUp;

    private  Integer dx;
    private  Integer dy;



    public Gerät(Context context,String type, String name, String roomAlias, String nameAlias) {
        super(context);

        Name = name;
        Type = type;
        RoomAlias = roomAlias;
        NameAlias = nameAlias;
        isUpdated = false;
        deltaTimeUp = 60.0;
        dx = 300;
        dy = 300;
    }


    abstract public boolean Draw(Canvas canvas, Rect rect);
    abstract public boolean setState(String state);
    abstract public String getState();
    abstract public void UpdateAsync();
    abstract public void UpdateSync();


    public String getRequest() {

        return null;
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

    public Integer getDx() {
        return dx;
    }

    public void setDx(Integer dx) {
        this.dx = dx;
    }

    public Integer getDy() {
        return dy;
    }

    public void setDy(Integer dy) {
        this.dy = dy;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Compute the height required to render the view
        // Assume Width will always be MATCH_PARENT.
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = 3000 + 50; // Since 3000 is bottom of last Rect to be drawn added and 50 for padding.
        setMeasuredDimension(width, height);
    }
}
