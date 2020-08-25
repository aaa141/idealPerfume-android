package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.idealperfume.R;

public class ResetPasswordActivity2 extends AppCompatActivity {

    Button btn_emailcheck;
    TextView tv_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password2);

        btn_emailcheck = findViewById(R.id.btn_emailcheck);
        tv_email = findViewById(R.id.tv_email);

        Intent getintent = getIntent();
        String email = getintent.getStringExtra("email");

        tv_email.setText(email);

        btn_emailcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResetPasswordActivity2.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}