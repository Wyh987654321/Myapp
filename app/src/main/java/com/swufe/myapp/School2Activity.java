package com.swufe.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class School2Activity extends AppCompatActivity {
    String TAG="School2Activity";
    String number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school2);
        Bundle bundle =this.getIntent().getExtras();
        number =bundle.getString("number","41811002");
//        Log.i(TAG,"");
        //传递用户ID给Fragment
        Fragment fragment = new FifthFragment();
        bundle.putString("number",number);
        fragment.setArguments(bundle);
        init();
    }
    public void init(){
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        TabLayout mytab = findViewById(R.id.mytab7);
        MyPageAdapter pageAdapter = new MyPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);
        mytab.setupWithViewPager(viewPager);
        int [] icons = new int[]{R.mipmap.school,R.mipmap.society,R.mipmap.add,R.mipmap.msg,R.mipmap.my};
        for(int i=0;i<5;i++){
            TabLayout.Tab tab =mytab.getTabAt(i);
            tab.setIcon(icons[i]);
        }
    }


}
