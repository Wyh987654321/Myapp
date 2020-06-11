package com.swufe.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    String TAG ="MainActivity";
    Button btn;
    EditText number;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn =findViewById(R.id.login);
        number=findViewById(R.id.number);
        password =findViewById(R.id.PAWd);
        UserItem test = new UserItem("41811002","1","一位扬州姑娘","袅娜少女羞，岁月无忧愁",
                "Lv10","66","80%","108",6,R.mipmap.head);
        UserItem test2 = new UserItem("41811003","2","YKing","我是要成为YKing的男人",
                "Lv1","10","60%","6",0,R.mipmap.head2);

        DBManager manager = new DBManager(this);
        //DBManager2 manager2 = new DBManager2(this);
        //manager2.add(test2);
        manager.add(test);
        manager.add(test2);
    }

    public void login(View btn){
        String n =number.getText().toString();
        String p =password.getText().toString();
        DBManager manager = new DBManager(MainActivity.this);
        if(manager.isUser(n,p)){
            Intent school = new Intent(this, School2Activity.class);
            Bundle bundle = new Bundle();
            bundle.putString("number",n);
            school.putExtras(bundle);
            startActivity(school);
        }
        else{
            Toast.makeText(this,"账号或密码不正确",Toast.LENGTH_SHORT).show();
        }
    }
}
