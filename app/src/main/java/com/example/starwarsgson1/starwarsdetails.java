package com.example.starwarsgson1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class starwarsdetails extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6,t7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starwarsdetails);


        t1=findViewById(R.id.textView2);
        t2=findViewById(R.id.textView3);
        t3=findViewById(R.id.textView4);
        t4=findViewById(R.id.textView5);
        t5=findViewById(R.id.textView6);
        t6=findViewById(R.id.textView7);
        t7=findViewById(R.id.textView8);
        Intent local=getIntent();
        Result passedtome= (Result) local.getSerializableExtra("mybject");
        Log.d("output",passedtome.getName());
        t1.setText(passedtome.getName());
        t2.setText(passedtome.getBirthYear());
        t3.setText(passedtome.getGender());
        t4.setText(passedtome.getHomeworld());
        t5.setText(passedtome.getSpecies().toString());
        t6.setText(passedtome.getVehicles().toString());
        t7.setText(passedtome.getMass());





    }
}
