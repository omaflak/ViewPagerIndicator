package com.omaflak.viewpagerindicator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

@SuppressLint("NewApi") 
public class CircleView extends View {
    private Paint paint;
    private float radius;
    private int color = Color.LTGRAY;
     
    public CircleView(Context context) {
        super(context);
        init();
    }
     
    public CircleView(Context context, AttributeSet attrs) {
	    super(context, attrs);
	    init();
    }
     
    public CircleView(Context context, AttributeSet attrs, int defStyle) {
	    super(context, attrs, defStyle);
	    init();
    }
     
    private void init(){
    	LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 
    			LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);
    	super.setLayoutParams(p);
	    paint = new Paint();
    }
     
    @Override
    protected void onDraw(Canvas canvas) {
	    super.onDraw(canvas);
	    paint.setColor(color);
	    paint.setStyle(Paint.Style.FILL);
	    canvas.drawCircle(this.getWidth()/2, this.getHeight()/2, this.radius, paint);	     
    }
    
    public void setRadius(float radius){
    	this.radius = radius;
    }
    
    public void setColor(int color){
    	this.color = color;
    }
}