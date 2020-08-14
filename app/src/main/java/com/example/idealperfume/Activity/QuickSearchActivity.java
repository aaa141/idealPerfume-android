package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.idealperfume.R;
import com.jaygoo.widget.OnRangeChangedListener;
import com.jaygoo.widget.RangeSeekBar;

import java.text.DecimalFormat;

public class QuickSearchActivity extends AppCompatActivity {
    TextView tv_age;
    SeekBar seekBar_age;
    com.jaygoo.widget.RangeSeekBar rangeSeekBar;
    DecimalFormat format;
    int padding, sPos, xPos;
    int lineCount=0; // 선택된 게열 수 카운팅
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_search);

        tv_age = findViewById(R.id.tv_age);
        seekBar_age = findViewById(R.id.seekBar_age);
        rangeSeekBar = findViewById(R.id.rangeSeekbar);

        //다음 버튼으로 가기
        Button btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PI_SearchActivity.class));
            }
        });

        format = new DecimalFormat("#,###원");
        rangeSeekBar.setIndicatorTextDecimalFormat("#,###원");
        rangeSeekBar.setTypeface(Typeface.create(Typeface.MONOSPACE , Typeface.BOLD));
        rangeSeekBar.setProgress(0, rangeSeekBar.getMaxProgress());

        tv_age.setX(155); // ****************************************

        seekBar_age.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress==0) {
                    seekBar.setProgress(1);
                }else {
                    getSeekbarxPos(seekBar, progress);
                    tv_age.setX(xPos);
                    tv_age.setText(progress + "0대");
                    Log.d("progress", seekBar.getLeft() + "");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });


        rangeSeekBar.setOnRangeChangedListener(new OnRangeChangedListener() {
            @Override
            public void onRangeChanged(RangeSeekBar view, float leftValue, float rightValue, boolean isFromUser) {

                view.getLeftSeekBar().setIndicatorText(format.format((((int)leftValue)/5000)*5000));
                view.getRightSeekBar().setIndicatorText(format.format((((int)rightValue)/5000)*5000));
            }

            @Override
            public void onStartTrackingTouch(RangeSeekBar view, boolean isLeft) { }

            @Override
            public void onStopTrackingTouch(RangeSeekBar view, boolean isLeft) { }
        });

    }

    private int getSeekbarxPos(SeekBar seekBar, int progress){
        padding = seekBar.getPaddingLeft() + seekBar.getPaddingRight();
        sPos = seekBar.getLeft() + seekBar.getPaddingLeft();
        xPos = (seekBar.getWidth() - padding) * seekBar.getProgress() / seekBar.getMax() + sPos - (tv_age.getWidth() / 2);

        return xPos;
    }


}


