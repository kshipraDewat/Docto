package com.example.docto;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BuyMedicineBook extends AppCompatActivity {

    EditText edname, edaddress, edcontact, edpincode;
    Button btnBooking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buy_medicine_book);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edname= findViewById(R.id.BMFullName);
        edaddress= findViewById(R.id.BMAddress);
        edcontact = findViewById(R.id.BMContact);
        edpincode = findViewById(R.id.BMPincode);
        btnBooking= findViewById(R.id.BMBookbtn);

        Intent intent = getIntent();
        String[] price = intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date = intent.getStringExtra("date");

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();
                Database db = new Database(getApplicationContext(),"healthcare", null,1);
                db.addOrder(username, edname.getText().toString(), edaddress.getText().toString(),edcontact.getText().toString(), Integer.parseInt(edpincode.getText().toString()), date.toString(),"",Float.parseFloat(price[1].toString()),"medicine");
                db.removecart(username,"medicine");

                Toast.makeText(getApplicationContext(), "Your booking is done sucessfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BuyMedicineBook.this, Home.class));

            }
        });
    }
}