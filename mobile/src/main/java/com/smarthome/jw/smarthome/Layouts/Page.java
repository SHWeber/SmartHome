package com.smarthome.jw.smarthome.Layouts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.smarthome.jw.smarthome.Devices.Gerät;
import com.smarthome.jw.smarthome.Devices.Licht;
import com.smarthome.jw.smarthome.Devices.Steckdose;
import com.smarthome.jw.smarthome.R;
import com.smarthome.jw.smarthome.Template.RelativeRect;
import com.smarthome.jw.smarthome.Template.Template;

import java.util.ArrayList;

/**
 * Created by jonas on 19.04.15.
 */
public class Page extends ScrollView {

    public ArrayList<Gerät> Devices = new ArrayList<Gerät>();
    public Template Template;
    public Context Context;
    public String Name;
    public String ViewType;
    public GridView GridView;

    private boolean DrawPage;
    private boolean isTablet;

    public Page(Context context, String name, ArrayList<Gerät> devices,String viewType) {
        super(context);

        Name = name;
        Template = new Template(context,devices.size());
        Devices = devices;
        ViewType = viewType;
        Context = context;
        /**
         *
         * Test Umgebung
         *
         *
         */




        /**
         *
         * Test Umgebung
         *
         *
         */



        GridView = new GridView(context);
        GridView.setBackgroundColor(Color.BLUE);
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
      //  params.setMargins(10, 10, 10, 10);

        GridView.setLayoutParams(params);

        Licht licht;
        for (int i = 0; i < 1; i++) {
            licht = new Licht(context,"Licht","WZ_Vitrine","Wohnzimmer", "Vitrine");
            GridLayout.LayoutParams param =new GridLayout.LayoutParams();

            param.height = 400;
            param.width = 400;
            param.rightMargin = 10;
            param.leftMargin = 10;
            param.topMargin = 10;
            param.bottomMargin = 10;


            //licht.setLayoutParams(param);
          //  GridView.addView(licht);

          //  gridLayout.setColumnCount();

        }

        addView(GridView);


        isTablet = getResources().getBoolean(R.bool.isTablet);

        DrawPage = true;
    }

    public void AddDevice(Gerät device) {

        Devices.add(device);
        Template.UpdateTemplate(Devices.size());

    }



    public void UpdateDevices() {

        for (int i = 0; i < Devices.size() ; i++) {
            Devices.get(i).Update();
        }
    }

    public void Update() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(DrawPage) {
            super.onDraw(canvas);


        /**    Licht licht = new Licht(Context,"Licht","WZ_Vitrine","Wohnzimmer","Vitrine");
            Rect aRect = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
            licht.Draw(canvas,aRect);

    /**    Rect aRect = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
        int X = aRect.centerX();
        int Y = aRect.centerY();
        int lgt = 100; // bei ScaleFaktor 1
        int xstart =Math.round(X-lgt*scaleFaktor);
        int ystart =Math.round(Y-lgt*scaleFaktor);
        int xende = Math.round(X + lgt*scaleFaktor);
        int yende = Math.round(Y+ lgt * scaleFaktor);

        Rect bRect = new Rect(xstart,ystart,xende,yende);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawRect(bRect,paint);



        Template.setTemplate(Devices.size());
        UpdatePageState();



        for (int i = 0; i < Devices.size(); i++) {
            Rect aRect = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
            RelativeRect relativeRect = Template.RelRect.get(i);
            Rect bRect = relativeRect.CalcRect(aRect);

            Gerät gerät = Devices.get(i);
            scrollView.addView(Devices.get(i));
            scrollView.draw(canvas);
            if (gerät.getType().equals("Licht")) {
                Licht light = (Licht) gerät;
                light.Draw(canvas, bRect);
            } else if (gerät.getType().equals("Steckdose")) {
                Steckdose steckdose = (Steckdose) gerät;
                steckdose.Draw(canvas,bRect);

            }*/

        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = 3000 + 50;
        setMeasuredDimension(width, height);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}





