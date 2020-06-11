package com.swufe.myapp.msg;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MsgPageAdapter extends FragmentPagerAdapter {
    public MsgPageAdapter(FragmentManager fm) {
        super(fm);
    }

    public Fragment getItem(int position) {
        if (position == 0) {
            return new MsgFragment1();
        } else if (position == 1) {
            return new MsgFragment2();
        }
        else {
            return new MsgFragment3();
        }
    }
    public int getCount() {
        return 3;
    }
    public CharSequence getPageTitle(int position) {
        String [] name =new String []{"我的消息","工作邀约","系统消息"};
        return name[position];
    }
}
