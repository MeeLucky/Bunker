package com.example.bunker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.Nullable;

public class SQLHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "contactDb";
    public static final String TABLE1_CONTACTS = "contacts";

    public static final String KEY1_ID = "id";
    public static final String KEY1_NAME = "name";
    public static final String KEY1_MAIL = "mail";

    public SQLHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table " + TABLE1_CONTACTS +
                "(" +
                    KEY1_ID
                    + " integer primary key," +
                    KEY1_NAME + " text," +
                    KEY1_MAIL + " text" +
                ")"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
