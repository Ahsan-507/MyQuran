package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.view.View;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        ArrayList<String> arrayList = new ArrayList<String>();

        ListView listView;

        EditText et;



        QDH qd = new QDH();

        for (int i = 0; i < 114; i++){
            arrayList.add("Surah:" + (i + 1) + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + qd.urduSurahNames[i]);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);

        listView = findViewById(R.id.listItm);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String f = arrayList.get(position);
                int stInd;
                stInd = (qd.SSP[position])-1;
                String no = Integer.toString(stInd);

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                intent.putExtra("txt",no);
                int lastAyatCount;
                if(position == 0){
                    lastAyatCount = (stInd+(qd.surahAyatCount[position])-1);
                }
                else {
                    lastAyatCount = ((stInd + (qd.surahAyatCount[position]) - 1) + 1);
                }
                String lastno = Integer.toString(lastAyatCount);
                intent.putExtra("lxt",lastno);
                startActivity(intent);
            }
        });
    }
}

