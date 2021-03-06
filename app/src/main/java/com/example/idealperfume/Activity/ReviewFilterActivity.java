package com.example.idealperfume.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.idealperfume.R;

import org.w3c.dom.Text;

public class ReviewFilterActivity extends AppCompatActivity implements View.OnClickListener {

    static TextView tv_ageAll, tv_10, tv_early20, tv_late20, tv_early30, tv_late30, tv_over40,
            tv_genderAll, tv_female, tv_male, tv_reviewAll, tv_reviewPositive, tv_reviewNegative,
            tv_filterReset;

    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_filter);

        back = findViewById(R.id.back);
        tv_filterReset = findViewById(R.id.tv_filterReset);
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

        back.setOnClickListener(this);
        tv_filterReset.setOnClickListener(this);
        tv_ageAll.setOnClickListener(age_listener);
        tv_10.setOnClickListener(age_listener);
        tv_early20.setOnClickListener(age_listener);
        tv_late20.setOnClickListener(age_listener);
        tv_early30.setOnClickListener(age_listener);
        tv_late30.setOnClickListener(age_listener);
        tv_over40.setOnClickListener(age_listener);
        tv_genderAll.setOnClickListener(gender_listener);
        tv_female.setOnClickListener(gender_listener);
        tv_male.setOnClickListener(gender_listener);
        tv_reviewAll.setOnClickListener(review_listener);
        tv_reviewPositive.setOnClickListener(review_listener);
        tv_reviewNegative.setOnClickListener(review_listener);

        setSelected(tv_ageAll);
    }

    View.OnClickListener age_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.tv_ageAll){ // ?????? ????????? ????????? ?????? deselect
                setSelected(tv_ageAll);
                setDeselected(tv_10);
                setDeselected(tv_early20);
                setDeselected(tv_late20);
                setDeselected(tv_early30);
                setDeselected(tv_late30);
                setDeselected(tv_over40);
            }
            else{
                if(getState(v)==0){
                    setDeselected((TextView)v);

                    if(getState(tv_10)*getState(tv_early20)*
                            getState(tv_late20)*getState(tv_early30)*
                            getState(tv_late30)*getState(tv_over40) == 1){
                        // ?????? ?????? ???????????????, ?????? ??????
                        setSelected(tv_ageAll);
                    }
                }else{
                    setSelected((TextView)v);
                    setDeselected(tv_ageAll);
                }
            }
        }
    };

    View.OnClickListener gender_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setDeselected(tv_genderAll);
            setDeselected(tv_female);
            setDeselected(tv_male);
            setSelected((TextView)v);
        }
    };

    View.OnClickListener review_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setDeselected(tv_reviewAll);
            setDeselected(tv_reviewPositive);
            setDeselected(tv_reviewNegative);
            setSelected((TextView)v);
        }
    };

    //TextView(chip??????) ??? ????????????
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.back){ //?????? ??????
            finish();
            //startActivity(new Intent(ReviewFilterActivity.this, ReviewActivity.class));
        }
        else if(v.getId() == R.id.tv_filterReset){ // ?????????
            setDeselected(tv_10);
            setDeselected(tv_early20);
            setDeselected(tv_late20);
            setDeselected(tv_early30);
            setDeselected(tv_late30);
            setDeselected(tv_over40);
            setDeselected(tv_female);
            setDeselected(tv_male);
            setDeselected(tv_reviewPositive);
            setDeselected(tv_reviewNegative);
            setSelected(tv_ageAll);
            setSelected(tv_genderAll);
            setSelected(tv_ageAll);
        }
        else if(v.getId() == R.id.btn_setFilter){ // ?????? ?????? ??????

        }
    }


    private void setSelected(TextView textView){
        textView.setBackground(getResources().getDrawable(R.drawable.text_round_checked,null));
        textView.setTextColor(Color.WHITE);
    }

    private void setDeselected(TextView textView){
        textView.setBackground(getResources().getDrawable(R.drawable.text_round,null));
        textView.setTextColor(getResources().getColor(R.color.green));
    }

    private int getState(View view){
        if(view.getBackground().getConstantState().equals(
                getResources().getDrawable(R.drawable.text_round_checked,null).getConstantState()
        )){
            return 0; //????????? ??????
        }
        else
            return 1; // ?????? ??? ??? ??????
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        
    }
}
