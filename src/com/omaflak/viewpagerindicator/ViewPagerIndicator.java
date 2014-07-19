package com.omaflak.viewpagerindicator;

import java.util.ArrayList;
import java.util.List;

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
	
	public ViewPagerIndicator(Context context) {
		super(context);
	}
	
    public ViewPagerIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    public void setRadius(float radius){
    	this.radius = radius;
    }

    public void setViewPager(ViewPager pager){
    	this.pager = pager;
    	pager.setOnPageChangeListener(this);
    	super.setOrientation(LinearLayout.HORIZONTAL);
    	super.setGravity(Gravity.CENTER);
    	
    	for (int i=0 ; i<pager.getAdapter().getCount() ; i++){
    		CircleView circle = new CircleView(this.getContext());
    		circle.setRadius(radius);
    		circle.setColor(Color.LTGRAY);
    		circles.add(circle);
    	}
    	
    	circles.get(pager.getCurrentItem()).setColor(Color.BLACK);
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
					circles.get(i).setColor(Color.BLACK);
				else
					circles.get(i).setColor(Color.LTGRAY);
			}
			drawCircles();
		}
	}

	@Override
	public void onPageScrolled(int pos, float arg1, int arg2) {
	}

	@Override
	public void onPageSelected(int arg0) {
	}
}
