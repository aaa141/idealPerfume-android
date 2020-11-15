package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.idealperfume.R;
import com.example.idealperfume.Util.retrofit.RetrofitHelper;
import com.example.idealperfume.Util.retrofit.RetrofitService;
import com.example.idealperfume.model.RegisterModel;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register3Activity extends AppCompatActivity {

    Button btn_final_signup;
    CheckBox cb_signup;
    String email, password, job, gender, nickname;
    String authenticationNo;
    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3);

        cb_signup = (CheckBox) findViewById(R.id.cb_signup);
        btn_final_signup = (Button) findViewById(R.id.btn_final_signup);

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy");
        Date time = new Date();
        String today_year = format1.format(time);

        Intent intent = getIntent();
        email = intent.getExtras().getString("email");
        password = intent.getExtras().getString("password");
        authenticationNo = intent.getExtras().getString("authenticationNo");
//
//        final String phoneNo = String.format("%010d",authenticationNo);

        age = Integer.parseInt(today_year) - intent.getExtras().getInt("year") + 1;

        job = intent.getExtras().getString("job");
        job = job.replaceAll("입니다.", "");

        if(gender == "여성입니다.") gender = "w";
        else gender = "m";

        nickname = intent.getExtras().getString("nickname");


        //체크박스 선택시 버튼 색상 변경
        cb_signup.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    btn_final_signup.setBackgroundResource(R.drawable.btn_onclick);
                    btn_final_signup.setTextColor(getResources().getColor(R.color.white));
                } else {
                    btn_final_signup.setBackgroundResource(R.drawable.btn_bfrclick);
                    btn_final_signup.setTextColor(getResources().getColor(R.color.gray));
                }

                System.out.println(Integer.parseInt(email) + '\n' + password + '\n' +"local" + '\n' +nickname + '\n' +
                        "name" + '\n' +"picture" + '\n' + gender + '\n' +job + '\n' +age + '\n' + 0 + '\n' +1 + '\n' +authenticationNo + '\n' +1);

            }
        });

        btn_final_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitService retrofitService = RetrofitHelper.getRetrofit().create(RetrofitService.class);

                Call<RegisterModel> call = retrofitService.getRegisterCheck(Integer.parseInt(email), password, "local", nickname,
                        "tname", null, gender, job, age, 0, 1, Integer.parseInt(authenticationNo),1);

                call.enqueue(new Callback<RegisterModel>() {
                    @Override
                    public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {
                        RegisterModel registerModel = response.body();

                    }

                    @Override
                    public void onFailure(Call<RegisterModel> call, Throwable t) {
                        Log.d("ssss","fail");
                    }
                });
            }
        }) ;

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {

        super.finish();
        overridePendingTransition(R.anim.not_move, R.anim.right_out);
    }
}
