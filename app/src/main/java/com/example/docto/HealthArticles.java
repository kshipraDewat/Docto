package com.example.docto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class HealthArticles extends AppCompatActivity {

    private String[][] healthArticles ={
            {"Walking Daily","","", "Click For More Details"},
            {"Stop Smoking","","", "Click For More Details"},
            {"Menstural Cramps","","", "Click For More Details"},
            {"Healthy Gut","","", "Click For More Details"},
            {"Health and Hygiene","","", "Click For More Details"},
            {"Mental Health","","", "Click For More Details"},
            {" All About Flouride","","", "Click For More Details"},
            {" ABC of Oral health","","", "Click For More Details"},
            {"Skin Care on older adults","","", "Click For More Details"},
            {"Urinary Tract Infection","","", "Click For More Details"},
            {"Oral health","","", "Click For More Details"},
            {"Steps of skin care","","", "Click For More Details"}



    };

    private  int[] images = {
            R.drawable.health1,
            R.drawable.health2,
            R.drawable.health3,
            R.drawable.health4,
            R.drawable.health6,
            R.drawable.health7,
            R.drawable.health8,
            R.drawable.health9,
            R.drawable.health10,
            R.drawable.health11,
            R.drawable.health12,
            R.drawable.health13


    };

    HashMap <String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnBack;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_health_articles);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lst=findViewById(R.id.HAlistView);
        btnBack= findViewById(R.id.HAback);

        list= new ArrayList();
        for(int i=0;i<healthArticles.length; i++){
            item =new HashMap<String, String>();
            item.put("line1", healthArticles[i][0]);
            item.put("line2", healthArticles[i][1]);
            item.put("line3", healthArticles[i][2]);
            item.put("line4", healthArticles[i][3]);
//            item.put("line5", healthArticles[i][4]);
            list.add(item);
        }
        sa = new SimpleAdapter(this, list, R.layout.multilines,
                new String[]{"line1","line2", "line3", "line4", "line5"},
                new int[]{R.id.lineA, R.id.lineB,R.id.lineC,R.id.lineD,R.id.lineE});

        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(HealthArticles.this, HealthArticleDetail.class);
                intent.putExtra("text1", healthArticles[i][0]);
                intent.putExtra("text2", images[i]);
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HealthArticles.this, Home.class));
            }
        });



    }
}