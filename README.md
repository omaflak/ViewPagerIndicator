ViewPagerIndicator
==================

1) Include the widget in your view

    <com.omaflak.viewpagerindicator.ViewPagerIndicator
        android:id="@+id/vpi"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"/>
        

2) In your activity or fragment or whatever, link the ViewPagerIndicator with your ViewPager

    // initialise variable and set adapter
    viewPager = (ViewPager)findViewById(R.id.pager);
    YourPagerAdapter adapter = new YourPagerAdapter(getSupportFragmentManager());
    viewPager.setAdapter(adapter);

    // make the link
    ViewPagerIndicator vpi = (ViewPagerIndicator)findViewById(R.id.vpi);
    vpi.setViewPager(viewPager);
		
3) (Optional) You can set some preferences like : 

    vpi.setRadius(15); /!\ To do before setting the ViewPager /!\
    vpi.setMargin(15); /!\ To do before setting the ViewPager /!\
    vpi.setColorFix(Color.RED); /!\ To do before setting the ViewPager /!\
    vpi.setColorMove(Color.BLACK); /!\ To do before setting the ViewPager /!\
