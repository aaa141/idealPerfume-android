package com.example.idealperfume.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.idealperfume.Activity.PI_SearchActivity;
import com.example.idealperfume.Activity.Register2Activity;
import com.example.idealperfume.R;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    private ArrayList<String> list;
    private Context Activity;

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_green_bubble);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition() ;
                    if (pos != RecyclerView.NO_POSITION) {
                        Activity.startActivity(new Intent(Activity, PI_SearchActivity.class));
                    }
                }
            });
        }
    }

//외부에서 클릭했을 때, 내부를 바꾸고 싶다면
//    public interface OnItemClickListener {
//        void onItemClick(View v, int position) ;
//    }
//
//    private SearchAdapter.OnItemClickListener mListener = null ;
//
//    public void setOnItemClickListener(SearchAdapter.OnItemClickListener listener) {
//        this.mListener = listener ;
//    }

    public SearchAdapter(Context con, ArrayList<String> list) {
        Activity = con;
        this.list = list;
    }

    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_green_bubble, parent, false);
        return new SearchAdapter.ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(SearchAdapter.ViewHolder holder, int position) {
        String str=list.get(position);
        holder.textView.setText(str);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
