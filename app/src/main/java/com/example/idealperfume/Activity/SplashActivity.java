package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.widget.TextView;

import com.example.idealperfume.R;
import com.example.idealperfume.Util.CustomTypefaceSpan;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView textView = findViewById(R.id.splashText);
        String content = textView.getText().toString();

        // 특정 문자열(이상향) BOLD체로 처리
        String word = "이상향";
        int start = content.indexOf(word);
        int end = start + word.length();

        Typeface boldFont = ResourcesCompat.getFont(getApplicationContext(),R.font.notosanskr_bold);
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder(textView.getText());
        stringBuilder.setSpan(new CustomTypefaceSpan("",boldFont)
                ,start,end, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        textView.setText(stringBuilder);

        startLoading();

    }

    private void startLoading(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, OnBoardingActivity.class);
                //main 화면으로 넘어갈 때, splash 스택에서 삭제
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
            }
        },1500);
    }

}