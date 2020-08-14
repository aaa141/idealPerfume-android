package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.idealperfume.Adapter.SearchAdapter;
import com.example.idealperfume.R;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchActivity extends AppCompatActivity {

    ArrayList<String> mPopularList = new ArrayList<>();
    ArrayList<String> mSearchList = new ArrayList<>(Arrays.asList("플로럴 x", "머스크 x","오리엔탈 x"));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        String[] strings = getResources().getStringArray(R.array.tmp_popular);
        for(int i=0; i<strings.length; i++){
            mPopularList.add(strings[i]);
        }

        TextView tv_gotoQuick = (TextView)findViewById(R.id.tv_gotoQuick);
        tv_gotoQuick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(getApplicationContext(), QuickSearchActivity.class));
            }
        });
        RecyclerView rcv_popular = (RecyclerView)findViewById(R.id.rcv_popular);
        RecyclerView rcv_searchBfr = (RecyclerView)findViewById(R.id.rcv_searchBfr);
        SearchAdapter popularAdapter = new SearchAdapter(this,mPopularList);
        SearchAdapter searchAdapter = new SearchAdapter(this,mSearchList);

        FlexboxLayoutManager layoutManager1 = new FlexboxLayoutManager(getApplicationContext());
        FlexboxLayoutManager layoutManager2 = new FlexboxLayoutManager(getApplicationContext());
        layoutManager1.setFlexWrap(FlexWrap.WRAP);
        layoutManager2.setFlexWrap(FlexWrap.WRAP);
        layoutManager1.setFlexDirection(FlexDirection.ROW);
        layoutManager2.setFlexDirection(FlexDirection.ROW);

        rcv_popular.setLayoutManager(layoutManager1);
        rcv_searchBfr.setLayoutManager(layoutManager2);

        rcv_popular.setAdapter(popularAdapter);
        rcv_searchBfr.setAdapter(searchAdapter);
    }
}
