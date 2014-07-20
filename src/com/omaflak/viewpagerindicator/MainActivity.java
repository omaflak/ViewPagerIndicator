package com.omaflak.viewpagerindicator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {
	private ViewPager viewPager;
	private PagerAdapter adapter;
	private ViewPagerIndicator vpi;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
		viewPager = (ViewPager)findViewById(R.id.pager);
		adapter = new PagerAdapter(getSupportFragmentManager());
		vpi = (ViewPagerIndicator)findViewById(R.id.vpi);
		
		viewPager.setAdapter(adapter);
		vpi.setRadius(15);
		vpi.setColorFix(Color.LTGRAY);
		vpi.setColorMove(Color.BLACK);
		vpi.setViewPager(viewPager);
    }
}
