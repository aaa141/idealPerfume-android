package com.example.idealperfume.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.idealperfume.Adapter.RankingAdapter;
import com.example.idealperfume.Data.RankingData;
import com.example.idealperfume.R;

import java.util.ArrayList;
import java.util.List;


public class Ranking_10sFragment extends Fragment {
    View v;
    private RecyclerView recyclerview;
    private List<RankingData> rankingData;
    private RankingAdapter rankingAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_ranking_10s, container, false);
        recyclerview = v.findViewById(R.id.rv_ranking);
        rankingAdapter = new RankingAdapter(getContext(), rankingData);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerview.setAdapter(rankingAdapter);

        recyclerview.addItemDecoration(new DividerItemDecoration(v.getContext(), 1));

        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rankingData = new ArrayList<>();
        rankingData.add(new RankingData(1,2, R.drawable.main_perfume,"일리윤", "illiyoon", "아시아의 좋은 원료에서 찾은 피부과학"));
        rankingData.add(new RankingData(2,1,R.drawable.main_diffuser,"이니스프리", "innisfree","피부에 휴식을 주는 섬"));
        rankingData.add(new RankingData(3,2, R.drawable.main_perfume,"일리윤", "illiyoon", "아시아의 좋은 원료에서 찾은 피부과학"));
        rankingData.add(new RankingData(4,1,R.drawable.main_perfume,"이니스프리", "innisfree","피부에 휴식을 주는 섬"));
        rankingData.add(new RankingData(5,2, R.drawable.main_perfume,"일리윤", "illiyoon", "아시아의 좋은 원료에서 찾은 피부과학"));
    }
}