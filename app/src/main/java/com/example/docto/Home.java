package com.example.docto;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        SharedPreferences sp = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sp.getString("uname", "").toString();
        Toast.makeText(getApplicationContext(), "Welcome" + username, Toast.LENGTH_SHORT).show();

        CardView logout = findViewById(R.id.cardlogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sp.edit();
                editor.clear();//cleared everything in the local memory/shared memory then jumped to login activity
                editor.apply();
                startActivity(new Intent(Home.this, Login.class));
                Toast.makeText(getApplicationContext(), "Logged Out Successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        CardView findDoctor = findViewById(R.id.cardfinddoctor);
        findDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, FindDoctor.class));

            }
        });

        CardView labtest = findViewById(R.id.cardlabtest);
        labtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, LabTest.class));

            }
        });

        CardView orderdetails = findViewById(R.id.cardorderdetail);
        orderdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, OrderDetails.class));

            }
        });

        CardView buymedicine = findViewById(R.id.cardbuymedicine);
        buymedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, BuyMedicine.class));

            }
        });

        CardView healtharticle = findViewById(R.id.cardhealtharticles);
        healtharticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, HealthArticles.class));

            }
        });

    }
}

