package com.anwesome.apps.collapseview;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.*;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 17/11/16.
 */
public class CollapseView extends View{
    private Bar bar;
    private MainPart mainPart;
    private String barColor = "#303F9F";
    private String mainPartColor="#00BCD4";
    private int time = 0;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private boolean shouldUpdate = false;
    private int w,h;
    public CollapseView(Context context) {
        super(context);
    }
    public void onLayout(boolean changed,int a,int b,int w,int h) {
        this.w = w;
        this.h = h;
    }
    public CollapseView(Context context, AttributeSet attrs) {
        super(context,attrs);
    }
    private void init(int w,int h) {
        this.w = w;
        this.h = h;
        bar = new Bar(0,0,w,h/10,barColor);
        mainPart = new MainPart(0,h/10,w,9*h/10);
        mainPart.setColorString(mainPartColor);
    }
    public void setBarColor(String barColor) {
        this.barColor = barColor;
        if(bar!=null) {
            bar.setColorString(barColor);
        }
    }
    public void setMainPartColor(String mainPartColor) {
        this.mainPartColor = mainPartColor;
        if(mainPart!=null) {
            mainPart.setColorString(mainPartColor);
        }
    }
    public void onDraw(Canvas canvas) {
        if(time == 0) {
            init(canvas.getWidth(),canvas.getHeight());
        }
        bar.draw(canvas,paint);
        mainPart.draw(canvas,paint);
        mainPart.move();
        time++;
        if(shouldUpdate) {
            if(mainPart.isStop()) {
                shouldUpdate = false;
            }
            try {
                Thread.sleep(10);
                invalidate();
            } catch (Exception ex)  {

            }
        }
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN && bar.containsTouch(event.getX(),event.getY()) && !shouldUpdate) {
            shouldUpdate = true;
            mainPart.setMovement();
            postInvalidate();
        }
        return true;
    }

}
