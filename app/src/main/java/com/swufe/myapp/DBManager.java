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
        values.put("name", item.getName());
        values.put("grade", item.getGrade());
        values.put("rate",item.getRate());
        values.put("attention", item.getAttention());
        values.put("fans", item.getFans());
        values.put("money", item.getMoney());
        values.put("avatar", item.getAvatar());
        values.put("intro",item.getIntro());
        db.insert(TBNAME, null, values);
        db.close();
    }

    public void addAll(List<UserItem> list){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        for (UserItem item : list) {
            ContentValues values = new ContentValues();
            values.put("number", item.getNumber());
            values.put("password", item.getPassword());
            values.put("name", item.getName());
            values.put("grade", item.getGrade());
            values.put("rate",item.getRate());
            values.put("attention", item.getAttention());
            values.put("fans", item.getFans());
            values.put("money", item.getMoney());
            values.put("avatar", item.getAvatar());
            values.put("intro",item.getIntro());
            db.insert(TBNAME, null, values);
        }
        db.close();
    }

    public void deleteAll(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME,null,null);
        db.close();
    }

    public void delete(String number){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME, "NUMBER=?", new String[]{number});
        db.close();
    }

    public void update(UserItem item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("number", item.getNumber());
        values.put("password", item.getPassword());
        values.put("name", item.getName());
        values.put("grade", item.getGrade());
        values.put("rate",item.getRate());
        values.put("attention", item.getAttention());
        values.put("fans", item.getFans());
        values.put("money", item.getMoney());
        values.put("avatar", item.getAvatar());
        values.put("intro",item.getIntro());
        db.update(TBNAME, values, "NUMBER=?", new String[]{item.getNumber()});
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
                item.setMoney(cursor.getInt(cursor.getColumnIndex("MONEY")));
                item.setIntro(cursor.getString(cursor.getColumnIndex("INTRO")));
                item.setName(cursor.getString(cursor.getColumnIndex("NAME")));
                item.setRate(cursor.getString(cursor.getColumnIndex("RATE")));
                item.setGrade(cursor.getString(cursor.getColumnIndex("GRADE")));
                item.setFans(cursor.getString(cursor.getColumnIndex("FANS")));
                item.setAvatar(cursor.getInt(cursor.getColumnIndex("AVATAR")));
                item.setAttention(cursor.getString(cursor.getColumnIndex("ATTENTION")));
                item.setNumber(cursor.getString(cursor.getColumnIndex("NUMBER")));
                item.setPassword(cursor.getString(cursor.getColumnIndex("PASSWORD")));
                userlist.add(item);
            }
            cursor.close();
        }
        db.close();
        return userlist;
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

    public UserItem select(String number){
        UserItem result = new UserItem();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME, null, null, null, null, null, null);
        if(cursor!=null){
            while(cursor.moveToNext()){
                if(number.equals(cursor.getString(cursor.getColumnIndex("NUMBER")))){
                    result.setNumber(cursor.getString(cursor.getColumnIndex("NUMBER")));
                    result.setMoney(cursor.getInt(cursor.getColumnIndex("MONEY")));
                    result.setPassword(cursor.getString(cursor.getColumnIndex("PASSWORD")));
                    result.setIntro(cursor.getString(cursor.getColumnIndex("INTRO")));
                    result.setName(cursor.getString(cursor.getColumnIndex("NAME")));
                    result.setRate(cursor.getString(cursor.getColumnIndex("RATE")));
                    result.setGrade(cursor.getString(cursor.getColumnIndex("GRADE")));
                    result.setFans(cursor.getString(cursor.getColumnIndex("FANS")));
                    result.setAvatar(cursor.getInt(cursor.getColumnIndex("AVATAR")));
                    result.setAttention(cursor.getString(cursor.getColumnIndex("ATTENTION")));
                }
            }
        }
        return result;
    }
}
