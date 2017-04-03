package com.example.ahsan.b_tendance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.ParcelUuid;
import android.util.Log;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataSource {
    SQLiteOpenHelper details;
    SQLiteDatabase db;
    int user=0;
    List<Data> persons = new ArrayList<Data>();
    private static final String[] allColumns={
            Details.NAME,
            Details.FATHER_NAME,
            Details.UNIVERSITY_NAME,
            Details.RM,
            Details.DEGREE_PROGRAM,
            Details.EMAIL_ID,
            Details.PHONE_NUMBER,
            Details.IMAGE
    };
    public DataSource(Context context)
    {
        details = new Details(context);
    }
    public void open()
    {
        db = details.getWritableDatabase();
        Log.i("ahsan", "db opened");
    }
    public void close()
    {
        details.close();
        Log.i("ahsan", "db closed");
    }
    public void createTable(){

        for (Data person:persons) {
            ContentValues values = new ContentValues();
            values.put("name", person.getName());
            values.put("father",person.getFather_name());
            values.put("university",person.getUniversity_name());
            values.put("phone",person.getPhone_number());
            values.put("degree",person.getDegree_program());
            values.put("email",person.getEmail_id());
            values.put("rm",person.getRoll_number());
            values.put("img", person.getImage());
            db.insert("details", null, values);
            Log.i("ahsan", "Data is inserted");

        }
    }
    public Data findAll(String name)
    {
        Data data = new Data();
        Cursor cursor = db.query(Details.ID,allColumns,null,null,null,null,null);
        if(cursor.getCount()>0)
        {
            while (cursor.moveToNext()) {
                if (name.equals(cursor.getString(cursor.getColumnIndex(Details.NAME))))
                {
                    data.setName(cursor.getString(cursor.getColumnIndex(Details.NAME)));
                    data.setFather_name(cursor.getString(cursor.getColumnIndex(Details.FATHER_NAME)));
                    data.setUniversity_name(cursor.getString(cursor.getColumnIndex(Details.UNIVERSITY_NAME)));
                    data.setRoll_number(cursor.getString(cursor.getColumnIndex(Details.RM)));
                    data.setPhone_number(cursor.getString(cursor.getColumnIndex(Details.PHONE_NUMBER)));
                    data.setDegree_program(cursor.getString(cursor.getColumnIndex(Details.DEGREE_PROGRAM)));
                    data.setImage(cursor.getString(cursor.getColumnIndex(Details.IMAGE)));
                    data.setEmail_id(cursor.getString(cursor.getColumnIndex(Details.EMAIL_ID)));
                }
            }
        }
        return data;
    }
    public void delete(String name)
    {
        String where = Details.NAME+"='"+name+"'";
        db.delete(Details.ID,where,null);
    }
    public List<String> getPersons()
    {
        List<String> names = new ArrayList<String>();
        Cursor cursor = db.query(Details.ID,allColumns,null,null,null,null,null);
        if(cursor.getCount()>0)
        {
            while (cursor.moveToNext()) {
                names.add(cursor.getString(cursor.getColumnIndex(Details.NAME)));
            }
        }
    return names;
    }
    public int getCount()
    {
        int i=0;
        Cursor cursor = db.query(Details.ID,allColumns,null,null,null,null,null);
        if(cursor.getCount()>0)
        {
            while (cursor.moveToNext()) {
                i++;
            }
        }
        return i;
    }
}
