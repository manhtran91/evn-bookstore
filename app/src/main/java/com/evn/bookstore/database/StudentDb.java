package com.evn.bookstore.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class StudentDb extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "evn.db";
    public static final int DATABASE_VERSION = 2;

    public static final String TABLE_USER = "users";
    public static final String FIELD_USER_ID = "user_id";
    public static final String FIELD_USER_NAME = "user_name";

    public static final String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + FIELD_USER_ID + " INTEGER PRIMARY KEY,"
            + FIELD_USER_NAME + " TEXT)";

    public static final String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    static List<String> initScript = new ArrayList<>();
    static List<String> upgradeScript = new ArrayList<>();

    static {
        initScript.add(CREATE_USER_TABLE);
        upgradeScript.add(DROP_USER_TABLE);
    }

    public StudentDb(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        initDb(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        upgrade(db);
        initDb(db);
    }

    void initDb(SQLiteDatabase db) {
        for (String script : initScript) {
            db.execSQL(script);
        }
    }

    void upgrade(SQLiteDatabase db) {
        for (String script : upgradeScript) {
            db.execSQL(script);
        }
    }
}
