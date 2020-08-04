package com.example.idealperfume.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.idealperfume.Adapter.PI_BSearchAdapter;
import com.example.idealperfume.Data.Pi_BSearchData;
import com.example.idealperfume.R;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class PI_BSearchFragment extends Fragment {
    ArrayList<Pi_BSearchData> mList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_pi_bsearch, container, false);

        RecyclerView mRecyclerView = view.findViewById(R.id.rcv_pi_bsearch);
        PI_BSearchAdapter searchAdapter = new PI_BSearchAdapter(getContext(), mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(searchAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL));
        mRecyclerView.setHasFixedSize(true);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addItem(R.drawable.ic_launcher_background, false,
                "브랜드명", "아이고아이고아이고아이고고고");
        addItem(R.drawable.ic_launcher_background, true,
                "브랜드명", "아이고아이고아이고아이고고고");
    }

    public void addItem(int brandImage, boolean heart, String brandName, String slogan) {
        Pi_BSearchData item = new Pi_BSearchData(brandName, slogan, brandImage, heart);

        mList.add(item);
    }

}



