package com.example.android.myuni;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static Button bTimeTable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("ASB", "MainAktivity on Create called");
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        addListenerTobTimeTable();
        Log.d("ASB", "MainAktivity on Create after");

    }


    public void addListenerTobTimeTable() {
        bTimeTable = (Button) findViewById(R.id.bTimeTable);
        bTimeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.android.myuni.TimeTable");
                startActivity(intent);

            }
        });

        Log.d("ASB", "TimeTabkeActivity called");
    }


}
