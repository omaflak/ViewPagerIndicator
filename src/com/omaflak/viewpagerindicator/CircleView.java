package com.omaflak.viewpagerindicator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CircleView extends ImageView{
	private Paint paint;
	private float radius=50;
	private int color=Color.BLACK;
	
	public CircleView(Context context) {
		super(context);
	}
	
	public CircleView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
    public void setRadius(float radius){
    	this.radius = radius;
    	init();
    }
    
    public void setColor(int color){
    	this.color = color;
    	init();
    }
    
    public void init(){
    	Bitmap pallet = Bitmap.createBitmap((int)radius*2, (int)radius*2, Bitmap.Config.ARGB_8888);
    	Canvas canvas = new Canvas(pallet);
    	paint = new Paint();
	    paint.setColor(color);
	    paint.setStyle(Paint.Style.FILL);
	    canvas.drawCircle(radius, radius, radius, paint);
	    super.setImageBitmap(pallet);
    }
}