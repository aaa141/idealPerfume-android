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

import com.example.idealperfume.Data.EventData;
import com.example.idealperfume.R;

import java.util.ArrayList;
import java.util.List;

public class EventItemAdapter extends RecyclerView.Adapter<EventItemAdapter.MyViewHolder> {

    Context context;
    List<EventData> eventData;

    public EventItemAdapter(Context context, List<EventData> eventData) {
        this.context = context;
        this.eventData = eventData;
    }

    public EventItemAdapter(ArrayList<EventData> arrayList) {
        this.eventData = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_event, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);

        //이미지 둥글게
        ImageView imageView = (ImageView) v.findViewById(R.id.iv_eventlist);
        GradientDrawable drawable =
                (GradientDrawable) ResourcesCompat.getDrawable(v.getResources(), R.drawable.image_rounding, null);
        imageView.setBackground(drawable);
        imageView.setClipToOutline(true);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.eventimg.setImageResource(eventData.get(position).getEventimg());
        holder.tv_eventdate.setText(eventData.get(position).getEventdate());
        holder.tv_eventslogan.setText(eventData.get(position).getEventslogan());
        holder.tv_eventtitle.setText(eventData.get(position).getEventtitle());
    }

    @Override
    public int getItemCount() {
        return eventData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView eventimg;
        private TextView tv_eventdate;
        private TextView tv_eventslogan;
        private TextView tv_eventtitle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            eventimg = itemView.findViewById(R.id.iv_eventlist);
            tv_eventdate = itemView.findViewById(R.id.tv_eventdate);
            tv_eventslogan = itemView.findViewById(R.id.event_slogan);
            tv_eventtitle = itemView.findViewById(R.id.event_title);
        }
    }
}
