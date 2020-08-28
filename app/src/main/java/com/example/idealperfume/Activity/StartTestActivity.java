package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.idealperfume.R;
import com.example.idealperfume.Util.CustomTypefaceSpan;

import org.w3c.dom.Text;

public class StartTestActivity extends AppCompatActivity {

    ImageView image;
    TextView text;
    int strEnd=0;
    String str=" 선택했어요.\n테스트를 시작할까요?";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_test);

        image = findViewById(R.id.image);
        text = findViewById(R.id.text);

        int i=2 ; // 화면 테스트 위해
        switch (i){
            case 1:
                text.setText("향수를"+str);
                image.setImageResource(R.drawable.test_perfume);
                strEnd = 2;
                break;
            case 2:
                text.setText("캔들을"+str);
                image.setImageResource(R.drawable.test_candle);
                strEnd = 2;
                break;
            case 3:
                text.setText("아로마 오일을"+str);
                image.setImageResource(R.drawable.test_aromaoil);
                strEnd = 6;
                break;
            case 4:
                text.setText("디퓨저를"+str);
                image.setImageResource(R.drawable.test_defuser);
                strEnd = 3;
                break;
            case 5:
                text.setText("바디로션을"+str);
                image.setImageResource(R.drawable.test_bodylotion);
                strEnd = 4;
                break;
        }

        setTypeface(strEnd);
    }

    private void setTypeface(int strEnd){
        Typeface boldFont = ResourcesCompat.getFont(getApplicationContext(),R.font.notosanskr_bold);
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder(text.getText());
        //Bold체 처리
        stringBuilder.setSpan(new CustomTypefaceSpan("",boldFont)
                ,0,strEnd, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        //밑줄 처리
        stringBuilder.setSpan(new UnderlineSpan(),0,strEnd,0);

        text.setText(stringBuilder);
    }
}