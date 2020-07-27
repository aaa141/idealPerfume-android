package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.idealperfume.Adapter.BSBasicAdapter;
import com.example.idealperfume.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class QuestionActivity extends AppCompatActivity {

    ArrayList<String> question = new ArrayList<>(Arrays.asList("선택안함", "이벤트 문의", "서비스 불편 오류제보", "사용방법 문의", "아이디어 제안", "제휴문의"));
    BottomSheetDialog BottomSheet;
    boolean flag1 = false, flag2 = false;
    Button btn_next;
    Drawable btn_border;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        final TextView tv_show_list = (TextView) findViewById(R.id.tv_show_list);
        final EditText ed_question = (EditText) findViewById(R.id.ed_question);
        final EditText ed_email = (EditText) findViewById(R.id.ed_email);
        btn_next = (Button) findViewById(R.id.btn_nxt);
        btn_border = getResources().getDrawable(R.drawable.btn_border);

        tv_show_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createBasicDialog(question, "문의유형을 선택하세요");
            }
        });


        //텍스트 와쳐 - 버튼 색 변경 이벤트
        ed_question.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                buttonBefore(btn_next);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (ed_question.getText().length() > 0 && ed_email.getText().length() > 0) {
                    flag2 = true;
                    if(flag1 && flag2){
                        buttonAfter(btn_next);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (ed_question.getText().length() == 0 || ed_email.getText().length() == 0) {
                    buttonBefore(btn_next);
                }
            }
        });

        ed_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                buttonBefore(btn_next);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (ed_question.getText().length() > 0 && ed_email.getText().length() > 0) {
                    flag2 = true;
                    if(flag1 && flag2){
                        buttonAfter(btn_next);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (ed_question.getText().length() == 0 || ed_email.getText().length() == 0) {
                    buttonBefore(btn_next);
                }
            }
        });

    }


    //메서드

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


    private void createBasicDialog(final ArrayList<String> list, String title) {
        BSBasicAdapter adapter = new BSBasicAdapter(list);
        View view = getLayoutInflater().inflate(R.layout.dialog_bs_basic, null);

        //"xx"를 선택하세요.
        TextView titles = (TextView) view.findViewById(R.id.tv_bs_basic_title);
        titles.setText(title);

        final TextView result = (TextView) findViewById(R.id.tv_show_list);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcv_bs_basic);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new BSBasicAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                result.setText(list.get(position));
                flag1 = true;
                if(flag1 && flag2){
                    buttonAfter(btn_next);
                }
                BottomSheet.dismiss();
            }
        });

        BottomSheet = new BottomSheetDialog(this);
        BottomSheet.setContentView(view);
        BottomSheet.show();

    }
}
