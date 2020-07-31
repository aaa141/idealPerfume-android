package com.example.idealperfume.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.idealperfume.MyPickData;
import com.example.idealperfume.R;

import java.util.List;

public class MyPickBrandAdapter extends RecyclerView.Adapter<MyPickBrandAdapter.MyViewHolder> {

    Context context;
    List<MyPickData> pickData;

    public MyPickBrandAdapter(Context context, List<MyPickData> pickData) {
        this.context = context;
        this.pickData = pickData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.listitem_mypick_brand, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_brandname.setText(pickData.get(position).getProductName() + " (" + pickData.get(position).getName_eng() + ")");
        holder.tv_branddesc.setText(pickData.get(position).getDesc());
        holder.img.setImageResource(pickData.get(position).getIcon());
    }

    @Override
    public int getItemCount() {
        return pickData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_brandname;
        private TextView tv_branddesc;
        private ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_brandname = itemView.findViewById(R.id.tv_name);
            tv_branddesc = itemView.findViewById(R.id.tv_desc);
            img = itemView.findViewById(R.id.iv_brand);
        }
    }
}
