package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.idealperfume.Adapter.OnBoardingSliderAdapter;
import com.example.idealperfume.R;

import org.w3c.dom.Text;

public class OnBoardingActivity extends AppCompatActivity {

    private ViewPager2 mSlideViewPager;
    private TextView tv_skip;
    private ImageView img_step;
    private OnBoardingSliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        mSlideViewPager = (ViewPager2) findViewById(R.id.slideViewPager);
        img_step = (ImageView) findViewById(R.id.img_step);
        tv_skip = (TextView) findViewById(R.id.tv_skip);

        tv_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnBoardingActivity.this, MainActivity.class);
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
            }
        });

        sliderAdapter = new OnBoardingSliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);
        mSlideViewPager.registerOnPageChangeCallback(callback);

    }


    ViewPager2.OnPageChangeCallback callback = new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0: img_step.setImageResource(R.drawable.img_step_03); break;
                case 1: img_step.setImageResource(R.drawable.img_step_02); break;
                case 2: img_step.setImageResource(R.drawable.img_step_01); break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
        }
    };
}