package com.nazycodes.schedo.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.nazycodes.schedo.fragments.ImportantFragment;
import com.nazycodes.schedo.fragments.MyDayFragment;
import com.nazycodes.schedo.fragments.PlannedFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new MyDayFragment();
        }
        else if (position == 1)
        {
            fragment = new ImportantFragment();
        }
        else if (position == 2)
        {
            fragment = new PlannedFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "My Day";
        }
        else if (position == 1)
        {
            title = "Important";
        }
        else if (position == 2)
        {
            title = "Planned";
        }
        return title;
    }
}

