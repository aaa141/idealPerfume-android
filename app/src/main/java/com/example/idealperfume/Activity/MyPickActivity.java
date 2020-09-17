package com.example.idealperfume.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.ListFragment;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.AlteredCharSequence;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.idealperfume.Adapter.MyPickAdapter;
import com.example.idealperfume.Adapter.MyPickProductAdapter;
import com.example.idealperfume.R;
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

        home = findViewById(R.id.layout_homemenu);
        event = findViewById(R.id.layout_eventmenu);
        setting = findViewById(R.id.layout_settingmenu);

        test = findViewById(R.id.test);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPickActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPickActivity.this, EventActivity.class);
                startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPickActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });


        ViewPager vp = findViewById(R.id.viewpager);
        myPickAdapter = new MyPickAdapter(getSupportFragmentManager());
        vp.setAdapter(myPickAdapter);

        myPickAdapter.notifyDataSetChanged();

        TabLayout tabLayout = findViewById(R.id.tab_mypick);
        tabLayout.setupWithViewPager(vp);
    }

}