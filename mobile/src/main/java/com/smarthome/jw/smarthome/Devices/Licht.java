package com.smarthome.jw.smarthome.Devices;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Network;
import android.os.AsyncTask;

import com.smarthome.jw.smarthome.InputOutput.HTTP;
import com.smarthome.jw.smarthome.InputOutput.HttpIO;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by jonas on 19.04.15.
 */
public class Licht extends Gerät {


    private boolean actState;

    public Licht(Context context,String type, String name, String roomAlias, String nameAlias) {
        super(context,type,name,roomAlias,nameAlias);

        actState = false;

    }



    @Override
    public boolean setState(String state) {
        if (state != null)  {

            actState = false;
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
        if (actState) {
            return "An";
        } else if (!actState) {
            return "Aus";
        }

        return "";
    }

    @Override
    public boolean Draw(Canvas canvas, Rect rect) {

            Update();
            int wdt = rect.centerX();
            int hgt = rect.centerY();
            Paint paint = new Paint();
            paint.setColor(Color.WHITE);
            paint.setTextSize(50);

            canvas.drawLine(rect.left,rect.top,rect.right,rect.top,paint);
            canvas.drawLine(rect.right,rect.top,rect.right,rect.bottom,paint);
            canvas.drawLine(rect.right,rect.bottom,rect.left,rect.bottom,paint);
            canvas.drawLine(rect.left,rect.bottom,rect.left,rect.top,paint);
            canvas.drawText(getNameAlias(),wdt,hgt,paint);
          //  canvas.drawText(getState(), wdt, hgt+50, paint);



        return false;
    }

    @Override
    public void Update() {

/**
        String response = "";
        String Network = "http://server:8083/fhem&cmd=%7BValue%28%22";
        String getState = "%22%29%7D&XHR=1";

        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(Network +getName()+getState);
        try {
            HttpResponse execute = client.execute(httpGet);
            InputStream content = execute.getEntity().getContent();

            BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
            String s = "";
            while ((s = buffer.readLine()) != null) {
                response += s;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        setState(response);*/



    }




}
