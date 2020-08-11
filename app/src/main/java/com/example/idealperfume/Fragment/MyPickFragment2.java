package com.example.idealperfume.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.idealperfume.Activity.PI_SearchActivity;
import com.example.idealperfume.Adapter.MyPickBrandAdapter;
import com.example.idealperfume.Data.MyPickData;
import com.example.idealperfume.MyButtonClickListener;
import com.example.idealperfume.MyPickSwipeHelper;
import com.example.idealperfume.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MyPickFragment2 extends Fragment {

    View v;
    private RecyclerView recyclerview;
    private List<MyPickData> listpickdata;
    private MyPickBrandAdapter myPickBrandAdapter;
    private FloatingActionButton floatbtn_search;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_my_pick2, container, false);
        recyclerview = v.findViewById(R.id.rv_mypickbrand);
        myPickBrandAdapter = new MyPickBrandAdapter(getContext(), listpickdata);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerview.setAdapter(myPickBrandAdapter);

        floatbtn_search = v.findViewById(R.id.floatbtn_search);

        MyPickSwipeHelper myPickSwipeHelper = new MyPickSwipeHelper(getContext(), recyclerview, 280) {
            @Override
            public void instantiaterMyButton(RecyclerView.ViewHolder viewHolder, List<MyButton> buffer) {
                buffer.add(new MyButton(getContext(),
                        "지우기",
                        50,
                        0,
                        Color.parseColor("#6da048"),
                        new MyButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                Toast.makeText(getContext(), "Click", Toast.LENGTH_SHORT).show();
                                listpickdata.remove(pos);
                            }
                        }));
            }
        };

        floatbtn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PI_SearchActivity.class);
                startActivity(intent);
            }
        });

        recyclerview.addItemDecoration(new DividerItemDecoration(v.getContext(), 1));
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listpickdata = new ArrayList<>();
        listpickdata.add(new MyPickData("일리윤","illiyoon", "아시아의 좋은 원료에서 찾은 피부과학", R.drawable.icon_circle));
        listpickdata.add(new MyPickData("이니스프리", "innisfree","피부에 휴식을 주는 섬", R.drawable.icon_circle));
    }
}