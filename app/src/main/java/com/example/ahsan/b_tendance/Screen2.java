package com.example.ahsan.b_tendance;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Screen2 extends Activity  implements View.OnClickListener{
    Button m1Button,m2Button,m3Button,m4Button;
    TextView Name, Rollnumber,FatherName,UniversityName,DegreeProgram,EmailID,PhoneNumber;
    DataSource data;
    ImageView imgView;
    Data person;
    String name;
    boolean delete = false;
    boolean vr = false;
    SharedPreferences details;
    SharedPreferences.Editor d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen);
        configure();
        data.open();
        person = data.findAll(name);
        clearDisplay();
        refreshDisplay(person);
    }
    @Override
    protected void onResume() {
        super.onResume();
        data.open();
    }

    @Override
    protected void onPause() {
        super.onPause();
        data.close();
        if(!vr) {
            finish();
        }
        vr=false;
    }
    void refreshDisplay(Data per) {
        Name.setText(per.getName());
        FatherName.setText(per.getFather_name());
        UniversityName.setText(per.getUniversity_name());
        Rollnumber.setText(per.getRoll_number());
        EmailID.setText(per.getEmail_id());
        PhoneNumber.setText(per.getPhone_number());
        DegreeProgram.setText(per.getDegree_program());
        imgView.setImageBitmap(BitmapFactory.decodeFile(per.getImage()));
    }
    void clearDisplay() {
        Name.setText("");
        FatherName.setText("");
        UniversityName.setText("");
        Rollnumber.setText("");
        EmailID.setText("");
        PhoneNumber.setText("");
        DegreeProgram.setText("");
        imgView.setImageBitmap(BitmapFactory.decodeFile(""));
    }
    public void configure()
    {
        data = new DataSource(this);
        imgView = (ImageView) findViewById(R.id.imageView2);
        Name = (TextView) findViewById(R.id.textView15);
        Rollnumber =(TextView) findViewById(R.id.textView21);
        FatherName =(TextView) findViewById(R.id.textView20);
        UniversityName =(TextView) findViewById(R.id.textView19);
        DegreeProgram=(TextView) findViewById(R.id.textView18);
        EmailID=(TextView) findViewById(R.id.textView17);
        PhoneNumber=(TextView) findViewById(R.id.textView16);
        m1Button = (Button) findViewById(R.id.button2);
        m2Button = (Button) findViewById(R.id.button3);
        m3Button = (Button) findViewById(R.id.button4);
        m4Button = (Button) findViewById(R.id.vr);
        m1Button.setOnClickListener(this);
        m2Button.setOnClickListener(this);
        m3Button.setOnClickListener(this);
        m4Button.setOnClickListener(this);
        details = getSharedPreferences("NAME", Context.MODE_PRIVATE);
        person = new Data();
        name = details.getString("cname","N/A");
        d = details.edit();
    }
    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.button:

                break;
            case R.id.button2:
                Intent intent = new Intent("com.example.ahsan.b_tendance.SCREEN1");
                startActivity(intent);
                break;
            case R.id.button3:
                data.delete(name);
                delete = true;
                List<String> names1 = data.getPersons();
                if (names1.size() > 0) {
                    Intent intent1 = new Intent(getApplicationContext(), Select.class);
                    startActivity(intent1);
                } else {
                    Intent intent1 = new Intent("com.example.ahsan.b_tendance.SCREEN1");
                    startActivity(intent1);
                }
                break;
            case R.id.button4:
                List<String> names2 = data.getPersons();
                if (names2.size() > 0) {
                    Intent intent2 = new Intent(getApplicationContext(), Select.class);
                    startActivity(intent2);
                } else {
                    Intent intent2 = new Intent("com.example.ahsan.b_tendance.SCREEN1");
                    startActivity(intent2);
                }
                break;
            case R.id.vr:
                Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak name to display data");
                vr=true;
                startActivityForResult(i, 5);
                Toast.makeText(this,"on click ",Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data1) {
        super.onActivityResult(requestCode, resultCode, data1);
        boolean success = false;
        data.open();
        List<String> names = data.getPersons();
        String p = "person";
        ArrayList<String> speak = data1.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
        if(requestCode==5&&resultCode == RESULT_OK&&speak!=null)
        {
            for (String n:names) {
                if(speak.contains(n))
                {
                    name=n;
                    person = data.findAll(name);
                    clearDisplay();
                    refreshDisplay(person);
                    success=true;
                    d.putString("cname", name);
                    break;
                }
            }
            d.commit();
        }
        if(!success)
        {
            p = speak.get(0);
            Toast.makeText(this,p + " Not Found",Toast.LENGTH_LONG).show();
        }
        }
    }
