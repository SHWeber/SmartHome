package com.smarthome.jw.smarthome.Interfaces;

import android.graphics.ImageFormat;

/**
 * Created by jonas on 21.04.15.
 */
public interface ImageInterface {

    public int getWidth();
    public int getHeight();
    public ImageFormat getFormat();
    public void dispose();
}
