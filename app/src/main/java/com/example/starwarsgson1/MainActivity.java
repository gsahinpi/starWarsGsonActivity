package com.example.starwarsgson1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Result> mArrayList = new ArrayList<Result>();
    private RecyclerView mRecyclerView1;

    private CustomContactAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView1 = findViewById(R.id.recyclerView);


        mAdapter = new CustomContactAdapter(mArrayList);

        mRecyclerView1.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        mRecyclerView1.setAdapter(mAdapter);
        mahmut m=new mahmut();
        m.execute();






    }


    public class mahmut extends AsyncTask<Void,Void,String> {

        @Override
        protected String doInBackground(Void... voids) {

String returned=NetworkUtils.getBookInfo("");

            return returned;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson = new Gson();
            Example userObject = gson.fromJson(s, Example.class);
            Log.d("data count",""+userObject.getCount());
           List l= userObject.getResults();

             mArrayList.addAll(l) ;


            mAdapter.notifyDataSetChanged();
        }

    }//async


    
}//maincreate
