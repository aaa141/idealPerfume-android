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
import android.widget.ImageView;

import com.example.idealperfume.R;

public class ResetPasswordActivity1 extends AppCompatActivity {
    EditText et_email;
    Button btn_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password1);

        et_email = findViewById(R.id.et_email);
        btn_email = findViewById(R.id.btn_email);
        final Drawable btn_border = getResources().getDrawable(R.drawable.btn_border);

        btn_email.setEnabled(false);
        btn_border.setColorFilter(0xffebebeb, PorterDuff.Mode.SRC_ATOP);
        btn_email.setBackground(btn_border);

        et_email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    et_email.setBackgroundResource(R.drawable.edit_greenborder);
                else
                    et_email.setBackgroundResource(R.drawable.edit_round);
            }
        });

        et_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (et_email.getText().length() > 0) {
                    btn_email.setEnabled(true);
                    btn_border.setColorFilter(0xffebebeb, PorterDuff.Mode.SRC_ATOP);
                    btn_email.setBackground(btn_border);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (et_email.getText().length() > 0) {
                    btn_email.setEnabled(true);
                    btn_border.setColorFilter(0x6da048, PorterDuff.Mode.SRC_ATOP);
                    btn_email.setBackground(btn_border);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (et_email.getText().length() == 0) {
                    btn_email.setEnabled(false);
                    btn_border.setColorFilter(0xffebebeb, PorterDuff.Mode.SRC_ATOP);
                    btn_email.setBackground(btn_border);
                }
            }
        });

        btn_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResetPasswordActivity1.this, ResetPasswordActivity2.class);
                intent.putExtra("email",et_email.getText().toString());
                startActivity(intent);

                overridePendingTransition(R.anim.right_in, R.anim.right_out);
            }
        });

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