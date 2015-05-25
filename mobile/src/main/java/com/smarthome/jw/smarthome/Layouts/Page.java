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
public class Page extends ScrollView implements View.OnClickListener {

    public ArrayList<Gerät> Devices = new ArrayList<Gerät>();
    public Template Template;
    public Context Context;
    public String Name;
    public String ViewType;
    public GridLayout GridLayout;

    private boolean DrawPage;
    private boolean isTablet;

    public Page(Context context, String name, ArrayList<Gerät> devices,String viewType) {
        super(context);

        Name = name;
        Template = new Template(context,devices.size());
        Devices = devices;
        ViewType = viewType;
        Context = context;

        GridLayout = new GridLayout(context);

        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        //  params.setMargins(10, 10, 10, 10);


        for (int i = 0; i < Devices.size()-1; i++) {
            GridLayout.addView(devices.get(i));
        }
        /**
         *
         * Test Umgebung
         *
         *
         */


        addView(GridLayout);

        /**
         *
         * Test Umgebung
         *
         *




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

        addView(GridView); */

        //Licht  licht = new Licht(context,"Licht","WZ_Vitrine","Wohnzimmer", "Vitrine");
        //addView(licht);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateDevices();
            }
        };



        isTablet = getResources().getBoolean(R.bool.isTablet);
        DrawPage = true;
    }

    public void AddDevice(Gerät device) {

        Devices.add(device);
        Template.UpdateTemplate(Devices.size());

    }

    @Override
    public void onClick(View v) {


    }

    public void UpdateDevices() {

        for (int i = 0; i < Devices.size() ; i++) {
            Devices.get(i).Update();
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        if(DrawPage) {
            super.onDraw(canvas);

            View view = null;



        Rect aRect = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
        int X = aRect.centerX();
        int Y = aRect.centerY();

        int lgt = 100; // bei ScaleFaktor 1
            /**
        int xstart =Math.round(X-lgt*scaleFaktor);
        int ystart =Math.round(Y-lgt*scaleFaktor);
        int xende = Math.round(X + lgt*scaleFaktor);
        int yende = Math.round(Y+ lgt * scaleFaktor);*/

            for (int i = 0; i < getChildCount() ; i++) {
                view = getChildAt(i);

                if(view instanceof GridLayout) {
                    view.draw(canvas);
                    int k= 0;
                    for (int j = 0; j < ((GridLayout) view).getChildCount(); j++) {
                        View view2 = ((GridLayout) view).getChildAt(j);
                        Rect bRect = new Rect(0, 0+k*(150), 300, 0+k*(150)+150);
                        if(view2 instanceof Licht) {
                            k = k +1;
                            Licht licht = (Licht) view2;
                            licht.Draw(canvas,bRect);
                        }
                    }
                }
            }
/**
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





