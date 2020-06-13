package com.example.converter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class СurrencyAdapter extends RecyclerView.Adapter<СurrencyAdapter.ViewHolder> {
    private Context context;
    private static Double Value = 1.0;
    private LayoutInflater inflater;
    ArrayList<ConverterRow> Base;

    public СurrencyAdapter(Context context, ArrayList<ConverterRow> Base) {
        this.context = context;
        this.Base = Base;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public СurrencyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View subj = inflater.inflate(R.layout.currency_item, parent, false);
        return new ViewHolder(subj);
    }

    @Override
    public void onBindViewHolder(@NonNull СurrencyAdapter.ViewHolder holder, int position) {
        holder.name.setText(Base.get(position).name);
        holder.value.setText(String.format("%.2f", Base.get(position).Course * Value).replace(",", "."));
        holder.value.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (holder.value.getText().toString().equals("")) Value = 0.0;
                    else {
                        Value = Double.parseDouble(holder.value.getText().toString()) / Base.get(position).Course;
                    }
                    MainActivity.ResetAdapter(context);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return Base.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView value;

        ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.Name);
            value = view.findViewById(R.id.Value);
        }
    }
}
