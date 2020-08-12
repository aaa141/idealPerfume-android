package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.idealperfume.Adapter.PI_ProductAdapter;
import com.example.idealperfume.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;
import java.util.List;

public class ProductInfoActivity extends AppCompatActivity {

    FlexboxLayout pdHashtagLayout;
    PieChart pieChart;
    BarChart barChart;

    RecyclerView rv_recommend, rv_ranking;
    PI_ProductAdapter recommendAdapter, rankingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);

        pdHashtagLayout = (FlexboxLayout) findViewById(R.id.pdHashtagLayout);
        pieChart = (PieChart) findViewById(R.id.pieChart);
        barChart = (BarChart) findViewById(R.id.barChart);
        rv_recommend = findViewById(R.id.rv_recommend);
        rv_ranking = findViewById(R.id.rv_ranking);



        init();
        drawPieChart();
    }

    public void init(){
        //상품 브랜드, 상품명, 별점, 가격

        //해시태그 textview 설정
        String[] hastag ={"#보습","촉촉/수분","향/냄새","건조","#흡수력","#끈적"};
        for (int i=0; i<hastag.length; i++) {
            TextView tv = new TextView(this);
            tv.setText("#"+hastag[i]); //(#을 내가 붙여야되는지..)
            tv.setBackground(getResources().getDrawable(R.drawable.text_round));
            pdHashtagLayout.addView(tv);
        }

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_recommend.setLayoutManager(manager);
        rv_ranking.setLayoutManager(manager);


        // 데이터 받아와서 넣기
        //recommendAdapter = new PI_ProductAdapter(this,);
        //rankingAdapter = new PI_ProductAdapter(this,);

        rv_recommend.setAdapter(recommendAdapter);
        rv_ranking.setAdapter(rankingAdapter);
    }
    public void drawPieChart(){
        

        pieChart.setCenterText("이 더 많이 구매한 제품");
        pieChart.setHoleRadius(86f);
        pieChart.setTransparentCircleRadius(86f);

        List<PieEntry> value = new ArrayList<>();
        //value 가져오기
        value.add(new PieEntry(40f,"여성"));
        value.add(new PieEntry(30f,"남성"));
        value.add(new PieEntry(30f,"기타"));

        PieDataSet pieDataSet = new PieDataSet(value,"?");
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
    }

}