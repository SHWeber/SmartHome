package com.smarthome.jw.smarthome;import android.graphics.Bitmap;
import android.graphics.ImageFormat;

import com.smarthome.jw.smarthome.Interfaces.ImageInterface;

/**
 * Created by jonas on 22.04.15.
 */
public class Image implements ImageInterface {

    Bitmap bitmap;
    ImageFormat format;

    public Image(Bitmap bitmap, ImageFormat format) {
        this.bitmap = bitmap;
        this.format = format;
    }

    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

    @Override
    public ImageFormat getFormat() {
        return format;
    }

    @Override
    public void dispose() {
        bitmap.recycle();
    }
}
