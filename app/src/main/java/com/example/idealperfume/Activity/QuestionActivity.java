package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.idealperfume.Adapter.BSBasicAdapter;
import com.example.idealperfume.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class QuestionActivity extends AppCompatActivity {

    ArrayList<String> question = new ArrayList<>(Arrays.asList("선택안함","이벤트 문의","서비스 불편 오류제보", "사용방법 문의", "아이디어 제안","제휴문의"));
    BottomSheetDialog BottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        TextView tv_show_list = (TextView) findViewById(R.id.tv_show_list);

        tv_show_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createBasicDialog(question, "문의유형을 선택하세요");
            }
        });
    }

        private void createBasicDialog(final ArrayList<String> list, String title){
            BSBasicAdapter adapter=new BSBasicAdapter(list);
            View view=getLayoutInflater().inflate(R.layout.dialog_bs_basic, null);

            //"xx"를 선택하세요.
            TextView titles = (TextView) view.findViewById(R.id.tv_bs_basic_title);
            titles.setText(title);

            RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.rcv_bs_basic);
            recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);

            adapter.setOnItemClickListener(new BSBasicAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View v, int position) {

                    Toast.makeText(QuestionActivity.this, list.get(position),Toast.LENGTH_SHORT).show();
                    BottomSheet.dismiss();
                }
            }) ;

            BottomSheet=new BottomSheetDialog(this);
            BottomSheet.setContentView(view);
            BottomSheet.show();

        }
}
