package com.smarthome.jw.smarthome.Devices;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import com.smarthome.jw.smarthome.InputOutput.HttpTask;
import com.smarthome.jw.smarthome.Interfaces.AsyncResponse;
import com.smarthome.jw.smarthome.R;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

/**
 * Created by jonas on 19.04.15.
 */
public class Licht extends Gerät implements View.OnClickListener {


    private String actState;


    public Licht(Context context,String type, String name, String roomAlias, String nameAlias) {
        super(context,type,name,roomAlias,nameAlias);

        actState = "No-act";

    }

    @Override
    public void onClick(View v) {
        Update();

    }

    @Override
    public boolean setState(String state) {
        if (state != null)  {
            if(state.equalsIgnoreCase("off")) {
                actState = "Aus";
            }
            else if (state.equalsIgnoreCase("on")) {
                actState = "An";
            } else {

                actState = "kein Status";
            }
            setUpdated(true);
            return true;
        }
        else {

            setUpdated(false);
            return false;
        }
    }



    @Override
    public String getState() {

        return actState;
    }

    @Override
    public boolean Draw(Canvas canvas, Rect rect) {
            int wdt = rect.width();
            int hgt = rect.height();
            Double textY = rect.top + rect.height() * 0.15;
            Double textX = rect.left + rect.width() * 0.2;
            Paint paint = new Paint();
            paint.setTextSize(50);
            paint.setColor(Color.DKGRAY);
            canvas.drawRect(rect, paint);
            paint.setColor(Color.WHITE);
            canvas.drawLine(rect.left, rect.top, rect.right, rect.top, paint);
            canvas.drawLine(rect.right,rect.top,rect.right,rect.bottom,paint);
            canvas.drawLine(rect.right, rect.bottom, rect.left, rect.bottom, paint);
            canvas.drawLine(rect.left, rect.bottom, rect.left, rect.top, paint);
            canvas.drawText(getNameAlias(), textX.intValue(), textY.intValue(), paint);
        if(actState != null) {
            canvas.drawText(getState(), textX.intValue(), 3*textY.intValue(), paint);
            if (actState == "An") {

                Resources res = getResources();
                Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.ic_action_name);
                canvas.drawBitmap(bitmap,textX.intValue(), textY.intValue() * 5, paint);

            }
        }
        return false;
    }


    @Override
    public void Update() {
        HttpTask httpTask = new HttpTask(new AsyncResponse() {
            @Override
            public void processFinish(String output) {
                setState(output);
            }
        });
        httpTask.execute(this);
    }

    @Override
    public void processFinish(String output) {
        setState(output);
    }

}
