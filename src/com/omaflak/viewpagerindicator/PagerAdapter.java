package com.omaflak.viewpagerindicator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PagerAdapter extends FragmentPagerAdapter{

	public PagerAdapter(FragmentManager fm) {
		super(fm);
	}

	public Fragment getItem(int i) {
		if(i==0){
			return new MonFragment();
		}
		else
			return new MonFragment();
	}

	public int getCount() {
		return 3;
	}

	public String getTitre(int i){
		return "Page "+String.valueOf(i+1);
	}
	
	public static class MonFragment extends Fragment {
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.page, container, false);
            TextView texte = (TextView)rootView.findViewById(android.R.id.text1);
            texte.setText("Ceci est un fragment!");
            return rootView;
        }
    }
}
