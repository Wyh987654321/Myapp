package com.swufe.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.widget.EditText;

import com.google.android.material.tabs.TabLayout;

public class IssueActivity extends AppCompatActivity {
    TabLayout mytab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue);
        mytab =findViewById(R.id.mytab2);
        mytab.addTab(mytab.newTab().setIcon(R.mipmap.photo));
        mytab.addTab(mytab.newTab().setIcon(R.mipmap.video));
        mytab.addTab(mytab.newTab().setIcon(R.mipmap.microphone));
        mytab.addTab(mytab.newTab().setIcon(R.mipmap.link));
        mytab.addTab(mytab.newTab().setIcon(R.mipmap.vote));


    }
}
