package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.idealperfume.Adapter.BSBasicAdapter;
import com.example.idealperfume.Adapter.PI_PSearchAdapter;
import com.example.idealperfume.Adapter.PI_QuickAdapter;
import com.example.idealperfume.Adapter.PI_SearchAdapter;
import com.example.idealperfume.Fragment.PI_PSearchFragment;
import com.example.idealperfume.R;

import java.util.ArrayList;
import java.util.Arrays;

public class PI_QuickActivity extends AppCompatActivity {

    ArrayList<String> mList = new ArrayList<>(Arrays.asList("계열 : ㅇㅇㅇ", "연령대 : 20대", "이미지 : 자연적인" , "가격 : 5조"));
    PI_PSearchFragment PI_PSearchFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pi_quick);

        //리사이클러뷰 퀵 선택
        PI_QuickAdapter adapter = new PI_QuickAdapter(mList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcv_quick);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

        //제품리스트 프래그먼트
        PI_PSearchFragment = (PI_PSearchFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_pi_quick);
    }
}
