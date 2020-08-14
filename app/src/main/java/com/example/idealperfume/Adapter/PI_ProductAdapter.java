package com.example.idealperfume.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.idealperfume.Data.ProductInfoData;
import com.example.idealperfume.R;

import java.util.ArrayList;
import java.util.List;

public class PI_ProductAdapter extends RecyclerView.Adapter<PI_ProductAdapter.ProductViewHolder> {

    Context context;
    List<ProductInfoData> mList;


    public PI_ProductAdapter(Context context, List<ProductInfoData> list) {
        this.context = context;
        this.mList = list;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.listitem_pi_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.img_product.setImageResource(mList.get(position).getProductImg());
        holder.tv_pdBrand.setText(mList.get(position).getBrand());
        holder.tv_pdName.setText(mList.get(position).getName());
        holder.tv_pdPrice.setText(String.format("%,d",mList.get(position).getPrice())+"원");
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


  // ViewHolder
    class ProductViewHolder extends RecyclerView.ViewHolder{

        ImageView img_product;
        TextView tv_pdBrand;
        TextView tv_pdName;
        TextView tv_pdPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            img_product = itemView.findViewById(R.id.img_product);
            tv_pdBrand = itemView.findViewById(R.id.tv_pdBrand);
            tv_pdName = itemView.findViewById(R.id.tv_pdName);
            tv_pdPrice = itemView.findViewById(R.id.tv_pdPrice);
        }
    }
}
