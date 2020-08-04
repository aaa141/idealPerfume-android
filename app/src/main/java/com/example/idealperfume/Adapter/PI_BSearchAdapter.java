package com.example.idealperfume.Adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.idealperfume.Data.Pi_BSearchData;
import com.example.idealperfume.R;

import java.util.ArrayList;

public class PI_BSearchAdapter extends RecyclerView.Adapter<PI_BSearchAdapter.CustomViewHolder> {

    private ArrayList<Pi_BSearchData> mList;
    Context context;

    public PI_BSearchAdapter(Context context, ArrayList<Pi_BSearchData> list) {
        this.context = context;
        this.mList = list;
    }

    @Override
    public PI_BSearchAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.list_pi_bsearch, viewGroup, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.iv_brand);
        GradientDrawable drawable =
                (GradientDrawable) ResourcesCompat.getDrawable(view.getResources(), R.drawable.image_rounding, null);
        imageView.setBackground(drawable);
        imageView.setClipToOutline(true);

        PI_BSearchAdapter.CustomViewHolder viewHolder = new PI_BSearchAdapter.CustomViewHolder(view);

        return viewHolder;
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView brandName;
        protected TextView slogan;
        protected ImageView brandImage;
        protected ImageView heartImage;

        public CustomViewHolder(View view) {
            super(view);
            this.brandName = (TextView) view.findViewById(R.id.tv_brandName);
            this.slogan = (TextView) view.findViewById(R.id.tv_slogan);
            this.brandImage = (ImageView) view.findViewById(R.id.iv_brand);
            this.heartImage = (ImageView) view.findViewById(R.id.iv_heart);

            heartImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition() ;
                    if (!mList.get(position).isHeart() == true) {
                        heartImage.setImageResource(R.drawable.heart_on);
                        mList.get(position).setHeart(true);
                    }
                    else{
                        heartImage.setImageResource(R.drawable.heart_off);
                        mList.get(position).setHeart(false);
                    }
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(@NonNull PI_BSearchAdapter.CustomViewHolder holder, int position) {
        holder.brandName.setText(mList.get(position).getBrandName());
        holder.slogan.setText(mList.get(position).getSlogan());
        holder.brandImage.setImageResource(mList.get(position).getBrandImage());
        if(mList.get(position).isHeart() == true){
            holder.heartImage.setImageResource(R.drawable.heart_on);
        }
        else{
            holder.heartImage.setImageResource(R.drawable.heart_off);
        }
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

}