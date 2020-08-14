package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.idealperfume.Adapter.EventItemAdapter;
import com.example.idealperfume.Adapter.MagazineAdapter;
import com.example.idealperfume.Adapter.MainRankingAdapter;
import com.example.idealperfume.Adapter.MyPickAdapter;
import com.example.idealperfume.Adapter.RankingAdapter;
import com.example.idealperfume.Data.EventData;
import com.example.idealperfume.Data.MagazineData;
import com.example.idealperfume.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    int pressedTime = 0;
    ImageView iv_mainbackground;

    private ArrayList<MagazineData> magazineData;
    private MagazineAdapter magazineAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_mainbackground = findViewById(R.id.iv_mainbackground);
        iv_mainbackground.setColorFilter(Color.parseColor("#BDBDBD"), PorterDuff.Mode.MULTIPLY); //어두운 효과

        ViewPager vp = findViewById(R.id.viewpager);
        MainRankingAdapter mainRankingAdapter = new MainRankingAdapter(getSupportFragmentManager());
        vp.setAdapter(mainRankingAdapter);

        TabLayout tabLayout = findViewById(R.id.tab_ranking);
        tabLayout.setupWithViewPager(vp);

        recyclerView = findViewById(R.id.rv_idealmagagine);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        magazineData = new ArrayList<>();

        magazineAdapter = new MagazineAdapter(magazineData);
        recyclerView.setAdapter(magazineAdapter);

        magazineData.add(new MagazineData(R.drawable.ic_launcher_background, "일리윤", "illiyoon", "피부 스스로의 힘을 키워주는 리얼 시카라인 출시"));
        magazineData.add(new MagazineData(R.drawable.ic_launcher_background, "일리윤", "illiyoon", "나만의 휴식을 위한 필수 아이템"));
    }


    @Override
    public void onBackPressed() {
        if ( pressedTime == 0 ) {
            Toast.makeText(MainActivity.this, " 한 번 더 누르면 종료됩니다." , Toast.LENGTH_LONG).show();
            pressedTime = (int) System.currentTimeMillis();
        }
        else {
            int seconds = (int) (System.currentTimeMillis() - pressedTime);

            if ( seconds > 2000 ) {
                Toast.makeText(MainActivity.this, " 한 번 더 누르면 종료됩니다." , Toast.LENGTH_LONG).show();
                pressedTime = 0 ;
            }
            else {
                super.onBackPressed();
//                finish(); // app 종료 시키기
            }
        }
    }

}

