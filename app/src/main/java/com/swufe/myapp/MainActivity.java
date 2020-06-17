package com.swufe.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String TAG ="run1";
    Button btn,btn2;
    EditText number;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn =findViewById(R.id.login);
        btn2=findViewById(R.id.regester);

        number=findViewById(R.id.number);
        password =findViewById(R.id.PAWd);
        UserItem test = new UserItem("41811002","1","一位扬州姑娘","袅娜少女羞，岁月无忧愁",
                "Lv10","66","80%","108",6,R.mipmap.head,"西南财经大学");
        UserItem test2 = new UserItem("41811003","2","YKing","我是要成为YKing的男人",
                "Lv1","10","60%","6",0,R.mipmap.head2,"西南财经大学");
        DBManager manager = new DBManager(this);
        manager.add(test);
        manager.add(test2);
    }

    public void onClick(View btn){
        if(btn.getId()==R.id.login){
            String n =number.getText().toString();
            String p =password.getText().toString();
//        n="41811002";
//        p="1";
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
        else if(btn.getId()==R.id.regester){
           Intent resgister = new Intent(this,RegisterActivity.class);
           startActivity(resgister);
        }
        }

}
