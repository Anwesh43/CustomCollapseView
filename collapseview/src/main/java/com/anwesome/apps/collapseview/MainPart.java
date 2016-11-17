package com.anwesome.apps.collapseview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by anweshmishra on 17/11/16.
 */
public class MainPart {
    private float x,y,w,h=0,origH;
    private int dir = 0;
    private String colorString;
    public MainPart(float x,float y,float w,float h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.origH = h;
    }
    public void setColorString(String colorString) {
        this.colorString = colorString;
    }
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(Color.parseColor(colorString));
        canvas.drawRect(new RectF(x,y,x+w,y+h),paint);
    }
    public void move() {
        h+=dir*20;
        if(h>=origH) {
            h = origH;
            dir = 0;
        }
        else if(h<=0){
            h = 0;
            dir = 0;
        }
    }
    public void setMovement() {
        if(h == 0) {
            dir = 1;
        }
        else if(h == origH) {
            dir = -1;
        }
    }
    public boolean isStop() {
        return dir == 0;
    }
    public float getYBottom() {
        return y+h;
    }
}
