package com.tayoto.pauline.nov8finals;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Activity1 extends AppCompatActivity {

    EditText eStudent, eSection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        eStudent = findViewById(R.id.etStudent);
        eSection = findViewById(R.id.etSection);
    }

    public void nextActivity(View v){
        Intent i = new Intent (this, Activity2.class);
        startActivity(i);
    }

    public void saveSP (View v){
        SharedPreferences sp = getSharedPreferences("data1", Context.MODE_PRIVATE);
        SharedPreferences.Editor writer = sp.edit();
        String name = eStudent.getText().toString();
        String section = eSection.getText().toString();
        writer.putString("name", name);
        writer.putString("sec", section);
        writer.commit();
        Toast.makeText(this, "Data Saved...", Toast.LENGTH_LONG).show();
    }

    public void saveInternal (View v){
        FileOutputStream fos = null;
        try {
            fos = openFileOutput("data2.txt", Context.MODE_PRIVATE);
            String name2 = eStudent.getText().toString();
            fos.write(name2.getBytes());
            Toast.makeText(this, "Data saved...", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error writing data...", Toast.LENGTH_LONG).show();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveExternal (View v){
        File folder = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File file = new File (folder, "data3.txt");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream (file);
            String name2 = eStudent.getText().toString();
            fos.write(name2.getBytes());
            Toast.makeText(this, "Data saved...", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error writing data...", Toast.LENGTH_LONG).show();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveIC (View v){
        File folder = getCacheDir();
        File file = new File (folder, "cache.txt");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream (file);
            String name2 = eStudent.getText().toString();
            fos.write(name2.getBytes());
            Toast.makeText(this, "Data saved...", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error writing data...", Toast.LENGTH_LONG).show();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
