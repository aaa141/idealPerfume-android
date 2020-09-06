package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.example.idealperfume.R;

import java.text.DecimalFormat;

public class LoadingActivity extends AppCompatActivity {

    TextView reviewCounter, text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        reviewCounter = findViewById(R.id.tv_reviewCounter);
        text = findViewById(R.id.text);

        text.getBackground().setAlpha(51);
        ValueAnimator animator = ValueAnimator.ofInt(0, 5278687);
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                DecimalFormat decimalFormat = new DecimalFormat("#,###");
                reviewCounter.setText(decimalFormat.format(animation.getAnimatedValue()));
            }
        });
        animator.start();


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LoadingActivity.this, SplashActivity.class);
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        },1500);
    }
}