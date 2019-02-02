package com.example.ayur;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Xiaomi extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiaomi);
        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        appBarLayout=(AppBarLayout) findViewById(R.id.appBar);
        viewpager=(ViewPager)findViewById(R.id.pager);
        ViewPagerAdapter viewadapter= new ViewPagerAdapter(getSupportFragmentManager());
        //adding fragments
        viewadapter.AddFragment(new Models(),"Models");
        viewadapter.AddFragment(new Available(),"Available");
        viewadapter.AddFragment(new About(),"About");
        //adding setup
        viewpager.setAdapter(viewadapter);
        viewpager.setOffscreenPageLimit(3);
        tabLayout.setupWithViewPager(viewpager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }


        });
    }
}
