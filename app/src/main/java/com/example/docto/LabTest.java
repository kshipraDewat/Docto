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

public class LabTest extends AppCompatActivity {

    private  String[][] packages= {
            {"Package 1 : Full Body Checkup", "" , "" , "" ,"999 "},
            {"Package 2 : Blood Glucose Fasting", "" , "","" ,"499 "},
            {"Package 3 : COVID-19 Antibody - IgG", "" , "" , "" ,"750 "},
            {"Package 4 : Thyroid Checkup", "" , "" , "" ,"800 "},
            {"Package 5 : Immunity Checkup", "" , "" , "" ,"599 "}
    };

    private String[] package_details ={
      "Blood Glucose Fasting\n"   +
      "complete Hemogram\n" +
      "HbA1c\n" +
      "Iron Studies\n" +
      "Kidney Function Test\n" +
      "LDH Lactate Dehydrogenase, Serum\n" +
      "Lipid Profile \n" +
      "Liver Function Test",
      "Blood Glucose Fasting",
      "COVID-19 Antibody -IgG",
      "Thyorid Profile - Total (T3,T4 & THS Ultra-Sensitive)",
      "Complete Hemogram\n"+
              "complete Hemogram\n" +
              "CRP (C Reactive Protine) Quantative, Serum\n" +
              "Iron Studies\n" +
              "Kidney Function Test\n" +
              "Vitamin D Total -25 Hydroxy\n" +
              "Liver Function Test\n"+
              "Lipid Profile"
    };

    HashMap <String,String> item ;
    ArrayList list;
    SimpleAdapter adapter;
    Button btngotocart, btnback;
    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab_test);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btngotocart = findViewById(R.id.gotocart);
        btnback = findViewById(R.id.bacttomain);
        listView = findViewById(R.id.listLT);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTest.this, Home.class));
            }
        });

        list =new ArrayList();
        for (int i=0; i<packages.length;i++){
            item =new HashMap<String,String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost: "+packages[i][4]+"/-");
            list.add(item);
        }

        adapter=new SimpleAdapter(this, list, R.layout.multilines, new String[]{"line1","line2","line3", "line4","line5"},
                new int[]{R.id.lineA , R.id.lineB, R.id.lineC, R.id.lineD, R.id.lineE});
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =new Intent(LabTest.this, LabTestDetail.class);
                intent.putExtra("text1", packages[i][0]);
                intent.putExtra("text2", package_details[i]);
                intent.putExtra("text3", packages[i][4]);
                startActivity(intent);


            }
        });
        btngotocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTest.this, CartLab.class));
            }
        });




    }
}