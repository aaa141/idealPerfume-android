package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.idealperfume.Adapter.PI_ProductAdapter;
import com.example.idealperfume.Adapter.ReviewAdapter;
import com.example.idealperfume.Data.ProductInfoData;
import com.example.idealperfume.Data.ReviewData;
import com.example.idealperfume.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ProductInfoActivity extends AppCompatActivity implements View.OnClickListener {

    FlexboxLayout pdHashtagLayout;
    PieChart pieChart;
    BarChart barChart;
    FloatingActionButton floatingActionButton;
    RecyclerView rv_review, rv_recommend, rv_ranking;
    PI_ProductAdapter recommendAdapter, rankingAdapter;
    TextView tv_pdPrice,tv_pdBrand, tv_pdName, tv_reviewMore, tv_reviewMore2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);

        pdHashtagLayout = (FlexboxLayout) findViewById(R.id.pdHashtagLayout);
        pieChart = (PieChart) findViewById(R.id.pieChart);
        //barChart = (BarChart) findViewById(R.id.barChart);
        rv_recommend = findViewById(R.id.rv_recommend);
        rv_ranking = findViewById(R.id.rv_ranking);
        rv_review = findViewById(R.id.rv_review);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        tv_reviewMore2 = findViewById(R.id.tv_reviewMore2);
        tv_reviewMore = findViewById(R.id.tv_reviewMore);
        tv_pdBrand = findViewById(R.id.tv_pdBrand);
        tv_pdName = findViewById(R.id.tv_pdName);
        tv_pdPrice = findViewById(R.id.tv_pdPrice);

        tv_reviewMore.setOnClickListener(this);
        tv_reviewMore2.setOnClickListener(this);
        floatingActionButton.setOnClickListener(this);
        init();
        drawPieChart();
    }

    //8.13) 구성원료랑 해시태그는 나중에
    public void init(){
        //상품 ID 넘기면
        //상품 브랜드, 상품명, 별점, 가격, 브랜드 설명, 원료 이미지, 원료명, ...




        //해시태그 textview 설정
        String[] hastag ={"보습","촉촉/수분","향/냄새","건조","흡수력","끈적","발림성","민감/예민", "유분"};
        for (int i=0; i<hastag.length; i++) {
            TextView tv = new TextView(this);
            tv.setText("#"+hastag[i]);
            tv.setBackground(getResources().getDrawable(R.drawable.text_round,null));
            tv.setTextColor(getResources().getColor(R.color.green));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);

            params.rightMargin = Math.round(5*getResources().getDisplayMetrics().density);
            params.bottomMargin = Math.round(10*getResources().getDisplayMetrics().density);
            tv.setLayoutParams(params);
            pdHashtagLayout.addView(tv);
        }

        //세줄 후기
        //(서버) 공감수 순으로 리뷰 2개 가져오기
        ArrayList<ReviewData> mList = new ArrayList<>();
        mList.add(new ReviewData("정은재은재"
                ,"2020.05.29"
                ,"이모가 선물로 사준 향수이며 저의 첫 향수에요 :)향덕이 된 이유는 이 향수랍니다 ㅎㅎ"
                , "정말 단점이 없지만 굳이 뽑자면 첫향이 조금"
                ,"#보습"
                ,"4","11","4",true
                ,true,R.drawable.icon_circle));
        mList.add(new ReviewData("정은재은재"
                ,"2020.05.29"
                ,"이모가 선물로 사준 향수이며 저의 첫 향수에요 :)향덕이 된 이유는 이 향수랍니다 ㅎㅎ"
                , "정말 단점이 없지만 굳이 뽑자면 첫향이 조금"
                ,"#보습"
                ,"4","11","4",true
                ,true,R.drawable.icon_circle));
        ReviewAdapter reviewAdapter = new ReviewAdapter(this, mList);
        rv_review.setLayoutManager(new LinearLayoutManager(this));
        rv_review.setAdapter(reviewAdapter);

        LinearLayoutManager manager1 = new LinearLayoutManager(this);
        LinearLayoutManager manager2 = new LinearLayoutManager(this);
        manager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        manager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_recommend.setLayoutManager(manager1);
        rv_ranking.setLayoutManager(manager2);


        // 데이터 받아와서 넣기
        ArrayList<ProductInfoData> list = new ArrayList<ProductInfoData>();
        list.add(new ProductInfoData(R.drawable.productx,"일리윤(illiyoon)","세라마이드 아토 로션 350ml",19000));
        list.add(new ProductInfoData(R.drawable.productx,"닥터지","레드 블레미쉬 크림",23000));
        list.add(new ProductInfoData(R.drawable.productx,"샤넬","샹스 오드 퍼퓸 스프레이",239100));

        recommendAdapter = new PI_ProductAdapter(this, list);
        rankingAdapter = new PI_ProductAdapter(this,list);

        rv_recommend.setAdapter(recommendAdapter);
        rv_ranking.setAdapter(rankingAdapter);
    }

    private void drawPieChart(){

        int[] colorArray =
                new int[]{getResources().getColor(R.color.green)
                        , getResources().getColor(R.color.yellow)
                        , getResources().getColor(R.color.lineColor)};

        pieChart.setCenterText("여성이 더 많이\n구매한 제품");
        pieChart.setCenterTextSize(14f);
        pieChart.setCenterTextColor(getResources().getColor(R.color.reviewTextColor));

        pieChart.getDescription().setEnabled(false);
        pieChart.setDrawEntryLabels(false);
        pieChart.getLegend().setEnabled(false);
        pieChart.setClickable(false);
        pieChart.setHoleRadius(86f);
        pieChart.setTransparentCircleRadius(86f);

        List<PieEntry> value = new ArrayList<>();
        //value 가져오기
        value.add(new PieEntry(75f,"여성")); //여성
        value.add(new PieEntry(20f,"남성")); //남성
        value.add(new PieEntry(5f,"기타")); //기타

        PieDataSet pieDataSet = new PieDataSet(value,"");
        pieDataSet.setColors(colorArray);
        pieDataSet.setDrawValues(false);

        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);

    }
    private void setLegend(){
        Legend legend = pieChart.getLegend();
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setForm(Legend.LegendForm.SQUARE);
        legend.setTextSize(13f);
        legend.setTextColor(getResources().getColor(R.color.lightBlack));
        //legend.setForm(Legend.LegendForm.);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_reviewMore: case R.id.tv_reviewMore2:
                startActivity(new Intent(ProductInfoActivity.this,ReviewActivity.class));
                break;
            case R.id.floatingActionButton:
                startActivity(new Intent(ProductInfoActivity.this,ReviewRegActivity.class));
                break;
        }
    }
}

