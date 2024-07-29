package com.example.docto;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicine extends AppCompatActivity {

        private String[][] packages =
                {
                        {"Uprise-03 1000IU Capsule", "", "", "50"},
                        {"HealthVit Chromium Picolinate 200mcg Capsule", "", "", "305"},
                        {"Vitamin B Complex Capsules", "", " ", "448"},
                        {"Inlife Vitamin E Wheat Germ Oil Capsule", "", "", "539"},
                        {"Dolo 650 Tablet", "", "","30"},
                        {"Crocin 650 Advance Tablet", "", "", "50"},
                        {"Strepsils Medicated Lozenges for Sore Throat", "", "",  "40"},
                        {"Tata 1mg Calcium + Vitamin D3", "","","", "30"},
                        {"Feronia -XT Tablet", "","","", "130"},
                };
        private String[] package_details = {
                "Building and keeping the bones & teeth strong\n" +
                        "Reducing Fatigue/stress and muscular pains\n" +
                        "Boosting immunity and increasing resistance against infection",
                "Chromium is an essential trace mineral that plays an important role in helping insulin regular blood glucose.",
                "Provides relief from vitamin B deficiencies\n" +
                        "Helps in formation of red blood cells\n" +
                        "Maintains healthy nervous system",
                "It promotes health as well as skin benefit.\n" +
                        "It helps reduce skin blemish and pigmentation.\n" +
                        "It act as safeguard the skin from the harsh UVA and UVB sun rays.",
                "Dolo 650 Tablet helps relieve pain and fever by blocking the release of certain chemical messenger responsible for fever and pain.",
                "Helps relieve fever and bring down a high temperature\n" +
                        "Suitable for people with a heart condition or high blood pressure",
                "Relieves the symptoms of a bacterial throat infection and soothes the recovery process\n" +
                        "Provides a warm and comforting feeling during sore throat",
                "Reduces the risk of calcium deficiency, Rickets, and Osteoporosis\n" +
                        "Promotes mobility and flexibility of joints",
                "Helps to reduce the iron deficiency due to chronic blood loss or low intake of iron"
        };

        HashMap <String,String> item;
        ArrayList list;
        SimpleAdapter sa;
        ListView lst;
        Button buttonback, buttongotocart;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_buy_medicine);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
            lst= findViewById(R.id.BMListView);
            buttonback = findViewById(R.id.btnBMBack);
            buttongotocart = findViewById(R.id.BMbtngotocart);

            buttonback.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(BuyMedicine.this, Home.class));
                }
            });



//                    startActivity(new Intent(BuyMedicine.this, CartBuyMedicine.class));

            buttongotocart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(BuyMedicine.this, CartBuyMedicine.class));
                }
            });


          list = new ArrayList();
        for(int i=0;i<packages.length; i++){
            item =new HashMap<String, String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
//            item.put("line4","Total Cost"+packages[i][3]);
//            item.put("line5", packages[i][3]);
            item.put("line5","Total Cost: "+packages[i][3]+"/-");
            list.add(item);

        }
        sa = new SimpleAdapter(this, list, R.layout.multilines,
                new String[]{"line1","line2", "line3", "line4", "line5"},
                new int[]{R.id.lineA, R.id.lineB,R.id.lineC,R.id.lineD, R.id.lineE});
              lst.setAdapter(sa);


              lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                  @Override
                  public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                      Intent intent = new Intent(BuyMedicine.this, BuyMedicineDetails.class);
                      intent.putExtra("text1",packages[i][0]);
                      intent.putExtra("text2",package_details[i]);
                      intent.putExtra("text3",packages[i][3]);
                      startActivity(intent);
                  }
              });

        }
    }
