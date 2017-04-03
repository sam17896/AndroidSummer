package com.example.ahsan.b_tendance;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class Details extends SQLiteOpenHelper {
    private final static int DATABASE_VERSION = 2;
    public final static String DATABASE_NAME="detail.db";
    public final static String ID="details";
    public final static String NAME = "name";
    public final static String FATHER_NAME ="father";
    public final static String UNIVERSITY_NAME= "university";
    public final static String DEGREE_PROGRAM = "degree";
    public final static String EMAIL_ID="email";
    public final static String PHONE_NUMBER="phone";
    public final static String IMAGE="img";
    public final static String RM="rm";
    private final static String TABLE_CREATE="CREATE TABLE details(" +
            "name TEXT, " +
            "father TEXT, " +
            "university TEXT, " +
            "degree TEXT, " +
            "email TEXT, " +
            "phone TEXT, "+
            "img TEXT, " +
            "rm TEXT)";
    public Details(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
   db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+ ID);
        Log.i("onupgrade","I am in on upgrade") ;
        onCreate(db);
    }
}
