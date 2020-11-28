package com.example.idealperfume.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.ListFragment;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.AlteredCharSequence;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.idealperfume.Adapter.MyPickAdapter;
import com.example.idealperfume.Adapter.MyPickProductAdapter;
import com.example.idealperfume.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONObject;
import org.w3c.dom.Text;

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

public class MyPickActivity extends AppCompatActivity {

    private RelativeLayout home, event, setting;

    MyPickAdapter myPickAdapter;
    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pick);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        //하단 네비게이션
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navigationMethod(bottomNavigationView);

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0,0);
            }
        });


        ViewPager vp = findViewById(R.id.viewpager);
        myPickAdapter = new MyPickAdapter(getSupportFragmentManager());
        vp.setAdapter(myPickAdapter);

        myPickAdapter.notifyDataSetChanged();

        TabLayout tabLayout = findViewById(R.id.tab_mypick);
        tabLayout.setupWithViewPager(vp);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0,0);
    }

    public void navigationMethod(BottomNavigationView bottomNavigationView){
        bottomNavigationView.setSelectedItemId(R.id.mypick);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        finish();
                        Intent intent1 = new Intent(MyPickActivity.this, MainActivity.class);
                        intent1.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent1);
                        return true;

                    case R.id.event:
                        Intent intent2 = new Intent(MyPickActivity.this, EventActivity.class);
                        intent2.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent2);
                        finish();
                        return true;

                    case R.id.setting:
                        Intent intent3 = new Intent(MyPickActivity.this, SettingActivity.class);
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