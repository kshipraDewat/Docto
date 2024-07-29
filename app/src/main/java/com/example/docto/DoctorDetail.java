package com.example.docto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetail extends AppCompatActivity {

     private String[][] doctorDetailPhysician ={
             {"Doctor Name : Sudhir Sharma","Address : Nirman Nagar","Exp : 5yrs", "Mobile No : 9460561212", "200"},
             {"Doctor Name : Varun Mathur","Address : Model Town","Exp : 5yrs", "Mobile No : 9549322220", "400"},
             {"Doctor Name : Vikash Mittal","Address : Sodala","Exp : 5yrs", "Mobile No : 9785906095", "500"},
             {"Doctor Name : Abha Sharma","Address : Sodala","Exp : 5yrs", "Mobile No : 8769890028", "200"},
             {"Doctor Name : Vipul Agarwal","Address : Vaishali Nagar","Exp : 5yrs", "Mobile No : 8902983293", "350"},
             {"Doctor Name : Niranjan Singh","Address : Vaishali Nagar","Exp : 5yrs", "Mobile No :  079766 64252", "250"},
             {"Doctor Name : Harish K. Sharma","Address : Jothwara","Exp : 5yrs", "Mobile No : 094136 06725", "300"},
             {"Doctor Name :  Somesh Gupta","Address :  Milap Nagar","Exp : 5yrs", "Mobile No : 098290 61197", "450"},
             {"Doctor Name :  L N Meena","Address :  Bassi","Exp : 5yrs", "Mobile No : 098290 61197", "450"},





     };

    private String[][] doctorDetailDietician ={
            {"Doctor Name :  Niru Mathur","Address : jaipur","Exp : 5yrs", "Mobile No : 9001817259", "300"},
            {"Doctor Name :  Rajat Jain","Address :  Adinath Nagar","Exp : 5yrs", "Mobile No : 9116999294", "500"},
            {"Doctor Name : Neha Yaduvanshi","Address :Jothwara","Exp : 5yrs", "Mobile No : 8447009334", "800"},
            {"Doctor Name : Neha Dua","Address : Raja Park","Exp : 5yrs", "Mobile No : 7976571656", "550"},
            {"Doctor Name : Anamika","Address : Durgapura","Exp : 5yrs", "Mobile No : 9314017920", "499"},
            {"Doctor Name : Neha Yaduvanshi","Address : jaipur","Exp : 5yrs", "Mobile No : 8447009334","500"},

           {"Doctor Name : Surbhi","Address : jaipur","Exp : 5yrs", "Mobile No : 9672703936","600"},

           {"Doctor Name : Sonal","Address : jaipur","Exp : 5yrs", "Mobile No :  9828409404","700"},

            {"Doctor Name : Tanushree Bhargava ","Address : jaipur","Exp : 5yrs", "Mobile No : 7568153534","799"}
    };
    private String[][] doctorDetailDentist ={
            {"Doctor Name : Rimmi Shekhawat","Address :  Vaishali Nagar","Exp : 5yrs", "Mobile No : 9636180333", "500"},
            {"Doctor Name : Nitika Jain","Address : Jawahar Nagar","Exp : 5yrs", "Mobile No : 96608 34448", "300"},
            {"Doctor Name : Divya","Address : Lalkothi","Exp : 5yrs", "Mobile No : 9660025726", "700"},
            {"Doctor Name : Abha Sharma","Address : jaipur","Exp : 5yrs", "Mobile No : 8769890028", "550"},
            {"Doctor Name : Abha Sharma","Address : jaipur","Exp : 5yrs", "Mobile No : 8769890028", "200"},
            {"Doctor Name : Sourabh Chaturvedy","Address :Vaishali nagar, jaipur","Exp : 5yrs", "Mobile No : 9468869266","500"},
            {"Doctor Name : Dr Anupama","Address :Vaishali nagar, jaipur","Exp : 5yrs", "Mobile No : 7976346051","500"},
            {"Doctor Name : Deshant Agarwal","Address :Sodala, jaipur","Exp : 5yrs", "Mobile No : 9950894683","500"},
            {"Doctor Name : Rimmy Shekhawat","Address :Vaishali nagar, jaipur","Exp : 5yrs", "Mobile No : 9636180333","500"},
            {"Doctor Name : Renu Garg","Address :Gautam marg, jaipur","Exp : 5yrs", "Mobile No : 9468529267","500"}

    };

    private String[][] doctorDetailSurgeon ={
            {"Doctor Name : S K Jain","Address : Gopalpura","Exp : 5yrs", "Mobile No : 014127636772", "2000"},
            {"Doctor Name : K C Bansal","Address : Sanganer","Exp : 5yrs", "Mobile No : 9983761169", "1500"},
            {"Doctor Name : A K Mathur","Address : Bapu Nagar","Exp : 5yrs", "Mobile No : 9829051260", "500"},
            {"Doctor Name : Sourabh Rawat","Address : Mansarovar","Exp : 5yrs", "Mobile No : 8764009989", "800"},
            {"Doctor Name : Sachin Gupta","Address : Shastri Nagar","Exp : 5yrs", "Mobile No : 954900677", "1000"},
            {"Doctor Name : Jaideep Mathur","Address : jaipur","Exp : 5yrs", "Mobile No : 9950995625","1200"},
            {"Doctor Name : Ajay Agarwal","Address : jaipur","Exp : 5yrs", "Mobile No : 7720044008","1000"},
            {"Doctor Name : Ajay Sharma","Address : jaipur","Exp : 5yrs", "Mobile No : 9314925742 ","1500"},
            {"Doctor Name : Amit Sharma","Address : jaipur","Exp : 5yrs", "Mobile No : 7726072602","2500"}

    };

    private String[][] doctorDetailCardiologist ={
            {"Doctor Name : Dr Rahul Sharma","Address : Sodala, jaipur","Exp : 5yrs", "Mobile No : 6376993553","500"},
            {"Doctor Name : Dr Anshu Kabra","Address :Vaishali nagar, jaipur","Exp : 5yrs", "Mobile No : 8107998382","500"},
            {"Doctor Name : Amit Gupta","Address :Vidhyadhar nagar, jaipur","Exp : 5yrs", "Mobile No : 8527956826","500"},
            {"Doctor Name : B M Goyal","Address :Jagatpura jaipur","Exp : 5yrs", "Mobile No : 9413190570","500"},
        {"Doctor Name : Anil Gupta","Address :Rajat Path, jaipur","Exp : 5yrs", "Mobile No : 8233620997","500"},
        {"Doctor Name : Rahul Singhal","Address :Raja Park jaipur","Exp : 5yrs", "Mobile No : 9560694848","500"},
        {"Doctor Name : Lalit Malik","Address :Vidhyadhar nagar, jaipur","Exp : 5yrs", "Mobile No : 8802801381","500"},
        {"Doctor Name : Ankit Gupta","Address :Gopalpura Bypass, jaipur","Exp : 5yrs", "Mobile No : 9413268070","500"},
            {"Doctor Name : Rudradev pandey","Address :Shipra path, jaipur","Exp : 5yrs", "Mobile No : 9549190800","500"},
            {"Doctor Name : G L Sharma","Address :Lalkothi, jaipur","Exp : 5yrs", "Mobile No : 9829011567","500"}

    };

     TextView doctordetailtitle ;
     Button backbutton;

     String[][] getDoctorDetail ={};
     HashMap<String, String> item;
     ArrayList list;
     SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctor_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        doctordetailtitle = findViewById(R.id.doctorDetailTitle);
        backbutton = findViewById(R.id.buttonDDback);


        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        doctordetailtitle.setText(title);

        if(title.compareTo("Physician")==0){
            getDoctorDetail =doctorDetailPhysician;
        }
        if(title.compareTo("Dietician")==0){
            getDoctorDetail =doctorDetailDietician;
        }
        if(title.compareTo("Dentist")==0){
            getDoctorDetail =doctorDetailDentist;
        }
        if(title.compareTo("Surgeon")==0){
            getDoctorDetail =doctorDetailSurgeon;
        }
        if(title.compareTo("Cardiologist")==0){
            getDoctorDetail =doctorDetailCardiologist;
        }


        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetail.this, FindDoctor.class));
            }
        });

        list = new ArrayList();
        for(int i=0; i<getDoctorDetail.length; i++){
            item = new HashMap<String , String>();
            item.put("line1", getDoctorDetail[i][0]);
            item.put("line2", getDoctorDetail[i][1]);
            item.put("line3", getDoctorDetail[i][2]);
            item.put("line4", getDoctorDetail[i][3]);
            item.put("line5", "Cons Fees: "+getDoctorDetail[i][4]+ "/-");
            list.add(item);
        }

        adapter = new SimpleAdapter(this,list,
                R.layout.multilines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.lineA, R.id.lineB,R.id.lineC,R.id.lineD,R.id.lineE}
        );

        ListView lst = findViewById(R.id.listView);
        lst.setAdapter(adapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetail.this ,Appointment.class);
                it.putExtra("text1",title);
                it.putExtra("text2",getDoctorDetail[i][0]);
                it.putExtra("text3",getDoctorDetail[i][1]);
                it.putExtra("text4",getDoctorDetail[i][3]);
                it.putExtra("text5",getDoctorDetail[i][4]);
                startActivity(it);
            }
        });




    }
}