package com.example.kalkulator_akwarystyczny;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private String[] mCalculators;
    private OnCalculatorListener mOnCalculatorListener;

    RecyclerAdapter(String[] calculators, OnCalculatorListener onCalculatorListener) {
        mCalculators = calculators;
        mOnCalculatorListener = onCalculatorListener;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.calculator_item, viewGroup, false);


        return new RecyclerViewHolder(v, mOnCalculatorListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {
        recyclerViewHolder.textView.setText(mCalculators[i]);

    }

    @Override
    public int getItemCount() {
        return mCalculators.length;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;
        OnCalculatorListener onCalculatorListener;

        RecyclerViewHolder(@NonNull View itemView, OnCalculatorListener onCalculatorListener) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView_calculatorItemTitle);
            this.onCalculatorListener = onCalculatorListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onCalculatorListener.onCalculatorClick(getAdapterPosition());
        }
    }

    public interface OnCalculatorListener {
        void onCalculatorClick(int position);
    }
}
