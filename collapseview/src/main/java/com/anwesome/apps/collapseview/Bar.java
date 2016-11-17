package com.anwesome.apps.collapseview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by anweshmishra on 17/11/16.
 */
public class Bar {
    private float x,y,w,h;
    private String colorString="#303F9F";
    public Bar(float x,float y,float w,float h,String colorString) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.colorString = colorString;
    }
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(Color.parseColor(colorString));
        canvas.drawRect(new RectF(x,y,x+w,y+h),paint);
    }
    public void setColorString(String colorString) {
        this.colorString = colorString;
    }
    public boolean containsTouch(float x,float y) {
        return x>=this.x && x<=this.x+this.w && y>=this.y && y<=this.y+this.h;
    }
    public int hashCode() {
        return (int)x+(int)y+(int)w+(int)h+colorString.hashCode();
    }

}
