package com.example.idealperfume.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.idealperfume.Activity.MaterialsActivity;
import com.example.idealperfume.Data.MaterialsData;
import com.example.idealperfume.R;

import java.util.List;

public class MaterialsAdapter extends RecyclerView.Adapter<MaterialsAdapter.ViewHolder> {
    private Activity activity;
    private List<MaterialsData> materialsdata;
    private MaterialsActivity materialsActivity;

    public MaterialsAdapter(Activity activity, List<MaterialsData> materialsdata) {
        this.activity = activity;
        this.materialsdata = materialsdata;
    }

    @Override
    public int getItemCount() {
        return materialsdata.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView name, desc, rate;

        public ViewHolder(View itemview) {
            super(itemview);
            icon = itemview.findViewById(R.id.iv_material);
            name = itemview.findViewById(R.id.tv_materialname);
            desc = itemview.findViewById(R.id.tv_materialdesc);
            rate = itemview.findViewById(R.id.tv_materialrate);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_materials, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // 재활용 되는 View가 호출, Adapter가 해당 position에 해당하는 데이터를 결합
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        MaterialsData data = materialsdata.get(position);

        // 데이터 결합
        holder.icon.setImageResource(data.getMaterialIcon());
        holder.name.setText(data.getMaterialName());
        holder.desc.setText(data.getMaterialDesc());
        holder.rate.setText(data.getRate() + "%");
    }

}
