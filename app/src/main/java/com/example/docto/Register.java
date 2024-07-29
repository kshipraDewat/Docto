package com.example.docto;

import android.app.ProgressDialog;
import android.content.Intent;
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

public class Register extends AppCompatActivity {
     EditText reguname, regemail, regpass, regconfirmpass;
     Button regbtn;
     TextView alreadyuser;
    ProgressDialog progressDialog;
    String emailPattern ="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("Establishing your account");
        progressDialog.setCancelable(false);

        reguname = findViewById(R.id.regUsername);
        regemail = findViewById(R.id.regEmail);
        regpass = findViewById(R.id.regPassword);
        regconfirmpass = findViewById(R.id.regConfirmPassword);
        regbtn= findViewById(R.id.regButton);
        alreadyuser = findViewById(R.id.alreadyUser);

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = reguname.getText().toString();
                String email = regemail.getText().toString();
                String pass = regpass.getText().toString();
                String confirmpass = regconfirmpass.getText().toString();

                Database db= new Database(getApplicationContext(),"healthcare",null, 1);



                if(uname.length()==0 || pass.length()==0){
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                }
                else{
                     if (!email.matches(emailPattern)) {
//                            Toast.makeText(getApplicationContext(), "Please enter a valid email address!", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        regemail.setError("Please enter a valid email address!");
                    }
                    if(pass.compareTo(confirmpass)==0){
                        if(isValid(pass)){
                          db.register(uname, email,pass);
                          Toast.makeText(getApplicationContext(), "Registered sucessfully", Toast.LENGTH_SHORT).show();
                          startActivity(new Intent(Register.this, Login.class));

                        }
                        else{
                            Toast.makeText(getApplicationContext(), "must contain atleast 6 characters, having letter, digit and special character!", Toast.LENGTH_SHORT).show();
//                            progressDialog.dismiss();
//                            regpass.setError("must contain atleast 7 characters, having letter, digit and special character!");
                        }



                    }else{
                        Toast.makeText(getApplicationContext(), "Password does not match!!", Toast.LENGTH_SHORT).show();
//                        progressDialog.dismiss();
//                        regconfirmpass.setError("Password does not match!!");
                    }
                }
            }
        });




        alreadyuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this, Login.class));
            }
        });
    }

    public static boolean isValid(String password){
        int f1=0, f2=0, f3=0;
        if(password.length()<7){
            return false;
        }else{
            for (int p=0; p<password.length();p++){
                if(Character.isLetter(password.charAt(p))){
                    f1=1;
                }
            }

            for (int q=0; q<password.length();q++){
                if(Character.isLetter(password.charAt(q))){
                    f2=1;
                }
            }

            for (int r=0; r<password.length();r++){
                if(Character.isLetter(password.charAt(r))){
                    f3=1;
                }
            }

            if(f1==1 && f2==1 && f3==1)
                    return true;
            return false;
        }
    }


}