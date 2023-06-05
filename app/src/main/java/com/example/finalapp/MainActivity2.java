package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_2);

        Button b1 = null;

        Intent intent = getIntent();

        String passedArg = intent.getStringExtra("firstIndex");
        String passedLastArg = intent.getStringExtra("lastIndex");

        int surahNo = Integer.parseInt(passedArg);

        int lastAyatNo = Integer.parseInt(passedLastArg);

        QuranArabicText wt = new QuranArabicText();

        ArrayList<String> arrayList = new ArrayList<String>();

        ListView listView;

        for (int i=surahNo ; i<=lastAyatNo ; i++){
            arrayList.add(wt.QuranArabictext[i]);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);

        listView = findViewById(R.id.lstview2);
        listView.setAdapter(arrayAdapter);

        b1.findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}