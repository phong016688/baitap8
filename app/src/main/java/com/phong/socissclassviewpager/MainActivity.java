package com.phong.socissclassviewpager;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    FragmentPagerAdapter fragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);

        setSupportActionBar(toolbar);

        tabLayout.setupWithViewPager(viewPager);

        List<Fragment> list = Arrays.asList(new Fragment1(), new Fragment2(), new Fragment3());

        fragmentPagerAdapter = new FragmentAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(fragmentPagerAdapter);

    }
}

class FragmentAdapter extends FragmentPagerAdapter {
    List<Fragment> mList;


    public FragmentAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.mList = list;
    }

    @Override
    public Fragment getItem(int i) {
        return mList.get(i);
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int i) {
        List<String> listchar = Arrays.asList("Tab 1", "Tab 2", "Tab 3");
        return listchar.get(i);
    }
}
