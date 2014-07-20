package com.omaflak.viewpagerindicator;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.RelativeLayout;

public class ViewPagerIndicator extends RelativeLayout implements OnPageChangeListener{
	private List<CircleView> circles = new ArrayList<CircleView>();
	private CircleView circle_move;
	private ViewPager pager;
	private float radius;
	private int colorFix;
	private int colorMove;
	private int margin;
	private float oldP=0;
	private boolean avant = true;
	
	public ViewPagerIndicator(Context context) {
		super(context);
		init();
	}
	
    public ViewPagerIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void setViewPager(ViewPager pager){
    	this.pager = pager;
    	pager.setOnPageChangeListener(this);
    	for (int i=0 ; i<pager.getAdapter().getCount() ; i++){
    		CircleView circle = new CircleView(this.getContext());
        	circle.setRadius(radius);
        	circle.setColor(colorFix);
        	circle.setId(1000+i);
        	RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
    		if(i>0){
    			p.addRule(RelativeLayout.RIGHT_OF, circles.get(i-1).getId());
    			p.setMargins(margin, 0, 0, 0);
    		}
        	circle.setLayoutParams(p);
    		circles.add(circle);
    	}
    	
    	circle_move.setRadius(radius);
    	circle_move.setColor(colorMove);
    	drawCircles();
    }
    
    private void drawCircles(){
    	super.removeAllViews();
    	for (int i=0 ; i<circles.size() ; i++)
    		super.addView(circles.get(i), circles.get(i).getLayoutParams());
    	
    	super.addView(circle_move, circle_move.getLayoutParams());
    }

	@Override
	public void onPageScrollStateChanged(int state) {
	}

	@SuppressLint("NewApi") @Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
		if(positionOffset>0){	
			float p = positionOffset*(margin+2*radius);
			if(p-oldP>(margin+2*radius)/2){
				oldP=margin+2*radius;
				avant=false;
			}
			if(p-oldP<-(margin+2*radius)/2){
				oldP=0;
				avant=true;
			}
			
			float x = circle_move.getX()+p-oldP;
		    circle_move.setX(x);
		    drawCircles();
		    if(p<oldP)
		    	avant = false;
		    else
		    	avant = true;
		    oldP=p;
		}
		else{
			if(avant)
				oldP=0;
			else
				oldP=margin+2*radius;
		}
		
	}

	@Override
	public void onPageSelected(int arg0) {
	}
	
	public void init(){
		radius=20;
		margin=10;
		colorFix=Color.LTGRAY;
		colorMove=Color.BLACK;
		circle_move = new CircleView(this.getContext());
		circle_move.setRadius(radius);
		circle_move.setColor(colorMove);
    	circle_move.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
		super.setGravity(Gravity.CENTER_HORIZONTAL);
		super.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
	}
	
    public void setRadius(float radius){
    	this.radius = radius;
    }
    
	public void setColorFix(int colorFix) {
		this.colorFix = colorFix;
	}

	public void setColorMove(int colorMove) {
		this.colorMove = colorMove;
	}
	
	public void setMargin(int margin) {
		this.margin = margin;
	}
}
