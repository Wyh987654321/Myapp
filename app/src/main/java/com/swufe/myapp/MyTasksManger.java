package com.swufe.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyTasksManger {
    private DBHelper dbHelper;
    private String TBNAME;
    String TAG="run1";
    public MyTasksManger(Context context) {
        dbHelper = new DBHelper(context);
        TBNAME = DBHelper.TB_NAME3;
    }

    public void add(MyTasks item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("employer_id", item.getEmployer_id());
        values.put("employer_name", item.getEmployer_name());
        values.put("avatar", item.getAvatar());
        values.put("university", item.getUniversity());
        values.put("status",item.getStatus());
        Log.i(TAG, "add: 我的status是"+item.getStatus());
        values.put("mynumber", item.getMynumber());
        values.put("details", item.getDetails());
        values.put("id", item.getId());
        values.put("money",item.getMoney());
        db.insert(TBNAME, null, values);
        db.close();
    }

    public void delete(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME, "ID=?", new String[]{String.valueOf(id)});
        db.close();
    }

    public List<MyTasks> listAll(String number){
        Log.i(TAG, "listAll: 我的number是"+number);
        List<MyTasks> acceptTaskItems = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME,null,null,null,null,null,null);
        if(cursor!=null&&cursor.getCount()>0){
            acceptTaskItems = new ArrayList<MyTasks>();
            while(cursor.moveToNext()){
                if(cursor.getString(cursor.getColumnIndex("MYNUMBER")).equals(number)&&
                        cursor.getString(cursor.getColumnIndex("STATUS")).equals("1")){
                    MyTasks item = new MyTasks();
                    item.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                    item.setMynumber(cursor.getString(cursor.getColumnIndex("MYNUMBER")));
                    item.setDetails(cursor.getString(cursor.getColumnIndex("DETAILS")));
                    item.setMoney(cursor.getInt(cursor.getColumnIndex("MONEY")));
                    item.setEmployer_id(cursor.getString(cursor.getColumnIndex("EMPLOYER_ID")));
                    item.setEmployer_name(cursor.getString(cursor.getColumnIndex("EMPLOYER_NAME")));
                    item.setUniversity(cursor.getString(cursor.getColumnIndex("UNIVERSITY")));
                    item.setStatus(cursor.getString(cursor.getColumnIndex("STATUS")));
                    item.setAvatar(cursor.getInt(cursor.getColumnIndex("AVATAR")));
                    acceptTaskItems.add(item);
                }
            }
            cursor.close();
        }
        db.close();
        return acceptTaskItems;
    }


    public List<MyTasks> listAll2(String number){
        Log.i(TAG, "listAll: 我的number是"+number);
        List<MyTasks> acceptTaskItems = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME,null,null,null,null,null,null);
        if(cursor!=null&&cursor.getCount()>0){
            acceptTaskItems = new ArrayList<MyTasks>();
            while(cursor.moveToNext()){
                if(cursor.getString(cursor.getColumnIndex("MYNUMBER")).equals(number)&&
                        cursor.getString(cursor.getColumnIndex("STATUS")).equals("0")){
                    MyTasks item = new MyTasks();
                    item.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                    item.setMynumber(cursor.getString(cursor.getColumnIndex("MYNUMBER")));
                    item.setDetails(cursor.getString(cursor.getColumnIndex("DETAILS")));
                    item.setMoney(cursor.getInt(cursor.getColumnIndex("MONEY")));
                    item.setEmployer_id(cursor.getString(cursor.getColumnIndex("EMPLOYER_ID")));
                    item.setEmployer_name(cursor.getString(cursor.getColumnIndex("EMPLOYER_NAME")));
                    item.setUniversity(cursor.getString(cursor.getColumnIndex("UNIVERSITY")));
                    item.setStatus(cursor.getString(cursor.getColumnIndex("STATUS")));
                    item.setAvatar(cursor.getInt(cursor.getColumnIndex("AVATAR")));
                    acceptTaskItems.add(item);
                }
            }
            cursor.close();
        }
        db.close();
        return acceptTaskItems;
    }

    public void update(int id ,String status){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("status",status);
        db.update(TBNAME, values, "id=?", new String[]{String.valueOf(id)});
        db.close();
    }
}
