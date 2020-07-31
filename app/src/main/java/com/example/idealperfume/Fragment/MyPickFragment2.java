package com.example.idealperfume.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.idealperfume.Adapter.MyPickBrandAdapter;
import com.example.idealperfume.Adapter.MyPickProductAdapter;
import com.example.idealperfume.MyPickData;
import com.example.idealperfume.R;

import java.util.ArrayList;
import java.util.List;

public class MyPickFragment2 extends Fragment {

    View v;
    private RecyclerView recyclerview;
    private List<MyPickData> listpickdata;
    private MyPickBrandAdapter myPickBrandAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_my_pick2, container, false);
        recyclerview = v.findViewById(R.id.rv_mypickbrand);
        myPickBrandAdapter = new MyPickBrandAdapter(getContext(), listpickdata);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerview.setAdapter(myPickBrandAdapter);

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