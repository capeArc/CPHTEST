package com.example.administrator.cph_test;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.administrator.cph_test.R;


/**
 * Created by Administrator on 21-09-2016.
 */
public class Collection extends ActionBarActivity{

    private Toolbar toolbar;
    private TabLayout tablayout;
    ViewPager viewpager;

    MainActivity mainActivity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collection);

        mainActivity = new MainActivity();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewpager = (ViewPager) findViewById(R.id.view_pager);
        viewpager.setAdapter(new CustomAdapter(getSupportFragmentManager(),getApplicationContext()));

        tablayout = (TabLayout) findViewById(R.id.tab_layout);
        tablayout.setupWithViewPager(viewpager);

        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.logout){

        }
        if(id==R.id.about){

        }
        if (id==R.id.exit){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class CustomAdapter extends FragmentPagerAdapter{
        private String fragment[]={"History","Payment"};
        public CustomAdapter(FragmentManager supportFragmentManager, Context applicationContext) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                   return new History();
                case 1:
                    return new Payment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return fragment.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragment[position];
        }
    }
}
