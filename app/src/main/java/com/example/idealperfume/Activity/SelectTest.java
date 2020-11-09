package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.idealperfume.R;

public class SelectTest extends AppCompatActivity implements View.OnClickListener{

    Button btn_perfume, btn_defuser, btn_candle, btn_aromaoil, btn_bodylotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_test);

        btn_perfume = findViewById(R.id.btn_perfume);
        btn_defuser = findViewById(R.id.btn_defuser);
        btn_candle = findViewById(R.id.btn_candle);
        btn_aromaoil = findViewById(R.id.btn_aromaoil);
        btn_bodylotion = findViewById(R.id.btn_bodylotion);

        btn_perfume.setOnClickListener(this);
        btn_defuser.setOnClickListener(this);
        btn_candle.setOnClickListener(this);
        btn_aromaoil.setOnClickListener(this);
        btn_bodylotion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.btn_perfume:
                startTest(1);
                break;
            case R.id.btn_defuser:
                startTest(2);
                break;
            case R.id.btn_candle:
                startTest(3);
                break;
            case R.id.btn_aromaoil:
                startTest(4);
                break;
            case R.id.btn_bodylotion:
                startTest(5);
                break;
        }
    }

    private void startTest(int tag){
        Intent intent = new Intent(SelectTest.this, StartTestActivity.class);
        intent.putExtra("tag", tag);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}