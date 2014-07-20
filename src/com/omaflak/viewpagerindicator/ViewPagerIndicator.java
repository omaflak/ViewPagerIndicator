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
import android.widget.LinearLayout;

public class ViewPagerIndicator extends LinearLayout implements OnPageChangeListener{
	private List<CircleView> circles = new ArrayList<CircleView>();
	private float radius;
	private ViewPager pager;
	private int colorFix;
	private int colorMove;
	
	public ViewPagerIndicator(Context context) {
		super(context);
		init();
	}
	
    public ViewPagerIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    
    public void setRadius(float radius){
    	this.radius = radius;
    }

    public void setViewPager(ViewPager pager){
    	this.pager = pager;
    	pager.setOnPageChangeListener(this);
    	for (int i=0 ; i<pager.getAdapter().getCount() ; i++){
    		CircleView circle = new CircleView(this.getContext());
        	circle.setRadius(radius);
        	circle.setColor(colorFix);
    		LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0.005f);
    		circle.setLayoutParams(p);
    		circles.add(circle);
    	}
    	
    	circles.get(pager.getCurrentItem()).setColor(colorMove);
    	drawCircles();
    }
    
    private void drawCircles(){
    	super.removeAllViews();
    	for (int i=0 ; i<circles.size() ; i++)
    		super.addView(circles.get(i));    	
    }

	@Override
	public void onPageScrollStateChanged(int state) {
		if(state==ViewPager.SCROLL_STATE_IDLE){
			int pos = pager.getCurrentItem();
			for (int i=0 ; i<circles.size() ; i++){
				if(i==pos)
					circles.get(i).setColor(colorMove);
				else
					circles.get(i).setColor(colorFix);
			}
			drawCircles();
		}
	}

	@SuppressLint("NewApi") @Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
	}

	@Override
	public void onPageSelected(int arg0) {
	}
	
	public void init(){
		radius=20;
		colorFix=Color.LTGRAY;
		colorMove=Color.BLACK;
		super.setOrientation(LinearLayout.HORIZONTAL);
		super.setGravity(Gravity.CENTER_HORIZONTAL);
	}
	
	public void setColorFix(int colorFix) {
		this.colorFix = colorFix;
	}

	public void setColorMove(int colorMove) {
		this.colorMove = colorMove;
	}
}
