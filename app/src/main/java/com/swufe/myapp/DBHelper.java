package com.swufe.myapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DB_NAME = "myapp.db";
    public static final String TB_NAME = "tb_users";
    public static final String TB_NAME2 = "tb_information";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                    int version) {
        super(context, name, factory, version);
    }
    public DBHelper(Context context) {
        super(context,DB_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TB_NAME+"(NUMBER TEXT PRIMARY KEY,PASSWORD TEXT,NAME TEXT,INTRO TEXT," +
                "GRADE TEXT,ATTENTION TEXT,FANS TEXT,RATE TEXT,MONEY INTEGER,AVATAR,INT)");
        //db.execSQL("CREATE TABLE "+TB_NAME2+"(NUMBER INTEGER PRIMARY KEY ,NAME TEXT,INTRO TEXT," +
                //"GRADE TEXT,ATTENTION TEXT,FANS,TEXT,RATE TEXT,MONEY INTEGER,AVATAR,INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
    }
}
