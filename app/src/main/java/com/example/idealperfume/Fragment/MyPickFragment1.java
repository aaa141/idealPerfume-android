package com.example.idealperfume.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.idealperfume.Adapter.MyPickProductAdapter;
import com.example.idealperfume.Data.MyPickData;
import com.example.idealperfume.R;

import java.util.ArrayList;
import java.util.List;


public class MyPickFragment1 extends Fragment {

    View v;
    private RecyclerView recyclerview;
    private List<MyPickData> listpickdata;
    private MyPickProductAdapter myPickProductAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_my_pick1, container, false);
        recyclerview = v.findViewById(R.id.rv_mypickproduct);
        myPickProductAdapter = new MyPickProductAdapter(getContext(), listpickdata);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerview.setAdapter(myPickProductAdapter);

        recyclerview.addItemDecoration(new DividerItemDecoration(v.getContext(), 1));
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listpickdata = new ArrayList<>();
        listpickdata.add(new MyPickData("일리윤","illiyoon", "세라 마이드 아토 로션 350ml", R.drawable.icon_circle));
        listpickdata.add(new MyPickData("더마비", "Derma:B","데일리 모이스처 바디 로션 400ml", R.drawable.icon_circle));
    }
}