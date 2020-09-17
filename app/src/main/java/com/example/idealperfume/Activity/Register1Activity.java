package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.idealperfume.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Pattern;

public class Register1Activity extends AppCompatActivity {

    TextInputEditText et_email, et_pw;
    EditText et_authenticationNo;
    boolean emailFlag=false, pwFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);

        et_email = (TextInputEditText) findViewById(R.id.et_email);
        et_pw = (TextInputEditText) findViewById(R.id.et_pw);
        et_authenticationNo = findViewById(R.id.et_authenticationNo);

        et_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(Patterns.EMAIL_ADDRESS.matcher(s).matches()){
                    // db에 존재하는 이메일인지 조건 추가 필요
                        // 체크 icon 이미지 변경
                        emailFlag = true;
                }else{

                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });


        et_pw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[$@!%*#?&])[a-z0-9$@!%*#?&]{8,}$",s)){
                    et_pw.setError(null);
                    pwFlag = true;
                }else{
                    et_pw.setError("영문, 숫자, 특수문자 포함 8자 이상 입력해주세요");
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        //인텐트
        Button btn_next = (Button) findViewById(R.id.button3);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //데이터 임시 저장(...?)
                Intent intent = new Intent(getApplicationContext(),Register2Activity.class);
                intent.putExtra("email", et_email.getText().toString());
                intent.putExtra("password", et_pw.getText().toString());
                intent.putExtra("authenticationNo", et_authenticationNo.getText().toString());
                startActivity(intent);
            }
        });

    }
}
