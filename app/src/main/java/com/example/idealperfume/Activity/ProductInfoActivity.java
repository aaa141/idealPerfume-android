package com.example.idealperfume.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.idealperfume.Adapter.PI_ProductAdapter;
import com.example.idealperfume.Adapter.ReviewAdapter;
import com.example.idealperfume.Data.ProductInfoData;
import com.example.idealperfume.Data.ReviewData;
import com.example.idealperfume.R;
import com.example.idealperfume.Util.retrofit.RetrofitHelper;
import com.example.idealperfume.Util.retrofit.RetrofitService;
import com.example.idealperfume.model.GenderCompositionModel;
import com.example.idealperfume.model.ProductModel;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductInfoActivity extends AppCompatActivity implements View.OnClickListener {

    FlexboxLayout pdHashtagLayout;
    PieChart pieChart;
    BarChart barChart;
    FloatingActionButton floatingActionButton;
    RecyclerView rv_review, rv_recommend, rv_ranking;
    PI_ProductAdapter recommendAdapter, rankingAdapter;
    TextView tv_pickCount, tv_pdPrice,tv_pdBrand, tv_pdName, tv_materialMore, tv_reviewMore, tv_reviewMore2;
    ImageView back, share, pdPick;
    int pickCount;
    RetrofitService retrofitService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);

        retrofitService = RetrofitHelper.getRetrofit().create(RetrofitService.class);
        pdHashtagLayout = (FlexboxLayout) findViewById(R.id.pdHashtagLayout);
        pieChart = (PieChart) findViewById(R.id.pieChart);
        //barChart = (BarChart) findViewById(R.id.barChart);
        rv_recommend = findViewById(R.id.rv_recommend);
        rv_ranking = findViewById(R.id.rv_ranking);
        rv_review = findViewById(R.id.rv_review);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        back = findViewById(R.id.back);
        share = findViewById(R.id.share);
        pdPick = findViewById(R.id.pdPick);
        tv_pickCount = findViewById(R.id.tv_pickCount);

        tv_materialMore = findViewById(R.id.tv_materialMore);
        tv_reviewMore2 = findViewById(R.id.tv_reviewMore2);
        tv_reviewMore = findViewById(R.id.tv_reviewMore);
        tv_pdBrand = findViewById(R.id.tv_pdBrand);
        tv_pdName = findViewById(R.id.tv_pdName);
        tv_pdPrice = findViewById(R.id.tv_pdPrice);

        tv_materialMore.setOnClickListener(this);
        tv_reviewMore.setOnClickListener(this);
        tv_reviewMore2.setOnClickListener(this);
        floatingActionButton.setOnClickListener(this);
        back.setOnClickListener(this);
        share.setOnClickListener(this);
        pdPick.setOnClickListener(this);


        init();
    }

    public void init(){
        //*서버*//
        //상품 정보
        retrofitService.getProductInfo(1)
            .enqueue(new Callback<ProductModel>() {
            @Override
            public void onResponse(Call<ProductModel> call, Response<ProductModel> response) {
                if(response.isSuccessful()) {
                    ProductModel productModel = response.body();
                    tv_pdName.setText(productModel.getName());
                    tv_pdBrand.setText(productModel.getbName());
                    Log.d("testest",productModel.getName());
                }
            }

            @Override
            public void onFailure(Call<ProductModel> call, Throwable t) {
                Log.d("testest",t.getMessage());
            }
        });

        //성별 분포
        retrofitService.getGenderComposition(1)
                .enqueue(new Callback<ArrayList<GenderCompositionModel>>() {
            @Override
            public void onResponse(Call<ArrayList<GenderCompositionModel>> call, Response<ArrayList<GenderCompositionModel>> response) {
                if(response.isSuccessful()){
                    ArrayList<GenderCompositionModel> list = response.body();
                    drawPieChart(list.get(0).getFemale(),list.get(0).getMale());
                }
            }
            @Override
            public void onFailure(Call<ArrayList<GenderCompositionModel>> call, Throwable t) {
                Log.d("testest",t.getMessage());
            }
        });

        // 상품 pick 설정
        tv_pickCount.setText("434");
        pickCount = Integer.parseInt(tv_pickCount.getText().toString());

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

        mList.add(new ReviewData("김현지"
                ,"2020.08.07"
                , getResources().getString(R.string.testGoodReview)
                , getResources().getString(R.string.testBadReview)
                ,getResources().getString(R.string.testTagReview)
                ,"4","15","5",true
                ,true,R.drawable.tmp_review3));
        mList.add(new ReviewData("이현우"
                ,"2020.05.29"
                ,"부드럽고 포근한 향이에요 :)\n클린의 웜코튼과 비슷한 향입니다!"
                , "가격이 비싸다는 것과 지속력이 많이 떨어져요ㅠㅠ\n 이러한 점들만 보완되면 좋겠어요"
                ,"#섬유유연제향 #촉촉 #부드러움 #포근함"
                ,"1","10","2",true
                ,true,R.drawable.tmp_review2));

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

    private void drawPieChart(float female, float male){

        int[] colorArray =
                new int[]{getResources().getColor(R.color.green)
                        , getResources().getColor(R.color.yellow)
                        , getResources().getColor(R.color.lineColor)};

        String str;
        if(female>male) str = "여성";
        else str="남성";

        pieChart.setCenterText(str+"이 더 많이\n구매한 제품");
        pieChart.setCenterTextSize(14f);
        pieChart.setCenterTextColor(getResources().getColor(R.color.grayC4));

        pieChart.getDescription().setEnabled(false);
        pieChart.setDrawEntryLabels(false);
        pieChart.getLegend().setEnabled(false);
        pieChart.setClickable(false);
        pieChart.setTouchEnabled(false);
        pieChart.setHoleRadius(86f);
        pieChart.setTransparentCircleRadius(86f);

        List<PieEntry> value = new ArrayList<>();
        //value 가져오기
        value.add(new PieEntry(female,"여성"));
        value.add(new PieEntry(male,"남성"));
        value.add(new PieEntry(1f,"기타"));

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
            case R.id.back: //뒤로 가기
                finish();
                break;

            case R.id.share: // 공유하기
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "전달할 메시지");
                startActivity(Intent.createChooser(intent, "공유하기"));

                break;

            case R.id.pdPick: // 상품 pick
                //서버랑 연동되면 어떻게 할지 몰라서 일단 냅둘께요...
                pdPick.setImageResource(R.drawable.img_mypick_on);
                pdPick.setImageTintMode(null);
                pickCount += 1;
                tv_pickCount.setText(pickCount+"");
                break;

            case R.id.tv_materialMore: // 구성원료 더보기
                startActivity(new Intent(ProductInfoActivity.this, MaterialsActivity.class));
                overridePendingTransition(R.anim.right_in, R.anim.not_move);
                break;

            case R.id.tv_reviewMore: case R.id.tv_reviewMore2: // 리뷰 더보기
                startActivity(new Intent(ProductInfoActivity.this,ReviewActivity.class));
                overridePendingTransition(R.anim.right_in, R.anim.not_move);
                break;

            case R.id.floatingActionButton:
                startActivity(new Intent(ProductInfoActivity.this,ReviewRegActivity.class));
                overridePendingTransition(R.anim.right_in, R.anim.not_move);
                break;
        }
    }
}

