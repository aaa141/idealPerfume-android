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

public class MyPickProductAdapter extends RecyclerView.Adapter {

    Context context;
    List<MyPickData> listpickdata;

    public MyPickProductAdapter(Context context, List<MyPickData> listpickdata) {
        this.context = context;
        this.listpickdata = listpickdata;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        if (viewType == 0) {
            view = layoutInflater.inflate(R.layout.listitem_mypick_product, parent, false);
            return new MyPickViewHolder(view);
        } else {
            view = layoutInflater.inflate(R.layout.listitem_mypick_folder, parent, false);
            return new FolderViewHolder(view);
        }

//        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof MyPickViewHolder)
        {
            ((MyPickViewHolder) holder).tv_productname.setText(listpickdata.get(position).getProductName() + " (" + listpickdata.get(position).getSub() + ")");
            ((MyPickViewHolder) holder).tv_productdesc.setText(listpickdata.get(position).getDesc());
            ((MyPickViewHolder) holder).icon.setImageResource(listpickdata.get(position).getIcon());

        }
        else if(holder instanceof FolderViewHolder)
        {
            ((FolderViewHolder) holder).tv_foldername.setText(listpickdata.get(position).getProductName()+ " (" + listpickdata.get(position).getSub() + ")");
            ((FolderViewHolder) holder).tv_folderdesc.setText(listpickdata.get(position).getDesc());
            ((FolderViewHolder) holder).icon.setImageResource(listpickdata.get(position).getIcon());
        }
    }

    @Override
    public int getItemCount() {
        return listpickdata.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (listpickdata.get(position).getViewType() ==  MyPickData.Code.ViewType.ProductListItem)
            return 0;
        else return 1;
    }

    public class MyPickViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_productname;
        private TextView tv_productdesc;
        private ImageView icon;

        MyPickViewHolder(View itemView)
        {
            super(itemView);

            tv_productname = itemView.findViewById(R.id.tv_name);
            tv_productdesc = itemView.findViewById(R.id.tv_desc);
            icon = itemView.findViewById(R.id.iv_brand);
        }
    }

    public class FolderViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_foldername;
        private TextView tv_folderdesc;
        private ImageView icon;

        FolderViewHolder(View itemView)
        {
            super(itemView);

            tv_foldername = itemView.findViewById(R.id.tv_fname);
            tv_folderdesc = itemView.findViewById(R.id.tv_fdesc);
            icon = itemView.findViewById(R.id.iv_foldericon);
        }
    }

}
