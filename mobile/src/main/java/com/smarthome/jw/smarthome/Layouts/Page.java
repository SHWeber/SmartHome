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
import android.widget.TextView;

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

    private boolean DrawPage;
    private boolean isTablet;

    public Page(Context context, String name, ArrayList<Gerät> devices,String viewType) {
        super(context);

        Name = name;
        Template = new Template(context);
        Devices = devices;
        ViewType = viewType;
        Context = context;
        isTablet = getResources().getBoolean(R.bool.isTablet);


        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        setBackgroundColor(getResources().getColor(android.R.color.transparent));
        setLayoutParams(params);


        for (int i = 0; i < Devices.size()-1; i++) {

            Template.AddRect(Devices.get(i).getDx(), Devices.get(i).getDy());
            Template.addView(Devices.get(i));
        }

        addView(Template);


        DrawPage = true;

    }

    public void AddDevice(Gerät device) {

        Devices.add(device);
        Template.AddRect(device.getDx(),device.getDy());
        Template.addView(device);

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

            for (int i = 0; i < getChildCount() ; i++) {
                View view = getChildAt(i);

                if(view instanceof Template) {
                    view.draw(canvas);

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



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = 3000 + 50;
        setMeasuredDimension(width, height);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        UpdateDevices();
        invalidate();
        return super.onTouchEvent(event);
    }
}





