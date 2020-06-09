package com.swufe.myapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.swufe.myapp.FifthFragment;
import com.swufe.myapp.FirstFragment;
import com.swufe.myapp.FourthFragment;
import com.swufe.myapp.SecondFragment;
import com.swufe.myapp.ThirdFragment;

public class MyPageAdapter extends FragmentPagerAdapter {
    public MyPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new FirstFragment();
        } else if (position == 1) {
            return new SecondFragment();
        } else if(position==2){
            return new ThirdFragment();
        }
        else if(position==3){
            return new FourthFragment();
        }
        else {
            return new FifthFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
    public CharSequence getPageTitle(int position) {
        String [] name =new String []{"校内","校外","发布","消息","我的"};
        return name[position];
    }
}