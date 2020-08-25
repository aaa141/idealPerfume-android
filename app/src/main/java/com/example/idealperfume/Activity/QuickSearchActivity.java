package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.idealperfume.R;
import com.jaygoo.widget.OnRangeChangedListener;
import com.jaygoo.widget.RangeSeekBar;

import java.text.DecimalFormat;

public class QuickSearchActivity extends AppCompatActivity implements View.OnClickListener{

    SeekBar seekBar_age;
    com.jaygoo.widget.RangeSeekBar rangeSeekBar;
    DecimalFormat format;

    Button btn_search;
    ImageView back;
    TextView tv_quickReset, tv_age;
    CheckBox cb_perfume, cb_defuser, cb_candle, cb_aromaOil, cb_bodyLotion, cb_line_citrus, cb_line_floral
            , cb_line_fruity, cb_line_green,cb_line_woody, cb_line_musk, cb_line_oriental,cb_line_aqua
            , cb_line_soap, cb_image_clean, cb_image_fresh, cb_imgae_cool, cb_image_natural
            , cb_imgae_sweet, cb_image_lovely, cb_imgae_soft, cb_image_forrest, cb_imgae_exotic
            , cb_image_fascinate, cb_imgae_heavy, cb_image_charisma;

    int padding, sPos, xPos;
    int lineCount=0, imageCount=0;
    int seekbarWidth = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_search);

        cb_perfume = findViewById(R.id.cb_perfume);
        cb_defuser = findViewById(R.id.cb_defuser);
        cb_candle = findViewById(R.id.cb_candle);
        cb_aromaOil = findViewById(R.id.cb_aromaOil);
        cb_bodyLotion = findViewById(R.id.cb_bodyLotion);
        cb_line_citrus = findViewById(R.id.cb_line_citrus);
        cb_line_floral = findViewById(R.id.cb_line_floral);
        cb_line_fruity = findViewById(R.id.cb_line_fruity);
        cb_line_green = findViewById(R.id.cb_line_green);
        cb_line_woody = findViewById(R.id.cb_line_woody);
        cb_line_musk = findViewById(R.id.cb_line_musk);
        cb_line_oriental = findViewById(R.id.cb_line_oriental);
        cb_line_aqua = findViewById(R.id.cb_line_aqua);
        cb_line_soap = findViewById(R.id.cb_line_soap);
        cb_image_clean = findViewById(R.id.cb_image_clean);
        cb_image_fresh = findViewById(R.id.cb_image_fresh);
        cb_imgae_cool = findViewById(R.id.cb_imgae_cool);
        cb_image_natural = findViewById(R.id.cb_image_natural);
        cb_imgae_sweet = findViewById(R.id.cb_imgae_sweet);
        cb_image_lovely = findViewById(R.id.cb_image_lovely);
        cb_imgae_soft = findViewById(R.id.cb_imgae_soft);
        cb_image_forrest = findViewById(R.id.cb_image_forrest);
        cb_imgae_exotic = findViewById(R.id.cb_imgae_exotic);
        cb_image_fascinate = findViewById(R.id.cb_image_fascinate);
        cb_imgae_heavy = findViewById(R.id.cb_imgae_heavy);
        cb_image_charisma = findViewById(R.id.cb_image_charisma);
        back = findViewById(R.id.back);
        tv_quickReset = findViewById(R.id.tv_quickReset);
        btn_search = findViewById(R.id.btn_search);
        tv_age = findViewById(R.id.tv_age);
        seekBar_age = findViewById(R.id.seekBar_age);
        rangeSeekBar = findViewById(R.id.rangeSeekbar);

        tv_quickReset.setOnClickListener(this);
        btn_search.setOnClickListener(this);
        back.setOnClickListener(this);
        cb_line_citrus.setOnCheckedChangeListener(cbLine_listener);
        cb_line_floral.setOnCheckedChangeListener(cbLine_listener);
        cb_line_fruity.setOnCheckedChangeListener(cbLine_listener);
        cb_line_green.setOnCheckedChangeListener(cbLine_listener);
        cb_line_woody.setOnCheckedChangeListener(cbLine_listener);
        cb_line_musk.setOnCheckedChangeListener(cbLine_listener);
        cb_line_oriental.setOnCheckedChangeListener(cbLine_listener);
        cb_line_aqua.setOnCheckedChangeListener(cbLine_listener);
        cb_line_soap.setOnCheckedChangeListener(cbLine_listener);

        cb_image_clean.setOnCheckedChangeListener(cbImage_listener);
        cb_image_fresh.setOnCheckedChangeListener(cbImage_listener);
        cb_imgae_cool.setOnCheckedChangeListener(cbImage_listener);
        cb_image_natural.setOnCheckedChangeListener(cbImage_listener);
        cb_imgae_sweet.setOnCheckedChangeListener(cbImage_listener);
        cb_image_lovely.setOnCheckedChangeListener(cbImage_listener);
        cb_imgae_soft.setOnCheckedChangeListener(cbImage_listener);
        cb_image_forrest.setOnCheckedChangeListener(cbImage_listener);
        cb_imgae_exotic.setOnCheckedChangeListener(cbImage_listener);
        cb_image_fascinate.setOnCheckedChangeListener(cbImage_listener);
        cb_imgae_heavy.setOnCheckedChangeListener(cbImage_listener);
        cb_image_charisma.setOnCheckedChangeListener(cbImage_listener);

        seekbarSetting(); // seekbar, rangeseekbar 설정
    }

    CheckBox.OnCheckedChangeListener cbLine_listener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(buttonView.isChecked()){
                if(lineCount == 3){
                    Toast.makeText(QuickSearchActivity.this,
                            "최대 3개까지 선택이 가능합니다.",Toast.LENGTH_LONG).show();
                    buttonView.setChecked(false);
                }
                else {
                    lineCount += 1;
                }
            }
            else{
                lineCount -= 1;
            }
        }
    };

    CheckBox.OnCheckedChangeListener cbImage_listener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(buttonView.isChecked()){
                if(imageCount == 1){
                    Toast.makeText(QuickSearchActivity.this,
                            "최대 1개까지 선택이 가능합니다.",Toast.LENGTH_LONG).show();
                    buttonView.setChecked(false);
                }
                else {
                    imageCount += 1;
                }
            }
            else{
                imageCount -= 1;
            }
        }
    };


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.btn_search:
                // 서버 전송?
                Intent intent = new Intent(
                        QuickSearchActivity.this, PI_QuickActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.not_move);
                break;
            case R.id.tv_quickReset:
                reset();
                break;
        }
    }

    private void seekbarSetting(){
        format = new DecimalFormat("#,###원");
        rangeSeekBar.setIndicatorTextDecimalFormat("#,###원");
        rangeSeekBar.getLeftSeekBar().setTypeface(ResourcesCompat.getFont(getApplicationContext(),R.font.notosanskr_bold));
        rangeSeekBar.getRightSeekBar().setTypeface(ResourcesCompat.getFont(getApplicationContext(),R.font.notosanskr_bold));
        rangeSeekBar.setProgress(0, rangeSeekBar.getMaxProgress());

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
    @Override
    public void onWindowFocusChanged(boolean hasFocus) { //연령대 seekbar 초기 텍스트 위치 설정을 위해
        super.onWindowFocusChanged(hasFocus);
        seekbarWidth = seekBar_age.getWidth();
        tv_age.setX(getSeekbarxPos(seekBar_age,0));
    }

    private int getSeekbarxPos(SeekBar seekBar, int progress){
        padding = seekBar.getPaddingLeft() + seekBar.getPaddingRight();
        sPos = seekBar.getLeft() + seekBar.getPaddingLeft();
        xPos = (seekbarWidth - padding) * seekBar.getProgress() / seekBar.getMax() + sPos - (tv_age.getWidth() / 2);

        return xPos;
    }

    private void reset(){
        seekBar_age.setProgress(1);
        rangeSeekBar.setProgress(0, rangeSeekBar.getMaxProgress());
        cb_perfume.setChecked(false);
        cb_defuser.setChecked(false);
        cb_candle.setChecked(false);
        cb_aromaOil.setChecked(false);
        cb_bodyLotion.setChecked(false);
        cb_line_citrus.setChecked(false);
        cb_line_floral.setChecked(false);
        cb_line_fruity.setChecked(false);
        cb_line_green.setChecked(false);
        cb_line_woody.setChecked(false);
        cb_line_musk.setChecked(false);
        cb_line_oriental.setChecked(false);
        cb_line_aqua.setChecked(false);
        cb_line_soap.setChecked(false);
        cb_image_clean.setChecked(false);
        cb_image_fresh.setChecked(false);
        cb_imgae_cool.setChecked(false);
        cb_image_natural.setChecked(false);
        cb_imgae_sweet.setChecked(false);
        cb_image_lovely.setChecked(false);
        cb_imgae_soft.setChecked(false);
        cb_image_forrest.setChecked(false);
        cb_imgae_exotic.setChecked(false);
        cb_image_fascinate.setChecked(false);
        cb_imgae_heavy.setChecked(false);
        cb_image_charisma.setChecked(false);
    }
}


