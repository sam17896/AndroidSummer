package com.example.ahsan.b_tendance;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewManager;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Screen1 extends Activity {
    Button mButton;
    ImageButton mButton2;
    private static int RESULT_LOAD_IMG = 1;
    String imgDecodableString = null;
    EditText mEdit1,mEdit2,mEdit3,mEdit4,mEdit5,mEdit6,mEdit7;
    String Name, Rollnumber,FatherName,UniversityName,DegreeProgram,EmailID,PhoneNumber;
    Data person;
    DataSource data;
    boolean i = false;
    List<String> person_names = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = prefs.edit();
        SharedPreferences detail = getSharedPreferences("MyDetails", Context.MODE_PRIVATE);
        SharedPreferences cname = getSharedPreferences("NAME", Context.MODE_PRIVATE);
        final SharedPreferences.Editor ed2  = cname.edit();
        final SharedPreferences.Editor ed1 = detail.edit();
        ed.putBoolean("HaveShownPrefs", true);
        ed.commit();
        mEdit1 = (EditText) findViewById(R.id.edittext);
        mEdit2 = (EditText) findViewById(R.id.edittext2);
        mEdit3 = (EditText) findViewById(R.id.edittext3);
        mEdit4 = (EditText) findViewById(R.id.edittext4);
        mEdit5 = (EditText) findViewById(R.id.edittext5);
        mEdit6 = (EditText) findViewById(R.id.edittext6);
        mEdit7 = (EditText) findViewById(R.id.edittext7);
        mEdit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mEdit1.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mEdit2.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit3.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit4.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit5.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit6.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit7.getWindowToken(), 0);
                imm.showSoftInput(mEdit1, InputMethodManager.SHOW_IMPLICIT);
                mEdit1.setCursorVisible(true);
                mEdit2.setCursorVisible(false);
                mEdit3.setCursorVisible(false);
                mEdit4.setCursorVisible(false);
                mEdit5.setCursorVisible(false);
                mEdit6.setCursorVisible(false);
                mEdit7.setCursorVisible(false);

            }
        });
        mEdit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mEdit1.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit3.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit4.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit5.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit6.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit7.getWindowToken(), 0);
                mEdit2.requestFocus();
                imm.showSoftInput(mEdit2, InputMethodManager.SHOW_IMPLICIT);
                mEdit1.setCursorVisible(false);
                mEdit2.setCursorVisible(true);
                mEdit3.setCursorVisible(false);
                mEdit4.setCursorVisible(false);
                mEdit5.setCursorVisible(false);
                mEdit6.setCursorVisible(false);
                mEdit7.setCursorVisible(false);

            }
        });
        mEdit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mEdit3.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mEdit2.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit1.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit4.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit5.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit6.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit7.getWindowToken(), 0);
                imm.showSoftInput(mEdit3, InputMethodManager.SHOW_IMPLICIT);
                mEdit1.setCursorVisible(false);
                mEdit2.setCursorVisible(false);
                mEdit3.setCursorVisible(true);
                mEdit4.setCursorVisible(false);
                mEdit5.setCursorVisible(false);
                mEdit6.setCursorVisible(false);
                mEdit7.setCursorVisible(false);
            }
        });
        mEdit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEdit4.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mEdit2.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit3.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit1.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit5.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit6.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit7.getWindowToken(), 0);
                imm.showSoftInput(mEdit4, InputMethodManager.SHOW_IMPLICIT);

                mEdit1.setCursorVisible(false);
                mEdit2.setCursorVisible(false);
                mEdit3.setCursorVisible(false);
                mEdit4.setCursorVisible(true);
                mEdit5.setCursorVisible(false);
                mEdit6.setCursorVisible(false);
                mEdit7.setCursorVisible(false);

            }
        });
        mEdit5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mEdit5.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mEdit2.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit3.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit4.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit1.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit6.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit7.getWindowToken(), 0);
                imm.showSoftInput(mEdit5, InputMethodManager.SHOW_IMPLICIT);
                mEdit1.setCursorVisible(false);
                mEdit2.setCursorVisible(false);
                mEdit3.setCursorVisible(false);
                mEdit4.setCursorVisible(false);
                mEdit5.setCursorVisible(true);
                mEdit6.setCursorVisible(false);
                mEdit7.setCursorVisible(false);

            }
        });
        mEdit6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEdit6.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mEdit2.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit3.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit4.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit5.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit1.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit7.getWindowToken(), 0);
                imm.showSoftInput(mEdit6, InputMethodManager.SHOW_IMPLICIT);
                mEdit1.setCursorVisible(false);
                mEdit2.setCursorVisible(false);
                mEdit3.setCursorVisible(false);
                mEdit4.setCursorVisible(false);
                mEdit5.setCursorVisible(false);
                mEdit6.setCursorVisible(true);
                mEdit7.setCursorVisible(false);

            }
        });
        mEdit7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEdit7.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mEdit2.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit3.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit4.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit5.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit6.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit1.getWindowToken(), 0);
                imm.showSoftInput(mEdit7, InputMethodManager.SHOW_IMPLICIT);
                mEdit1.setCursorVisible(false);
                mEdit2.setCursorVisible(false);
                mEdit3.setCursorVisible(false);
                mEdit4.setCursorVisible(false);
                mEdit5.setCursorVisible(false);
                mEdit6.setCursorVisible(false);
                mEdit7.setCursorVisible(true);

            }
        });
        mButton = (Button) findViewById(R.id.button);
        data = new DataSource(this);
        mButton2 = (ImageButton) findViewById(R.id.imageButton);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadImagefromGallery(v);
            }
        });
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                person = new Data();
                Name = mEdit1.getText().toString();
                Rollnumber = mEdit2.getText().toString();
                FatherName = mEdit3.getText().toString();
                UniversityName = mEdit4.getText().toString();
                DegreeProgram = mEdit5.getText().toString();
                EmailID = mEdit6.getText().toString();
                PhoneNumber = mEdit7.getText().toString();
                person.setName(Name);
                person.setFather_name(FatherName);
                person.setUniversity_name(UniversityName);
                person.setRoll_number(Rollnumber);
                person.setPhone_number(PhoneNumber);
                person.setDegree_program(DegreeProgram);
                person.setEmail_id(EmailID);
                person.setImage(imgDecodableString);
                data.open();
                data.persons.add(person);
                data.createTable();
                ed2.putString("cname", Name);
                ed2.commit();
                Intent intent = new Intent("com.example.ahsan.b_tendance.SCREEN2");
                startActivity(intent);
            }
        });
    }
        public void loadImagefromGallery(View view) {
            Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            i=true;
            startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            try {
                // When an Image is picked
                if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK && null != data) {
                    // Get the Image from data

                    Uri selectedImage = data.getData();
                    String[] filePathColumn = { MediaStore.Images.Media.DATA };

                    // Get the cursor
                    Cursor cursor = getContentResolver().query(selectedImage,
                            filePathColumn, null, null, null);
                    // Move to first row
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    imgDecodableString = cursor.getString(columnIndex);
                    cursor.close();
                    ImageView imgView = (ImageView) findViewById(R.id.imageView2);
                    imgView.setImageBitmap(BitmapFactory.decodeFile(imgDecodableString));
                    File f = new File(imgDecodableString);
                    String name = f.getName();
                    File root = new File(Environment.getExternalStorageDirectory(),"File");
                    if (!root.exists()) {
                        root.mkdirs();
                    }
                    DataSource data1 = new DataSource(this);
                    data1.open();
                    int i = data1.getCount();
                    File newFile = new File(root,"newBitmap.png"+i);
                    File temp = f;
                    temp.renameTo(newFile);
                    imgDecodableString = newFile.toString();

                } else {
                    Toast.makeText(this, "You haven't picked Image",
                            Toast.LENGTH_LONG).show();
                }
            } catch (Exception e) {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                        .show();
            }

        }

    @Override
    protected void onPause() {
        super.onPause();
        if(!i) {
            finish();
        }
        i=false;
    }
}
