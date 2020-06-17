package com.swufe.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

    }
    public void onClick(View v){
        DBManager manager = new DBManager(this);
        EditText number =findViewById(R.id.regester_number);
        String numberStr =number.getText().toString();
        if(!manager.isLegal(numberStr)){
            EditText password =findViewById(R.id.regester_password1);
            String passwordStr = password.getText().toString();
            UserItem user = new UserItem(numberStr,passwordStr);
            manager.add(user);
            Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"注册失败，账号已存在或不为8位",Toast.LENGTH_SHORT).show();
        }
    }
}
