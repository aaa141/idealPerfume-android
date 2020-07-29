package com.example.idealperfume.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.ListFragment;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.AlteredCharSequence;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.idealperfume.Adapter.MyPickAdapter;
import com.example.idealperfume.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MyPickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pick);

        ViewPager vp = findViewById(R.id.viewpager);
        MyPickAdapter myPickAdapter = new MyPickAdapter(getSupportFragmentManager());
        vp.setAdapter(myPickAdapter);

        TabLayout tabLayout = findViewById(R.id.tab_mypick);
        tabLayout.setupWithViewPager(vp);
    }
}