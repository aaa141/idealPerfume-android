package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.idealperfume.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText et_id = findViewById(R.id.et_id);
        final EditText et_password = findViewById(R.id.et_password);
        final Button btn_login = findViewById(R.id.btn_login);
        final Drawable btn_border = getResources().getDrawable(R.drawable.btn_border);
        final TextView tv_next = findViewById(R.id.tv_next);

        et_id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                btn_login.setEnabled(false);
                btn_border.setColorFilter(0xffebebe, PorterDuff.Mode.SRC_ATOP);
                btn_login.setBackground(btn_border);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (et_id.getText().length() > 0 && et_password.getText().length() > 0) {
                    btn_login.setEnabled(true);
                    btn_border.setColorFilter(0xff8e8e8e, PorterDuff.Mode.SRC_ATOP);
                    btn_login.setBackground(btn_border);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (et_id.getText().length() == 0 || et_password.getText().length() == 0) {
                    btn_login.setEnabled(false);
                    btn_border.setColorFilter(0xffebebe, PorterDuff.Mode.SRC_ATOP);
                    btn_login.setBackground(btn_border);
                }
            }
        });

        et_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                btn_login.setEnabled(false);
                btn_border.setColorFilter(0xffebebe, PorterDuff.Mode.SRC_ATOP);
                btn_login.setBackground(btn_border);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (et_id.getText().length() > 0 && et_password.getText().length() > 0) {
                    btn_login.setEnabled(true);
                    btn_border.setColorFilter(0xff8e8e8e, PorterDuff.Mode.SRC_ATOP);
                    btn_login.setBackground(btn_border);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (et_id.getText().length() == 0 || et_password.getText().length() == 0) {
                    btn_login.setEnabled(false);
                    btn_border.setColorFilter(0xffebebe, PorterDuff.Mode.SRC_ATOP);
                    btn_login.setBackground(btn_border);
                }
            }
        });

        btn_login.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "로그인", Toast.LENGTH_SHORT).show();
            }
        }) ;

        tv_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Register1Activity.class);
                startActivity(intent);
            }
        });

    }
}