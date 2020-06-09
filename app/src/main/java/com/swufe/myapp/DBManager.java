package com.swufe.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private DBHelper dbHelper;
    private String TBNAME;

    public DBManager(Context context) {
        dbHelper = new DBHelper(context);
        TBNAME = DBHelper.TB_NAME;
    }

    public void add(UserItem item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("number", item.getNumber());
        values.put("password", item.getPassword());

        db.insert(TBNAME, null, values);
        db.close();
    }

    public void addAll(List<UserItem> list){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        for (UserItem item : list) {
            ContentValues values = new ContentValues();
            values.put("number", item.getNumber());
            values.put("password", item.getPassword());
            db.insert(TBNAME, null, values);
        }
        db.close();
    }

    public void deleteAll(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME,null,null);
        db.close();
    }

    public void delete(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME, "ID=?", new String[]{String.valueOf(id)});
        db.close();
    }

    public void update(UserItem item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("number", item.getNumber());
        values.put("password", item.getPassword());
        db.update(TBNAME, values, "ID=?", new String[]{String.valueOf(item.getId())});
        db.close();
    }

    public List<UserItem> listAll(){
        List<UserItem> userlist = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME, null, null, null, null, null, null);
        if(cursor!=null){
            userlist = new ArrayList<UserItem>();
            while(cursor.moveToNext()){
                UserItem item = new UserItem();
                item.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                item.setNumber(cursor.getString(cursor.getColumnIndex("NUMBER")));
                item.setPassword(cursor.getString(cursor.getColumnIndex("PASSWORD")));
                userlist.add(item);
            }
            cursor.close();
        }
        db.close();
        return userlist;
    }

    public UserItem findById(int id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME, null, "ID=?", new String[]{String.valueOf(id)}, null, null, null);
        UserItem userItem = null;
        if(cursor!=null && cursor.moveToFirst()){
            userItem = new UserItem();
            userItem.setId(cursor.getInt(cursor.getColumnIndex("ID")));
            userItem.setNumber(cursor.getString(cursor.getColumnIndex("number")));
            userItem.setPassword(cursor.getString(cursor.getColumnIndex("password")));
            cursor.close();
        }
        db.close();
        return userItem;
    }
    public boolean isUser(String num,String pass){
        boolean result=false;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String []columns=new String[]{"number","password"};
        Cursor cursor = db.query(TBNAME, null, null, null, null, null, null);
        if(cursor!=null){
            while (cursor.moveToNext()){
                Log.i("MainActivity","number"+cursor.getString(cursor.getColumnIndex("NUMBER")));
                Log.i("MainActivity","number"+cursor.getString(cursor.getColumnIndex("PASSWORD")));
                if(num.equals(cursor.getString(cursor.getColumnIndex("NUMBER")))&&
                        pass.equals(cursor.getString(cursor.getColumnIndex("PASSWORD")))){
                    result=true;
                    break;
                }
            }
        }
        return result;
    }

}
