package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.idealperfume.R;

public class ReviewRegActivity extends AppCompatActivity implements View.OnClickListener {
// 별점 해결해야 함

    ImageView back;
    Button btn_register;
    TextView tv_changeProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_reg);

        back = findViewById(R.id.back);
        tv_changeProduct = findViewById(R.id.tv_changeProduct);
        btn_register = findViewById(R.id.btn_register);

        back.setOnClickListener(this);
        tv_changeProduct.setOnClickListener(this);
        btn_register.setOnClickListener(this);

        //제품변경에 밑줄 긋기
        SpannableString content = new SpannableString("제품변경");
        content.setSpan(new UnderlineSpan(),0,content.length(),0);
        tv_changeProduct.setText(content);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back: // 뒤로가기
                // **작성한 내용 사라짐 알림
                startActivity(new Intent(ReviewRegActivity.this, ProductInfoActivity.class));
                //finish();
                //overridePendingTransition(R.anim.not_move,R.anim.right_out);
                break;

            case R.id.tv_changeProduct: // 제품 변경하기
                //어디로..?

            case R.id.btn_register: // 작성하기
                Toast.makeText(this, "등록되었습니다.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ReviewRegActivity.this, ProductInfoActivity.class));
                break;
        }
    }
}