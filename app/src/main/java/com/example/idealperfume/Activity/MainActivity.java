package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.idealperfume.Adapter.SignupGenderAdapter;
import com.example.idealperfume.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity{

    private static final int MAX_YEAR = 2020;
    private static final int MIN_YEAR = 1940;

    Button btn_gender, btn_year, btn_job;
    BottomSheetDialog BottomSheet;
    ArrayList<String> gender = new ArrayList<>(Arrays.asList("여성입니다.","남성입니다."));
    ArrayList<String> job = new ArrayList<>(Arrays.asList("연구원입니다.","학생입니다.","회사원입니다.","자영업입니다.","전문직입니다."));
    ArrayList<String> year = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_gender=(Button)findViewById(R.id.list_btn3);
        btn_year=(Button)findViewById(R.id.list_btn1);
        btn_job=(Button)findViewById(R.id.list_btn2);

        for (int i=1940; i<=2020; i++) {
            year.add(String.format("%d", i));
        }

        btn_gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createGenderDialog(gender, "성별을 선택해주세요.");
            }
        });

        btn_job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createGenderDialog(job,"직업을 선택해주세요.");
            }
        });

        btn_year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createYearDialog(year);
            }
        });
    }

    private void createGenderDialog(final ArrayList<String> list, String title){
        SignupGenderAdapter adapter=new SignupGenderAdapter(list);
        View view=getLayoutInflater().inflate(R.layout.dialog_signup_gender, null);
        //"xx"를 선택하세요.
        TextView titles = (TextView) view.findViewById(R.id.tv_signup_gender_title);
        titles.setText(title);

        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.list_signup_gender_job);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new SignupGenderAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                Toast.makeText(MainActivity.this, list.get(position),Toast.LENGTH_SHORT).show();
                BottomSheet.dismiss();
            }
        }) ;

        BottomSheet=new BottomSheetDialog(this);
        BottomSheet.setContentView(view);
        BottomSheet.show();

    }

    private void createYearDialog(ArrayList<String> list){
        View view=getLayoutInflater().inflate(R.layout.dialog_signup_year, null);
        Calendar calendar = Calendar.getInstance();
        final NumberPicker picker_year = (NumberPicker) view.findViewById(R.id.picker_year);
        TextView btn_signup_year = (TextView) view.findViewById(R.id.btn_signup_year);
        btn_signup_year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int year = picker_year.getValue();
               Toast.makeText(MainActivity.this,year+"",Toast.LENGTH_LONG).show();
               BottomSheet.dismiss();
            }
        });

        int year = calendar.get(Calendar.YEAR);
        picker_year.setMinValue(MIN_YEAR);
        picker_year.setMaxValue(MAX_YEAR);
        picker_year.setValue(1997);
        picker_year.setWrapSelectorWheel(false);

        BottomSheet=new BottomSheetDialog(this);
        BottomSheet.setContentView(view);
        BottomSheet.show();

    }

}

