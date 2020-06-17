package com.example.bunker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "bunkerDB";
    public static final String TABLE_PROFESSION = "profession";
    public static final String TABLE_PHOBIA = "phobia";
    public static final String TABLE_CHARACTER = "character";
    public static final String TABLE_HEALTH = "health";
    public static final String TABLE_BAGGAGE = "baggage";
    public static final String TABLE_HOBBY = "hobby";
    public static final String TABLE_INFO = "info";
    public static final String TABLE_SKILL = "skill";

    public static final String KEY_ID = "id";
    public static final String KEY_TITLE = "title";
    public static final String KEY_DESCRIPTION = "description";

    public SQLHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_PROFESSION + "(" + KEY_ID + " integer primary key," + KEY_TITLE + " text," + KEY_DESCRIPTION + " text" + ")");
        db.execSQL("create table " + TABLE_PHOBIA + "(" + KEY_ID + " integer primary key," + KEY_TITLE + " text," + KEY_DESCRIPTION + " text" + ")");
        db.execSQL("create table " + TABLE_CHARACTER + "(" + KEY_ID + " integer primary key," + KEY_TITLE + " text," + KEY_DESCRIPTION + " text" + ")");
        db.execSQL("create table " + TABLE_INFO + "(" + KEY_ID + " integer primary key," + KEY_TITLE + " text," + KEY_DESCRIPTION + " text" + ")");
        db.execSQL("create table " + TABLE_HEALTH + "(" + KEY_ID + " integer primary key," + KEY_TITLE + " text," + KEY_DESCRIPTION + " text" + ")");
        db.execSQL("create table " + TABLE_BAGGAGE + "(" + KEY_ID + " integer primary key," + KEY_TITLE + " text," + KEY_DESCRIPTION + " text" + ")");
        db.execSQL("create table " + TABLE_HOBBY + "(" + KEY_ID + " integer primary key," + KEY_TITLE + " text," + KEY_DESCRIPTION + " text" + ")");
        db.execSQL("create table " + TABLE_SKILL + "(" + KEY_ID + " integer primary key," + KEY_TITLE + " text," + KEY_DESCRIPTION + " text" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
