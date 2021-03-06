package com.example.idealperfume.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.idealperfume.Adapter.BSBasicAdapter;
import com.example.idealperfume.Adapter.EventItemAdapter;
import com.example.idealperfume.Adapter.MagazineAdapter;
import com.example.idealperfume.Adapter.MainCategoryAdapter;
import com.example.idealperfume.Adapter.MainRankingAdapter;
import com.example.idealperfume.Adapter.MyPickAdapter;
import com.example.idealperfume.Adapter.RankingAdapter;
import com.example.idealperfume.Data.EventData;
import com.example.idealperfume.Data.MagazineData;
import com.example.idealperfume.Data.MainCategoryData;
import com.example.idealperfume.Preferences.AppData;
import com.example.idealperfume.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity{

    private LinearLayout mypick, event, setting;
    int pressedTime = 0;

    AppData appData;
    TextView tv_rankcatecory, tv_login;
    BottomSheetDialog BottomSheet;
    ArrayList<String> gender = new ArrayList<>(Arrays.asList("??????", "?????????", "??????", "????????? ??????", "?????? ??????"));

    private ArrayList<MagazineData> magazineData;
    private MagazineAdapter magazineAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        tv_login = findViewById(R.id.tv_login);

        appData = AppData.getInstance(getApplicationContext());
        Log.d("ssssss", appData.getPREF_LOGIN_ID());
        

        if (appData.getPREF_LOGIN().equals("y")) {
            tv_login.setText(appData.getPREF_LOGIN_ID() + "???\n????????? ????????????\n??????????????????????");
        }


        //?????? ???????????????
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navigationMethod(bottomNavigationView);

        //???????????? ?????? ????????????
        ImageView iv_mainbackground = findViewById(R.id.iv_mainbackground);
        Glide.with(this).load(R.drawable.mainbackground).into(iv_mainbackground);

        //?????? ?????? ????????? search Activity??? ??????
        TextView tv_gotoSearch = findViewById(R.id.tv_gotoSearch);
        tv_gotoSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentA = new Intent(MainActivity.this, SearchActivity.class);
                intentA.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intentA);
            }
        });

        //???????????? ??????
        createCategory();

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

        //????????? ?????????
        recyclerView = findViewById(R.id.rv_idealmagagine);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);

        magazineData = new ArrayList<>();

        magazineAdapter = new MagazineAdapter(magazineData);
        recyclerView.setAdapter(magazineAdapter);

        magazineData.add(new MagazineData(R.drawable.main_bodylotion, "?????????", "illiyoon", "?????? ???????????? ?????? ???????????? ?????? ???????????? ??????"));
        magazineData.add(new MagazineData(R.drawable.main_candle, "?????????", "illiyoon", "????????? ????????? ?????? ?????? ?????????"));

        //????????? ???????????? ?????????
//        RelativeLayout relativeLayout = findViewById(R.id.layout_gotest);
//        relativeLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    }

    @Override
    public void onBackPressed() {
        if ( pressedTime == 0 ) {
            Toast.makeText(MainActivity.this, " ??? ??? ??? ????????? ???????????????." , Toast.LENGTH_LONG).show();
            pressedTime = (int) System.currentTimeMillis();
        }
        else {
            int seconds = (int) (System.currentTimeMillis() - pressedTime);

            if ( seconds > 2000 ) {
                Toast.makeText(MainActivity.this, " ??? ??? ??? ????????? ???????????????." , Toast.LENGTH_LONG).show();
                pressedTime = 0 ;
            }
            else {
                super.onBackPressed();
//                finish(); // app ?????? ?????????
            }
        }
    }

    private void createBasicDialog(final ArrayList<String> list, String title) {
        BSBasicAdapter adapter = new BSBasicAdapter(list);
        View view = getLayoutInflater().inflate(R.layout.dialog_bs_basic, null);

        //"xx"??? ???????????????.
        TextView titles = (TextView) view.findViewById(R.id.tv_bs_basic_title);
        View line = (View) view.findViewById(R.id.line_bs_title);
        titles.setText(title);

        //"xx"??? ???????????????.
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

    private void createCategory(){
        ArrayList<MainCategoryData>mcategorylist = new ArrayList<MainCategoryData>(){{
                add(new MainCategoryData(R.drawable.main_review,"?????? ?????????"));
                add(new MainCategoryData(R.drawable.main_perfume,"??????"));
                add(new MainCategoryData(R.drawable.main_diffuser,"?????????"));
                add(new MainCategoryData(R.drawable.main_candle,"??????"));
                add(new MainCategoryData(R.drawable.main_aromaoil,"????????? ??????"));
                add(new MainCategoryData(R.drawable.main_bodylotion,"????????????"));
            }
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcv_category);
        recyclerView.setNestedScrollingEnabled(false);
        MainCategoryAdapter adapter = new MainCategoryAdapter(getApplicationContext(),mcategorylist);
        GridLayoutManager layoutManager;

        layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void navigationMethod(BottomNavigationView bottomNavigationView){
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.mypick:
                        Intent intent1 = new Intent(MainActivity.this, MyPickActivity.class);
                        intent1.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent1);
                        return false;

                    case R.id.event:
                        Intent intent2 = new Intent(MainActivity.this, EventActivity.class);
                        intent2.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent2);
                        return false;

                    case R.id.setting:
                        Intent intent3 = new Intent(MainActivity.this, SettingActivity.class);
                        intent3.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent3);
                        return false;
                }
                return false;
            }
        });
    }
}

