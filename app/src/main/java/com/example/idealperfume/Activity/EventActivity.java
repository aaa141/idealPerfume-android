package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.idealperfume.Adapter.EventItemAdapter;
import com.example.idealperfume.Data.EventData;
import com.example.idealperfume.R;

import java.util.ArrayList;

public class EventActivity extends AppCompatActivity {
    private ArrayList<EventData> arrayList;
    //    private List<EventData> listeventdata;
    private EventItemAdapter eventItemAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    private RelativeLayout home, mypick, setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        home = findViewById(R.id.layout_homemenu);
        mypick = findViewById(R.id.layout_mypickmenu);
        setting = findViewById(R.id.layout_settingmenu);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        mypick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, MyPickActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, SettingActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        recyclerView = findViewById(R.id.rv_eventlist);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();

        eventItemAdapter = new EventItemAdapter(arrayList);
        recyclerView.setAdapter(eventItemAdapter);

        arrayList.add(new EventData(R.drawable.ic_launcher_background, "7.21 ~ 7.22"));
        arrayList.add(new EventData(R.drawable.ic_launcher_background, "7.21 ~ 8.22"));
        arrayList.add(new EventData(R.drawable.ic_launcher_background, "7.21 ~ 7.22"));
        arrayList.add(new EventData(R.drawable.ic_launcher_background, "7.21 ~ 8.22"));
        arrayList.add(new EventData(R.drawable.ic_launcher_background, "7.21 ~ 7.22"));
        arrayList.add(new EventData(R.drawable.ic_launcher_background, "7.21 ~ 8.22"));

        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), 1));
    }

    @Override
    public void onBackPressed() {

        super.finish();
        overridePendingTransition(0,0);
    }
}