package com.swufe.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TaskManger {
    private DBHelper dbHelper;
    private String TBNAME;
    String TAG="run1";
    public TaskManger(Context context) {
        dbHelper = new DBHelper(context);
        TBNAME = DBHelper.TB_NAME2;
    }

    public void add(TaskItem item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("number", item.getNumber());
        values.put("details", item.getDetails());
        values.put("people", item.getPeople());
        values.put("reward",item.getReward());
        values.put("status",item.getStatus());
        db.insert(TBNAME, null, values);
        db.close();

    }

    public List<TaskItem> listAll(){
        List<TaskItem> taskItems = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME, null, null, null, null, null, null);
        if(cursor!=null&& cursor.getCount() > 0){
            taskItems = new ArrayList<TaskItem>();
            while(cursor.moveToNext()){
                if(cursor.getString(cursor.getColumnIndex("STATUS")).equals("1")){
                    TaskItem item = new TaskItem();
                    item.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                    item.setNumber(cursor.getString(cursor.getColumnIndex("NUMBER")));
                    item.setDetails(cursor.getString(cursor.getColumnIndex("DETAILS")));
                    item.setReward(cursor.getInt(cursor.getColumnIndex("REWARD")));
                    item.setPeople(cursor.getInt(cursor.getColumnIndex("PEOPLE")));
                    item.setStatus(cursor.getString(cursor.getColumnIndex("STATUS")));
                    taskItems.add(item);
                }
            }
            cursor.close();

        }
        db.close();

        return taskItems;
    }

    public List<TaskItem> listAll2(String number){
        List<TaskItem> taskItems = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME, null, null, null, null, null, null);
        if(cursor!=null&& cursor.getCount() > 0){
            taskItems = new ArrayList<TaskItem>();
            while(cursor.moveToNext()){
                Log.i(TAG, "listAll2: 要查询的number="+number);
                if(cursor.getString(cursor.getColumnIndex("NUMBER")).equals(number)){
                    TaskItem item = new TaskItem();
                    item.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                    item.setNumber(cursor.getString(cursor.getColumnIndex("NUMBER")));
                    item.setDetails(cursor.getString(cursor.getColumnIndex("DETAILS")));
                    item.setReward(cursor.getInt(cursor.getColumnIndex("REWARD")));
                    item.setPeople(cursor.getInt(cursor.getColumnIndex("PEOPLE")));
                    item.setStatus(cursor.getString(cursor.getColumnIndex("STATUS")));
                    taskItems.add(item);
                }
            }
            cursor.close();

        }
        db.close();

        return taskItems;
    }


    public void update(int id, int people,String status){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("status",status);
        values.put("people",people);
        db.update(TBNAME, values, "id=?", new String[]{String.valueOf(id)});
        db.close();
    }
}
