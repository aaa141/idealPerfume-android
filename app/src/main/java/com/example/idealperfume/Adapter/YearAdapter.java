package com.example.idealperfume.Adapter;

import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.idealperfume.R;

import java.util.ArrayList;

public class YearAdapter extends RecyclerView.Adapter<YearAdapter.ViewHolder> {
    private ArrayList<String> list;
    private int pos;

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_year);
        }
    }

    public YearAdapter(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_year, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String str=list.get(position);
        if(position==pos) {
            holder.textView.setTextColor(Color.parseColor("#000000"));
        }
        else {
            holder.textView.setTextColor(Color.parseColor("#A7A7A7"));
        }
        holder.textView.setText(str);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public String getItem(int position) {
        pos = position;
        return list.get(position);
    }
}


