package com.example.idealperfume.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.idealperfume.Adapter.EventItemAdapter;
import com.example.idealperfume.Data.EventData;
import com.example.idealperfume.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

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

        //네비게이션 바
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navigationMethod(bottomNavigationView);

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
        //recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));

        arrayList = new ArrayList<>();

        eventItemAdapter = new EventItemAdapter(arrayList);
        recyclerView.setAdapter(eventItemAdapter);

        arrayList.add(new EventData(R.drawable.tmp_event1, "7.21 ~ 7.22", "향수 주말 특가 50000원", "4일 동안만 진행되는 할인"));
        arrayList.add(new EventData(R.drawable.tmp_event2, "7.21 ~ 7.22", "향수 주말 특가 50000원", "4일 동안만 진행되는 할인"));
        arrayList.add(new EventData(R.drawable.tmp_event3, "7.21 ~ 7.22", "향수 주말 특가 50000원", "4일 동안만 진행되는 할인"));
    }

    @Override
    public void onBackPressed() {
        super.finish();
        overridePendingTransition(0,0);
    }

    public void navigationMethod(BottomNavigationView bottomNavigationView){
        bottomNavigationView.setSelectedItemId(R.id.event);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        finish();
                        Intent intent1 = new Intent(EventActivity.this, MainActivity.class);
                        intent1.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent1);
                        return true;

                    case R.id.setting:
                        Intent intent2 = new Intent(EventActivity.this, SettingActivity.class);
                        intent2.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent2);
                        finish();
                        return true;

                    case R.id.mypick:
                        Intent intent3 = new Intent(EventActivity.this, MyPickActivity.class);
                        intent3.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent3);
                        finish();
                        return true;
                }
                return false;
            }
        });
    }
}