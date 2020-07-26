package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.idealperfume.R;

public class Register3Activity extends AppCompatActivity {

    Button btn_final_signup;
    CheckBox cb_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3);

        cb_signup = (CheckBox) findViewById(R.id.cb_signup);
        btn_final_signup = (Button) findViewById(R.id.btn_final_signup);

        //체크박스 선택시 버튼 색상 변경
        cb_signup.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox)v).isChecked()) {
                    btn_final_signup.setBackgroundResource(R.drawable.button_round);
                    btn_final_signup.setTextColor(getResources().getColor(R.color.white));
                } else {
                    btn_final_signup.setBackgroundResource(R.drawable.btn_round);
                    btn_final_signup.setTextColor(getResources().getColor(R.color.black));
                }
            }
        }) ;
    }
}
