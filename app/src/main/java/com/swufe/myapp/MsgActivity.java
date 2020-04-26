package com.swufe.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MsgActivity extends AppCompatActivity {
    TabLayout mytab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);
        mytab =findViewById(R.id.mytab5);
        mytab.addTab(mytab.newTab().setText("校内").setIcon(R.mipmap.school));
        mytab.addTab(mytab.newTab().setText("校外").setIcon(R.mipmap.society));
        mytab.addTab(mytab.newTab().setText("发布").setIcon(R.mipmap.add));
        mytab.addTab(mytab.newTab().setText("消息").setIcon(R.mipmap.msg));
        mytab.addTab(mytab.newTab().setText("我的").setIcon(R.mipmap.my));

    }
}
