package com.smarthome.jw.smarthome.Devices;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by jonas on 01.05.15.
 */
public class Kontakt extends Gerät {

    private String actState;

    public Kontakt(Context context,String type, String name, String roomAlias, String nameAlias) {
        super(context,type,name,roomAlias,nameAlias);

        actState = "";

    }



    @Override
    public boolean setState(String state) {
        if (state != null)  {

            actState = state;
            setUpdated(true);
            return true;
        }
        else {

            setUpdated(false);
            return false;
        }
    }

    @Override
    public void processFinish(String output) {

    }




    @Override
    public String getState() {
        return actState;
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
        canvas.drawText(getState(), wdt, hgt+50, paint);



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
