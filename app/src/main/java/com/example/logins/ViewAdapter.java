package com.example.logins;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewAdapter extends FragmentPagerAdapter {
    private Fragment[] activitys;
//    private String nama1 = "Home";
//    private String nama2 = "About";
    public ViewAdapter(FragmentManager fm) {
        super(fm);
        activitys = new Fragment[]{
                new Home(),
                new ListData(),
                new About()
        };
    }

    @Override
    public Fragment getItem(int position) {
        return activitys[position];
    }

    @Override
    public int getCount() {
        return activitys.length; //3 items
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = getItem(position).getClass().getName();
        return title.subSequence(title.lastIndexOf(".") + 1, title.length());
    }
}
