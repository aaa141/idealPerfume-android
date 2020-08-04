package com.example.idealperfume.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.idealperfume.R;

import java.util.ArrayList;

public class PI_QuickAdapter extends RecyclerView.Adapter<PI_QuickAdapter.ViewHolder> {
    private ArrayList<String> list;

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_pi_quick);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition() ;
                    if (pos != RecyclerView.NO_POSITION) {
                        if (mListener != null) {
                            mListener.onItemClick(v, pos) ;
                        }
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position) ;
    }

    private PI_QuickAdapter.OnItemClickListener mListener = null ;

    public void setOnItemClickListener(PI_QuickAdapter.OnItemClickListener listener) {
        this.mListener = listener ;
    }

    public PI_QuickAdapter(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public PI_QuickAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pi_quick, parent, false);
        return new PI_QuickAdapter.ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(PI_QuickAdapter.ViewHolder holder, int position) {
        String str=list.get(position);
        holder.textView.setText(str);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}


