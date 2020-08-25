package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

import com.example.idealperfume.R;

public class ReviewRegActivity extends AppCompatActivity {
// 별점 해결해야 함

    TextView tv_changeProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_reg);

        tv_changeProduct = findViewById(R.id.tv_changeProduct);

        //제품변경에 밑줄 긋기
        SpannableString content = new SpannableString("제품변경");
        content.setSpan(new UnderlineSpan(),0,content.length(),0);
        tv_changeProduct.setText(content);
    }
}