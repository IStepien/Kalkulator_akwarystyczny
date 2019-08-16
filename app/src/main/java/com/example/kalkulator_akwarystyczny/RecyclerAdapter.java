package com.example.kalkulator_akwarystyczny;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    String[] mCalculators;


    RecyclerAdapter (String [] calculators){
        mCalculators=calculators;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.calculator_item, viewGroup, false);


        return new RecyclerViewHolder(v); }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {
        recyclerViewHolder.textView.setText(mCalculators[i]);

    }

    @Override
    public int getItemCount() {
        return mCalculators.length;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView_calculatorItemTitle);
        }
    }
}
