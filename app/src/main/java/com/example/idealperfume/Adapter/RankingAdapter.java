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
import com.example.idealperfume.Data.RankingData;
import com.example.idealperfume.R;

import java.text.BreakIterator;
import java.util.List;

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.MyViewHolder> {
    Context context;
    List<RankingData> rankingData;

    public RankingAdapter(Context context, List<RankingData> rankingData) {
        this.context = context;
        this.rankingData = rankingData;
    }

    @NonNull
    @Override
    public RankingAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.listitem_main_ranking, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RankingAdapter.MyViewHolder holder, int position) {
        holder.tv_rank.setText(rankingData.get(position).getRank());
        holder.tv_change.setText(rankingData.get(position).getChange());
        holder.tv_name.setText(rankingData.get(position).getName() + " (" + rankingData.get(position).getName_eng() + ")");
        holder.tv_desc.setText(rankingData.get(position).getDesc());
        holder.iv_producticon.setImageResource(rankingData.get(position).getProductimg());
    }

    @Override
    public int getItemCount() {
        return rankingData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_rank;
        private TextView tv_change;
        private TextView tv_name;
        private TextView tv_desc;
        private ImageView iv_producticon;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_rank = itemView.findViewById(R.id.tv_rank);
            tv_change = itemView.findViewById(R.id.tv_change);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_desc = itemView.findViewById(R.id.tv_desc);
            iv_producticon = itemView.findViewById(R.id.iv_producticon);
        }
    }
}
