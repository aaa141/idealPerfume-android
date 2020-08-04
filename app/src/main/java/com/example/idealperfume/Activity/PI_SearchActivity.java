package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.idealperfume.Adapter.PI_SearchAdapter;
import com.example.idealperfume.R;
import com.google.android.material.tabs.TabLayout;

public class PI_SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pi_search);

        ViewPager vp = findViewById(R.id.viewpager);
        PI_SearchAdapter PI_SearchAdapter = new PI_SearchAdapter(getSupportFragmentManager());
        vp.setAdapter(PI_SearchAdapter);

        TabLayout tabLayout = findViewById(R.id.tab_pi_search);
        tabLayout.setupWithViewPager(vp);
    }
}
