package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.idealperfume.R;

public class ReviewFilterActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_ageAll, tv_10, tv_early20, tv_late20, tv_early30, tv_late30, tv_over40,
            tv_genderAll, tv_female, tv_male, tv_reviewAll, tv_reviewPositive, tv_reviewNegative;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_filter);

        tv_ageAll = findViewById(R.id.tv_ageAll);
        tv_10 = findViewById(R.id.tv_10);
        tv_early20 = findViewById(R.id.tv_early20);
        tv_late20 = findViewById(R.id.tv_late20);
        tv_early30 = findViewById(R.id.tv_early30);
        tv_late30 = findViewById(R.id.tv_late30);
        tv_over40 = findViewById(R.id.tv_over40);
        tv_genderAll = findViewById(R.id.tv_genderAll);
        tv_female = findViewById(R.id.tv_female);
        tv_male = findViewById(R.id.tv_male);
        tv_reviewAll = findViewById(R.id.tv_reviewAll);
        tv_reviewPositive = findViewById(R.id.tv_reviewPositive);
        tv_reviewNegative = findViewById(R.id.tv_reviewNegative);


        tv_ageAll.setOnClickListener(this);
        tv_10.setOnClickListener(this);
        tv_early20.setOnClickListener(this);
        tv_late20.setOnClickListener(this);
        tv_early30.setOnClickListener(this);
        tv_late30.setOnClickListener(this);
        tv_over40.setOnClickListener(this);
        tv_genderAll.setOnClickListener(this);
        tv_female.setOnClickListener(this);
        tv_male.setOnClickListener(this);
        tv_reviewAll.setOnClickListener(this);
        tv_reviewPositive.setOnClickListener(this);
        tv_reviewNegative.setOnClickListener(this);


        init();
    }

    public void init() {

        //현재 적용된 필터 가져오기

        //
        tv_ageAll.setBackground(getDrawable(R.drawable.text_round_checked));
        tv_genderAll.setBackground(getDrawable(R.drawable.text_round_checked));
        tv_reviewAll.setBackground(getDrawable(R.drawable.text_round_checked));
    }



    //Text 이벤트 처리
    @Override
    public void onClick(View v) {// if: text외 이벤트(back, reset, btn_setFilter)
        if(v.getId() == R.id.back){

        } else if(v.getId() == R.id.btn_setFilter){

        } else{//text
            if(v.getBackground().getConstantState()
                    .equals(getResources().getDrawable(R.drawable.text_round_checked).getConstantState())){
                isDeselected((TextView)v);
            }else{
                isSelected((TextView)v);
            }
        }
    }


    private void isSelected(TextView textView){
        textView.setBackground(getResources().getDrawable(R.drawable.text_round_checked));
    }

    private void isDeselected(TextView textView){
        textView.setBackground(getResources().getDrawable(R.drawable.text_round));
    }


}
