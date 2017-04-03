package com.example.ahsan.b_tendance;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Select extends ListActivity{
    DataSource person;
    List<String> names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        person = new DataSource(this);
        person.open();
        names =person.getPersons();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        SharedPreferences name = getSharedPreferences("NAME", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = name.edit();
        String person = names.get(position);
        ed.putString("cname",person);
        ed.commit();
        Intent intent = new Intent("com.example.ahsan.b_tendance.SCREEN2");
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
