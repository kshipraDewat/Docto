package com.example.docto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FindDoctor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_find_doctor);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        CardView returnn = findViewById(R.id.backbtn);
        returnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindDoctor.this, Home.class));

            }
        });

        CardView physician = findViewById(R.id.cardPhysician);
        physician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctor.this, DoctorDetail.class);
                intent.putExtra("title","Physician");
                startActivity(intent);

            }
        });

        CardView dietcian = findViewById(R.id.cardDietcian);
        dietcian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctor.this, DoctorDetail.class);
                intent.putExtra("title","Dietician");
                startActivity(intent);
            }
        });

        CardView dentist = findViewById(R.id.cardDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctor.this, DoctorDetail.class);
                intent.putExtra("title","Dentist");
                startActivity(intent);

            }
        });

        CardView surgeon = findViewById(R.id.cardSurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctor.this, DoctorDetail.class);
                intent.putExtra("title","Surgeon");
                startActivity(intent);
            }
        });

        CardView cardiologist = findViewById(R.id.cardCardiologist);
        cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctor.this, DoctorDetail.class);
                intent.putExtra("title","Cardiologist");
                startActivity(intent);

            }
        });



    }
}