package com.example.idealperfume.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.idealperfume.Activity.ProductInfoActivity;
import com.example.idealperfume.Activity.ReviewRegActivity;
import com.example.idealperfume.Activity.SearchActivity;
import com.example.idealperfume.Data.MainCategoryData;
import com.example.idealperfume.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainCategoryAdapter extends RecyclerView.Adapter<MainCategoryAdapter.CustomViewHolder> {

    private ArrayList<MainCategoryData> mList;
    Context context;

    public MainCategoryAdapter(Context context, ArrayList<MainCategoryData> list) {
        this.context = context;
        this.mList = list;
    }

    @Override
    public MainCategoryAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.list_main_category, viewGroup, false);

        //이미지 완전히 둥글게
        ImageView imageView = view.findViewById(R.id.iv_category);
        imageView.setBackground(new ShapeDrawable(new OvalShape()));
        imageView.setClipToOutline(true);

        MainCategoryAdapter.CustomViewHolder viewHolder = new MainCategoryAdapter.CustomViewHolder(view);

        return viewHolder;
    }


   public class CustomViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_category;
        private ImageView iv_category;
        public CustomViewHolder(View view) {
            super(view);
            this.tv_category = (TextView) view.findViewById(R.id.tv_category);
            this.iv_category = (ImageView) view.findViewById(R.id.iv_category);

            //아이템 클릭 이벤트
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition() ;
                    if (pos != RecyclerView.NO_POSITION) {
                        switch (pos){
                            case 0:
                                context.startActivity(new Intent(context, ReviewRegActivity.class));
                                break;

                            default:
                                context.startActivity(new Intent(context, SearchActivity.class));
                        }
                    }
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.tv_category.setText(mList.get(position).getTv_category());
        holder.iv_category.setImageResource(mList.get(position).getIv_category());
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

}
