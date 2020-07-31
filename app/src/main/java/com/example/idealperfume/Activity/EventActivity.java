package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.idealperfume.Adapter.EventItemAdapter;
import com.example.idealperfume.EventData;
import com.example.idealperfume.R;

import java.util.ArrayList;
import java.util.List;

public class EventActivity extends AppCompatActivity {
    private ArrayList<EventData> arrayList;
//    private List<EventData> listeventdata;
    private EventItemAdapter eventItemAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        recyclerView = findViewById(R.id.rv_eventlist);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();

        eventItemAdapter = new EventItemAdapter(arrayList);
        recyclerView.setAdapter(eventItemAdapter);

        arrayList.add(new EventData(R.drawable.ic_launcher_background, "7.21 ~ 7.22"));
        arrayList.add(new EventData(R.drawable.ic_launcher_background, "7.21 ~ 8.22"));

        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), 1));
    }
}