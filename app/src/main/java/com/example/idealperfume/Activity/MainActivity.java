package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.idealperfume.Adapter.BSBasicAdapter;
import com.example.idealperfume.Adapter.EventItemAdapter;
import com.example.idealperfume.Adapter.MagazineAdapter;
import com.example.idealperfume.Adapter.MainRankingAdapter;
import com.example.idealperfume.Adapter.MyPickAdapter;
import com.example.idealperfume.Adapter.RankingAdapter;
import com.example.idealperfume.Data.EventData;
import com.example.idealperfume.Data.MagazineData;
import com.example.idealperfume.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Arrays;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity{

    private RelativeLayout mypick, event, setting;
    int pressedTime = 0;
    ImageView iv_mainbackground;

    TextView tv_rankcatecory;
    BottomSheetDialog BottomSheet;
    ArrayList<String> gender = new ArrayList<>(Arrays.asList("향수", "디퓨저", "캔들", "아로마 오일", "바디 로션"));

    private ArrayList<MagazineData> magazineData;
    private MagazineAdapter magazineAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ImageView review, perfume, diffuser, candle, aromaoil, bodylotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mypick = findViewById(R.id.layout_mypickmenu);
        event = findViewById(R.id.layout_eventmenu);
        setting = findViewById(R.id.layout_settingmenu);

        mypick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyPickActivity.class);
                startActivity(intent);
            }
        });

        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EventActivity.class);
                startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

//        iv_mainbackground = findViewById(R.id.iv_mainbackground);
//        iv_mainbackground.setColorFilter(Color.parseColor("#8c8c8c"), PorterDuff.Mode.MULTIPLY); //어두운 효과
//
//        review = findViewById(R.id.iv_review);
//        review.setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.MULTIPLY);
//        perfume = findViewById(R.id.iv_perfume);
//        perfume.setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.MULTIPLY);
//        diffuser = findViewById(R.id.iv_diffuser);
//        diffuser.setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.MULTIPLY);
//        candle = findViewById(R.id.iv_candle);
//        candle.setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.MULTIPLY);
//        aromaoil = findViewById(R.id.iv_aromaoil);
//        aromaoil.setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.MULTIPLY);
//        bodylotion = findViewById(R.id.iv_bodylotion);
//        bodylotion.setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.MULTIPLY);


        tv_rankcatecory = findViewById(R.id.tv_rankcategoty);

        tv_rankcatecory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createBasicDialog(gender, "");
            }
        });


        //Rank Viewpager
        ViewPager vp = findViewById(R.id.viewpager_rank);
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

        //테스트 바로가기 인텐트
        RelativeLayout relativeLayout = findViewById(R.id.layout_gotest);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

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

    private void createBasicDialog(final ArrayList<String> list, String title) {
        BSBasicAdapter adapter = new BSBasicAdapter(list);
        View view = getLayoutInflater().inflate(R.layout.dialog_bs_basic, null);

        //"xx"를 선택하세요.
        TextView titles = (TextView) view.findViewById(R.id.tv_bs_basic_title);
        View line = (View) view.findViewById(R.id.line_bs_title);
        titles.setText(title);

        //"xx"를 선택하세요.
        if (!title.equals("")) {
            titles.setText(title);
        } else {
            titles.setVisibility(View.GONE);
            line.setVisibility(View.GONE);
        }

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcv_bs_basic);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new BSBasicAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                tv_rankcatecory.setText(list.get(position));
                BottomSheet.dismiss();
            }
        });

        BottomSheet = new BottomSheetDialog(this);
        BottomSheet.setContentView(view);
        BottomSheet.show();

    }
}

