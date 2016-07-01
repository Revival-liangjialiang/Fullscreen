package com.example.k.viewpagerfullscreendemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
        ViewPager viewPager;
    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    private String[] mTitles = {"首页", "消息", "联系人", "更多"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        for (String title : mTitles) {
            fragmentArrayList.add(SimpleCardFragment.getInstance("Switch ViewPager " + title));
        }
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }
    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return fragmentArrayList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentArrayList.get(position);
        }
    }
}
