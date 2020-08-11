package com.example.idealperfume.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.idealperfume.Data.EventData;
import com.example.idealperfume.Data.MagazineData;
import com.example.idealperfume.R;

import java.util.ArrayList;
import java.util.List;

public class MagazineAdapter extends RecyclerView.Adapter<MagazineAdapter.MyViewHolder> {

    Context context;
    List<MagazineData> magazineData;

    public MagazineAdapter(Context context, List<MagazineData> magazineData) {
        this.context = context;
        this.magazineData = magazineData;
    }

    public MagazineAdapter(ArrayList<MagazineData> magazineData) {
        this.magazineData = magazineData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_magazine, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.iv_magazineimg.setImageResource(magazineData.get(position).getMagazineImg());
        holder.tv_name.setText(magazineData.get(position).getName() + " (" + magazineData.get(position).getName_eng() + ")");
        holder.tv_desc.setText(magazineData.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return magazineData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_magazineimg;
        private TextView tv_name;
        private TextView tv_desc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_magazineimg = itemView.findViewById(R.id.iv_magazineimg);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_desc = itemView.findViewById(R.id.tv_desc);
        }
    }
}
