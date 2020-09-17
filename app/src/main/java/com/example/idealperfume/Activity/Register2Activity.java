package com.example.idealperfume.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.idealperfume.Adapter.BSBasicAdapter;
import com.example.idealperfume.Adapter.YearAdapter;
import com.example.idealperfume.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class Register2Activity extends AppCompatActivity {

    private static final int MAX_YEAR = 2020;
    private static final int MIN_YEAR = 1940;
    private static final String TAG = MainActivity.class.getSimpleName();
    private String str_year;

    boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false;
    //year, nickname, gender, job flag
    Button btn_next, btn_doublecheck;
    TextView tv_gender, tv_year, tv_job;
    BottomSheetDialog BottomSheet;
    ArrayList<String> gender = new ArrayList<>(Arrays.asList("여성입니다.", "남성입니다."));
    ArrayList<String> job = new ArrayList<>(Arrays.asList("연구원입니다.", "학생입니다.", "회사원입니다.", "자영업입니다.", "전문직입니다."));
    ArrayList<String> year = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        btn_next = (Button) findViewById(R.id.button3);
        btn_doublecheck = (Button) findViewById(R.id.btn_doublecheck);

        tv_gender = (TextView) findViewById(R.id.tv_gender);
        tv_year = (TextView) findViewById(R.id.tv_year);
        tv_job = (TextView) findViewById(R.id.tv_job);
        final EditText et_nickname = (EditText) findViewById(R.id.et_nickname);

        //날짜 데이터 넣음
        for (int i = 0; i < 2; i++) {
            year.add("");
        }
        for (int i = 1940; i <= 2020; i++) {
            year.add(String.format("%d", i));
        }
        for (int i = 0; i < 2; i++) {
            year.add("");
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
                createBasicDialog(job, "직업을 선택해주세요.");
            }
        });

        tv_year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createYearDialog(year);
            }
        });


        //인텐트
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag1 && flag2 && flag3 && flag4) {
                    Intent getIntent = getIntent();

                    Intent intent = new Intent(getApplicationContext(), Register3Activity.class);
                    intent.putExtra("email", getIntent.getExtras().getString("email"));
                    intent.putExtra("password", getIntent.getExtras().getString("password"));
                    intent.putExtra("authenticationNo", getIntent.getExtras().getString("authenticationNo"));
                    intent.putExtra("year", Integer.parseInt(tv_year.getText().toString()));
                    intent.putExtra("job", tv_job.getText().toString());
                    intent.putExtra("gender", tv_gender.getText().toString());
                    intent.putExtra("nickname", et_nickname.getText().toString());
                    startActivity(intent);
                }
            }
        });

        //닉네임 중복확인
        btn_doublecheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //중복인 경우 바꿔줘야됨
                if (et_nickname.getText().length() > 0) {
                    flag2 = true;
                    if (flag1 && flag2 && flag3 && flag4) {
                        buttonAfter(btn_next);
                    }
                }
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
                    flag2 = false;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (et_nickname.getText().length() == 0) {
                    flag2 = false;
                    buttonBefore(btn_next);
                    buttonBefore(btn_doublecheck);
                }
            }
        });
    }

    //버튼 클릭 전
    private void buttonBefore(Button button) {
        button.setEnabled(false);
        button.setTextColor(getResources().getColor(R.color.black));
        button.setBackgroundResource(R.drawable.btn_bfrclick);
    }

    //버튼 클릭 후
    private void buttonAfter(Button button) {
        button.setEnabled(true);
        button.setTextColor(getResources().getColor(R.color.white));
        button.setBackgroundResource(R.drawable.btn_onclick);
    }


    private void createBasicDialog(final ArrayList<String> list, String title) {
        BSBasicAdapter adapter = new BSBasicAdapter(list);
        View view = getLayoutInflater().inflate(R.layout.dialog_bs_basic, null);

        //"xx"를 선택하세요.
        TextView titles = (TextView) view.findViewById(R.id.tv_bs_basic_title);
        titles.setText(title);

        final TextView result;
        if (title.equals("성별을 선택해주세요.")) {
            flag3 = true;
            result = tv_gender;
        } else {
            flag4 = true;
            result = tv_job;
        }

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcv_bs_basic);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new BSBasicAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                result.setText(list.get(position));
                BottomSheet.dismiss();
                if (flag1 && flag2 && flag3 && flag4) {
                    buttonAfter(btn_next);
                }
            }
        });

        BottomSheet = new BottomSheetDialog(this);
        BottomSheet.setContentView(view);
        BottomSheet.show();

    }

    private void createYearDialog(ArrayList<String> list) {
        View view = getLayoutInflater().inflate(R.layout.dialog_signup_year, null);
        TextView btn_signup_year = (TextView) view.findViewById(R.id.btn_signup_year);
        RecyclerView rcv_year = (RecyclerView) view.findViewById(R.id.rcv_year);

        final YearAdapter yearAdapter = new YearAdapter(year);
        rcv_year.setAdapter(yearAdapter);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rcv_year.setLayoutManager(layoutManager);

        RecyclerView.SmoothScroller smoothScroller = new
                LinearSmoothScroller(getApplicationContext()) {
                    @Override protected int getVerticalSnapPreference() {
                        return LinearSmoothScroller.SNAP_TO_START;
                    }
                };

        smoothScroller.setTargetPosition(rcv_year.getAdapter().getItemCount()-25);
        layoutManager.startSmoothScroll(smoothScroller);

        final SnapHelper snapHelper = new LinearSnapHelper();
        if (rcv_year.getOnFlingListener() == null)
            snapHelper.attachToRecyclerView(rcv_year);

        rcv_year.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager =
                        LinearLayoutManager.class.cast(recyclerView.getLayoutManager());
                int firstPos = layoutManager.findFirstVisibleItemPosition();
                int lastPos = layoutManager.findLastVisibleItemPosition();
                int middle = Math.abs(lastPos - firstPos) / 2 + firstPos;

                str_year = yearAdapter.getItem(middle);
                yearAdapter.notifyDataSetChanged();
            }
        });

        btn_signup_year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag1 = true;
                tv_year.setText(str_year);
                BottomSheet.dismiss();
                if (flag1 && flag2 && flag3 && flag4) {
                    buttonAfter(btn_next);
                }
            }
        });

        BottomSheet = new BottomSheetDialog(this);
        BottomSheet.setContentView(view);
        BottomSheet.show();

    }

}
