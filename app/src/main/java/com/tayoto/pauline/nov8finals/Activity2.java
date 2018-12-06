package com.tayoto.pauline.nov8finals;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;

public class Activity2 extends AppCompatActivity {

    TextView tMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        tMsg = findViewById(R.id.tvMsg);
    }

    public void previousActivity(View v) {
        Intent i = new Intent(this, Activity1.class);
        startActivity(i);
    }

    public void displayMsg(View v) {
        SharedPreferences sp = getSharedPreferences("data1", Context.MODE_PRIVATE);
        String name = sp.getString("name", null);
        String section = sp.getString("sec", null);
        String message = "Good afternoon " + name + "!\n\nYour section is " + section;
        //String message2 = "Your section is " + section;
        tMsg.setText(message);
        //tMsg.setText(message2);
    }

    public void displayInternal(View v) {
        try {
            FileInputStream fin = openFileInput("data2.txt" );
            int c;
            StringBuffer buffer = new StringBuffer();
            while ((c = fin.read())!= -1) {
                buffer.append((char) c);
            }
            String message = "Good afternoon " + buffer;
            tMsg.setText(message);
        } catch (Exception e) {
            Toast.makeText(this, "Error reading...", Toast.LENGTH_LONG).show();
        }
    }

    public void getExternalData (View v){
        File folder = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File file = new File (folder, "data3.txt");
        try {
            FileInputStream fin = openFileInput("data2.txt" );
            int c;
            StringBuffer buffer = new StringBuffer();
            while ((c = fin.read()) != -1) {
                buffer.append((char) c);
            }
            String message = "Good afternoon " + buffer;
            tMsg.setText(message);
        } catch (Exception e) {
            Toast.makeText(this, "Error reading...", Toast.LENGTH_LONG).show();
        }
    }
}
