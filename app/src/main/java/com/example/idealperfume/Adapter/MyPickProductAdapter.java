package com.example.idealperfume.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.idealperfume.Data.MyPickData;
import com.example.idealperfume.R;

import java.util.List;

public class MyPickProductAdapter extends RecyclerView.Adapter<MyPickProductAdapter.MyViewHolder> {

    Context context;
    List<MyPickData> pickData;

    public MyPickProductAdapter(Context context, List<MyPickData> pickData) {
        this.context = context;
        this.pickData = pickData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.listitem_mypick_product, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_productname.setText(pickData.get(position).getProductName() + " (" + pickData.get(position).getName_eng() + ")");
        holder.tv_productdesc.setText(pickData.get(position).getDesc());
        holder.img.setImageResource(pickData.get(position).getIcon());
    }

    @Override
    public int getItemCount() {
        return pickData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_productname;
        private TextView tv_productdesc;
        private ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_productname = itemView.findViewById(R.id.tv_name);
            tv_productdesc = itemView.findViewById(R.id.tv_desc);
            img = itemView.findViewById(R.id.iv_brand);
        }
    }
}
