package com.example.starwarsgson1;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by dell on 16-01-2018.
 */

public class CustomContactAdapter extends RecyclerView.Adapter<CustomContactAdapter.MyViewHolder> {

    private ArrayList<Result> arrayList = new ArrayList<>();


    public CustomContactAdapter(ArrayList<Result> arrayList) {

        this.arrayList = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.v("CreateViewHolder", "in onCreateViewHolder");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_layout,parent,false);

        return new MyViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Log.v("BindViewHolder", "in onBindViewHolder");
       Result contact = arrayList.get(position);
        holder.name.setText(contact.getName());



    }



    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {
        TextView name;
        public MyViewHolder(View itemView) {
            super(itemView);
            Log.v("ViewHolder","in View Holder");
            name = itemView.findViewById(R.id.textView);
            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  int pos=getAdapterPosition();
                  Log.d("Click","clicked"+pos);
                    Intent inte=new Intent(view.getContext(),starwarsdetails.class);

                    Result tobepassed=arrayList.get(pos);
                    inte.putExtra("mybject", tobepassed);

                    view.getContext().startActivity(inte);
                }
            });


        }


    }
}
