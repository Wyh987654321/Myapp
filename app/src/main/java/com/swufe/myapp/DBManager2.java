package com.swufe.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBManager2 {
    private DBHelper dbHelper;
    private String TBNAME;

    public DBManager2(Context context) {
        dbHelper = new DBHelper(context);
        TBNAME = DBHelper.TB_NAME2;
    }

    public void add(InfroItem item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("number", item.getNumber());
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

    public List<InfroItem> listAll(){
        List<InfroItem> list = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME, null, null, null, null, null, null);
        if(cursor!=null){
            list = new ArrayList<InfroItem>();
            while(cursor.moveToNext()){
                InfroItem item = new InfroItem();
                item.setNumber(cursor.getString(cursor.getColumnIndex("NUMBER")));
                item.setAttention(cursor.getString(cursor.getColumnIndex("ATTENTION")));
                item.setAvatar(cursor.getInt(cursor.getColumnIndex("AVATAR")));
                item.setFans(cursor.getString(cursor.getColumnIndex("FANS")));
                item.setGrade(cursor.getString(cursor.getColumnIndex("GRADE")));
                item.setRate(cursor.getString(cursor.getColumnIndex("RATE")));
                item.setName(cursor.getString(cursor.getColumnIndex("NAME")));
                item.setIntro(cursor.getString(cursor.getColumnIndex("INTRO")));
                item.setMoney(cursor.getInt(cursor.getColumnIndex("MONEY")));
                list.add(item);
            }
            cursor.close();
        }
        db.close();
        return list;
    }

    public InfroItem select(String number){
        InfroItem result = new InfroItem();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME, null, null, null, null, null, null);
        if(cursor!=null){
            while(cursor.moveToNext()){
                if(number.equals(cursor.getString(cursor.getColumnIndex("NUMBER")))){
                    result.setNumber(cursor.getString(cursor.getColumnIndex("NUMBER")));
                    result.setMoney(cursor.getInt(cursor.getColumnIndex("MONEY")));
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
