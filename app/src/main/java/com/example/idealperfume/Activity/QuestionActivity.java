package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.idealperfume.Adapter.BSBasicAdapter;
import com.example.idealperfume.R;
import com.example.idealperfume.Util.retrofit.RetrofitHelper;
import com.example.idealperfume.Util.retrofit.RetrofitService;
import com.example.idealperfume.model.LoginModel;
import com.example.idealperfume.model.QnAModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class QuestionActivity extends AppCompatActivity {

    ArrayList<String> question = new ArrayList<>(Arrays.asList("선택안함", "이벤트 문의", "서비스 불편 오류제보", "사용방법 문의", "아이디어 제안", "제휴문의"));
    BottomSheetDialog BottomSheet;
    boolean flag_category, flag_question, flag_email;
    TextView tv_show_list;
    EditText ed_question, ed_email;
    Button btn_next;
    Drawable btn_border;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        tv_show_list = (TextView) findViewById(R.id.tv_show_list);
        ed_question = (EditText) findViewById(R.id.ed_question);
        ed_email = (EditText) findViewById(R.id.ed_email);
        btn_next = (Button) findViewById(R.id.btn_nxt);
        btn_border = getResources().getDrawable(R.drawable.btn_border);

        tv_show_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createBasicDialog(question, "");
            }
        });

        //editText 효과
        editTextFunc(ed_question);
        editTextFunc(ed_email);


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(QuestionActivity.this, "성공적으로 전송되었습니다.", Toast.LENGTH_SHORT).show();

                RetrofitService retrofitService = RetrofitHelper.getRetrofit().create(RetrofitService.class);

                Call<QnAModel> call = retrofitService.getQnACheck(Integer.parseInt("1"), tv_show_list.getText().toString(),
                        ed_question.getText().toString(), ed_email.getText().toString());

                call.enqueue(new Callback<QnAModel>() {
                    @Override
                    public void onResponse(Call<QnAModel> call, Response<QnAModel> response) {
                        QnAModel qnAModel = response.body();
                    }

                    @Override
                    public void onFailure(Call<QnAModel> call, Throwable t) {
                        Log.d("ssss","fail");
                    }
                });

                finish(); //액티비티 종료
            }
        });
    }


    //----메서드-----

    //버튼 클릭 전
    private void buttonBefore(Button button) {
        button.setEnabled(false);
        button.setTextColor(getResources().getColor(R.color.bfrClickTextColor));
        button.setBackgroundResource(R.drawable.btn_bfrclick);
    }

    //버튼 클릭 후
    private void buttonAfter(Button button) {
        button.setEnabled(true);
        button.setTextColor(getResources().getColor(R.color.white));
        button.setBackgroundResource(R.drawable.btn_onclick);
    }

    //바텀 다이얼로그
    private void createBasicDialog(final ArrayList<String> list, String title) {
        BSBasicAdapter adapter = new BSBasicAdapter(list);
        View view = getLayoutInflater().inflate(R.layout.dialog_bs_basic, null);

        //"xx"를 선택하세요.
        TextView titles = (TextView) view.findViewById(R.id.tv_bs_basic_title);
        View line = (View) view.findViewById(R.id.line_bs_title);
        titles.setText(title);

        //"xx"를 선택하세요.
        if (!title.equals("")) {
            titles.setText(title);
        } else {
            titles.setVisibility(View.GONE);
            line.setVisibility(View.GONE);
        }

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
                flag_category = true;
                if (flag_category && flag_question && flag_email) {
                    buttonAfter(btn_next);
                }
                BottomSheet.dismiss();
            }
        });

        BottomSheet = new BottomSheetDialog(this);
        BottomSheet.setContentView(view);
        BottomSheet.show();

    }

    //버튼 색 변경+글 작성시 border를 초록색으로
    private void editTextFunc(final EditText ed){

        //버튼 색 변경
        ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                buttonBefore(btn_next);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (ed.getText().length() > 0 && ed.getText().length() > 0) {

                    if(ed == ed_email) flag_email= true;
                    else flag_question = true;

                    if (flag_category && flag_question && flag_email) {
                        buttonAfter(btn_next);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (ed.getText().length() == 0 || ed.getText().length() == 0) {
                    buttonBefore(btn_next);
                }
            }
        });

        //포커스
        ed.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    ed.setBackgroundResource(R.drawable.edit_greenborder);
                    if(ed==ed_question) {
                        float scale = getResources().getDisplayMetrics().density;
                        int dpAsPixels = (int) (23*scale + 0.5f);
                        ed.setPadding(dpAsPixels,dpAsPixels,0,0);
                    }
                }
                else
                    ed.setBackgroundResource(R.drawable.edit_round);
            }
        });
    }
}
