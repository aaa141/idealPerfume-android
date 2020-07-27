package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.idealperfume.Adapter.BSBasicAdapter;
import com.example.idealperfume.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class Register2Activity extends AppCompatActivity {

    private static final int MAX_YEAR = 2020;
    private static final int MIN_YEAR = 1940;

    boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false;
    //year, nickname, gender, job flag
    Button btn_next, btn_doublecheck;
    TextView tv_gender, tv_year, tv_job;
    Drawable btn_border;
    BottomSheetDialog BottomSheet;
    ArrayList<String> gender = new ArrayList<>(Arrays.asList("여성입니다.","남성입니다."));
    ArrayList<String> job = new ArrayList<>(Arrays.asList("연구원입니다.","학생입니다.","회사원입니다.","자영업입니다.","전문직입니다."));
    ArrayList<String> year = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        btn_next = (Button) findViewById(R.id.button3);
        btn_border = getResources().getDrawable(R.drawable.btn_border);
        btn_doublecheck = (Button) findViewById(R.id.btn_doublecheck);

        tv_gender=(TextView)findViewById(R.id.tv_gender);
        tv_year=(TextView)findViewById(R.id.tv_year);
        tv_job=(TextView)findViewById(R.id.tv_job);
        final EditText et_nickname = (EditText) findViewById(R.id.et_nickname);

        //날짜 데이터 넣어줌
        for (int i=1940; i<=2020; i++) {
            year.add(String.format("%d", i));
        }

        tv_gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createBasicDialog(gender, "성별을 선택해주세요.");
            }
        });

        tv_job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createBasicDialog(job,"직업을 선택해주세요.");
            }
        });


        tv_year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createYearDialog(year);
            }
        });

        //인텐드
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Register3Activity.class);
                startActivity(intent);
            }
        });

        btn_doublecheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //중복인 경우 바꿔줘야됨
                flag2 = true;
            }
        });


        et_nickname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                buttonBefore(btn_next);
                buttonBefore(btn_doublecheck);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (et_nickname.getText().length() > 0) {
                    buttonAfter(btn_doublecheck);
                    if(flag1 && flag2 && flag3 && flag4){
                        buttonAfter(btn_next);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (et_nickname.getText().length() == 0) {
                    buttonBefore(btn_next);
                    buttonBefore(btn_doublecheck);
                }
            }
        });
    }

    //버튼 클릭 전
    private void buttonBefore(Button button){
        button.setEnabled(false);
        button.setTextColor(getResources().getColor(R.color.gray));
        button.setBackgroundResource(R.drawable.btn_border);
    }

    //버튼 클릭 후
    private void buttonAfter(Button button){
        button.setEnabled(true);
        button.setTextColor(getResources().getColor(R.color.black));
        button.setBackgroundResource(R.drawable.btn_onclick);
    }


    private void createBasicDialog(final ArrayList<String> list, String title){
        BSBasicAdapter adapter=new BSBasicAdapter(list);
        View view=getLayoutInflater().inflate(R.layout.dialog_bs_basic, null);

        //"xx"를 선택하세요.
        TextView titles = (TextView) view.findViewById(R.id.tv_bs_basic_title);
        titles.setText(title);

        final TextView result;
        if(title.equals("성별을 선택해주세요.")) {
            flag3 = true;
            result = tv_gender;
        }
        else {
            flag4 = true;
            result = tv_job;
        }

        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.rcv_bs_basic);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new BSBasicAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                result.setText(list.get(position));
                BottomSheet.dismiss();
                if(flag1 && flag2 && flag3 && flag4){
                    buttonAfter(btn_next);
                }
            }
        }) ;

        BottomSheet=new BottomSheetDialog(this);
        BottomSheet.setContentView(view);
        BottomSheet.show();

    }

    private void createYearDialog(ArrayList<String> list){
        View view=getLayoutInflater().inflate(R.layout.dialog_signup_year, null);
        final NumberPicker picker_year = (NumberPicker) view.findViewById(R.id.picker_year);
        TextView btn_signup_year = (TextView) view.findViewById(R.id.btn_signup_year);


        btn_signup_year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag1 = true;
                int year = picker_year.getValue();
                tv_year.setText(year+"");
                BottomSheet.dismiss();
                if(flag1 && flag2 && flag3 && flag4){
                    buttonAfter(btn_next);
                }
            }
        });

        picker_year.setMinValue(MIN_YEAR);
        picker_year.setMaxValue(MAX_YEAR);
        picker_year.setValue(1997);
        picker_year.setWrapSelectorWheel(false);

        BottomSheet=new BottomSheetDialog(this);
        BottomSheet.setContentView(view);
        BottomSheet.show();

    }

}
