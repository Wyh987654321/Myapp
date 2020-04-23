package com.swufe.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class SchoolActivity extends AppCompatActivity {
    TabLayout mytab;
    List<Fragment> mFragment;
    ViewPager myview;
    private List<Drawable> icons;
    private LayoutInflater mInflater;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private View view1, view2, view3, view4, view5;//页卡视图
    private List<View> mViewList = new ArrayList<>();//页卡视图集合
    private List<String> listTitles;
    private List<Fragment> fragments;
    private List<TextView> listTextViews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);
        mytab=findViewById(R.id.mytab);

        //init();

        mytab.addTab(mytab.newTab().setText("校内").setIcon(R.mipmap.school));
        mytab.addTab(mytab.newTab().setText("校外").setIcon(R.mipmap.society));
        mytab.addTab(mytab.newTab().setText("发布").setIcon(R.mipmap.add));
        mytab.addTab(mytab.newTab().setText("消息").setIcon(R.mipmap.msg));
        mytab.addTab(mytab.newTab().setText("我的").setIcon(R.mipmap.my));


    }
//    private void init(){
//        listTitles = new ArrayList<>();
//        fragments = new ArrayList<>();
//        listTextViews = new ArrayList<>();
//        icons=new ArrayList<>();
//
//        listTitles.add("校内");
//        listTitles.add("校外");
//        listTitles.add("");
//        listTitles.add("消息");
//        listTitles.add("我的");
//
//        icons.add(getResources().getDrawable(R.mipmap.school));
//        icons.add(getResources().getDrawable(R.mipmap.society));
//        icons.add(getResources().getDrawable(R.mipmap.add));
//        icons.add(getResources().getDrawable(R.mipmap.msg));
//        icons.add(getResources().getDrawable(R.mipmap.my));
//
//
//        for (int i = 0; i < listTitles.size(); i++) {
//            ContentFragment fragment = ContentFragment.newInstance(listTitles.get(i));
//            fragments.add(fragment);
//
//        }
//        //mTabLayout.setTabMode(TabLayout.SCROLL_AXIS_HORIZONTAL);//设置tab模式，当前为系统默认模式
//        for (int i=0;i<listTitles.size();i++){
//            mytab.addTab(mytab.newTab().setText(listTitles.get(i)).setIcon(R.mipmap.msg));//添加tab选项
//
//
//        }
//        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
//            @Override
//            public Fragment getItem(int position) {
//                return fragments.get(position);
//            }
//
//            @Override
//            public int getCount() {
//                return fragments.size();
//            }
//            //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
//            @Override
//            public CharSequence getPageTitle(int position) {
//                return listTitles.get(position);
//            }
//        };
//        myview.setAdapter(mAdapter);
//
//        mytab.setupWithViewPager(myview);//将TabLayout和ViewPager关联起来。
//        mytab.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器
//
//    }





}



