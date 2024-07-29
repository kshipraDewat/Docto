package com.example.docto;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BuyMedicineDetails extends AppCompatActivity {

    TextView tvPackageName, tvTotalCost;
    EditText edDetails;
    Button btnBack, btnAddToCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buy_medicine_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvPackageName = findViewById(R.id.textViewBMPackageName);
        edDetails = findViewById(R.id.editTextBMTextMultiLine);
        edDetails.setKeyListener(null);
        tvTotalCost= findViewById(R.id.BMTotalCost);
        btnBack= findViewById(R.id.BMbuttonBack);

        btnAddToCart= findViewById(R.id.buttonBMAddToCart);

        Intent intent = getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText("Total Cost : "+ intent.getStringExtra("text3")+"-/");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineDetails.this, BuyMedicine.class));
            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedpreferences = getSharedPreferences ("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedpreferences.getString( "username",  "").toString();
                String product = tvPackageName.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());

                Database db = new Database (getApplicationContext(),  "healthcare",  null,  1);

                if(db.checkCart(username, product)==1){

                    Toast.makeText(getApplicationContext(),  "Product Already Added", Toast.LENGTH_SHORT).show();

                }else {

                    db.addCart(username, product, price,  "medicine");

                    Toast.makeText(getApplicationContext(), "Record Inserted to Cart", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent( BuyMedicineDetails.this, BuyMedicine.class));

                }
            }
        });
    }
}