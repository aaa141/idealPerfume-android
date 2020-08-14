package com.example.idealperfume.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.idealperfume.Activity.PI_SearchActivity;
import com.example.idealperfume.Activity.ProductInfoActivity;
import com.example.idealperfume.Data.Pi_PSearchData;
import com.example.idealperfume.R;

import java.util.ArrayList;

public class PI_PSearchAdapter extends RecyclerView.Adapter<PI_PSearchAdapter.CustomViewHolder> {

    private ArrayList<Pi_PSearchData> mList;
    Context context;

    public PI_PSearchAdapter(Context context, ArrayList<Pi_PSearchData> list) {
        this.context = context;
        this.mList = list;
    }

    @Override
    public PI_PSearchAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.list_pi_psearch, viewGroup, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.iv_product);
        GradientDrawable drawable =
                (GradientDrawable) ResourcesCompat.getDrawable(view.getResources(), R.drawable.image_rounding, null);
        imageView.setBackground(drawable);
        imageView.setClipToOutline(true);

        PI_PSearchAdapter.CustomViewHolder viewHolder = new PI_PSearchAdapter.CustomViewHolder(view);

        return viewHolder;
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView brandName;
        protected TextView reviewCnt;
        protected TextView starPoint;
        protected TextView productName;
        protected TextView price;
        protected ImageView prodImage;
        protected ImageView heartImage;

        public CustomViewHolder(View view) {
            super(view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition() ;
                    if (pos != RecyclerView.NO_POSITION) {
                        context.startActivity(new Intent(context, ProductInfoActivity.class));
                    }
                }
            });

            this.brandName = (TextView) view.findViewById(R.id.tv_brandName);
            this.productName = (TextView) view.findViewById(R.id.tv_productName);
            this.price = (TextView) view.findViewById(R.id.tv_price);
            this.starPoint = (TextView) view.findViewById(R.id.tv_starPoint);
            this.reviewCnt = (TextView) view.findViewById(R.id.tv_reviewCnt);
            this.prodImage = (ImageView) view.findViewById(R.id.iv_product);
            this.heartImage = (ImageView) view.findViewById(R.id.iv_heart);

            heartImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition() ;
                    if (!mList.get(position).isHeart() == true) {
                        CreateQuestionDialog(heartImage, position);
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
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.reviewCnt.setText(mList.get(position).getReviewCnt());
        holder.brandName.setText(mList.get(position).getBrandName());
        holder.price.setText(mList.get(position).getPrice());
        holder.productName.setText(mList.get(position).getProdName());
        holder.starPoint.setText(mList.get(position).getStarPoint());
        holder.prodImage.setImageResource(mList.get(position).getProdImage());
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

    private void CreateQuestionDialog(final ImageView heart, final int position) {
        final Dialog customDialog = new Dialog(context);
        customDialog.setContentView(R.layout.dialog_heart_question);
        customDialog.show();

        customDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        customDialog.setCancelable(true);
        final Button folderBtn = (Button) customDialog.findViewById(R.id.btn_folder);
        final Button prodBtn = (Button) customDialog.findViewById(R.id.btn_product);

        folderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog.dismiss();
                CreateSuccessDialog(heart, position);
            }
        });

        prodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog.dismiss();
                CreateSuccessDialog(heart, position);
            }
        });

    }

    private void CreateSuccessDialog(ImageView heart, int position) {
        final Dialog customDialog = new Dialog(context);
        customDialog.setContentView(R.layout.dialog_heart_success);
        customDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        customDialog.show();
        customDialog.setCancelable(true);
        heart.setImageResource(R.drawable.heart_on);

        mList.get(position).setHeart(true);
        final Button closeBtn = (Button) customDialog.findViewById(R.id.btn_close);

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog.dismiss();
            }
        });
    }
}
