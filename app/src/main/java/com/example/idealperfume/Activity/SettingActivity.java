package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.idealperfume.Fragment.SettingFragment;
import com.example.idealperfume.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        // 하단바 만들면 환경설정 버튼에 연결하고, 하단바 메뉴 모든 화면에서 열 수 있게 추가해야 함
        Button test = findViewById(R.id.btn_modal);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                            SettingActivity.this, R.style.BottomSheetDialghTheme);
                    View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(
                            R.layout.activity_setting_fragment, (LinearLayout)findViewById(R.id.layout_settingbottomsheet)

                );
                    bottomSheetDialog.setContentView(bottomSheetView);
                    bottomSheetDialog.show();
                }
        });

    }
}