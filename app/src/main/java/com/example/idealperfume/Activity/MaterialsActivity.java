package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.idealperfume.Adapter.MaterialsAdapter;
import com.example.idealperfume.Data.MaterialsData;
import com.example.idealperfume.R;
import com.example.idealperfume.Util.retrofit.RetrofitHelper;
import com.example.idealperfume.Util.retrofit.RetrofitService;
import com.example.idealperfume.model.FolderModel;
import com.example.idealperfume.model.GenderCompositionModel;
import com.example.idealperfume.model.MaterialModel;
import com.example.idealperfume.model.ProductModel;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.renderer.PieChartRenderer;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MaterialsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    MaterialsAdapter recyclerViewAdapter;
    PieChart pieChart;
    RetrofitService retrofitService;
//    ArrayList<MaterialsData> materialdata = new ArrayList<>();
    ArrayList<String> materialName = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materials);

        recyclerView = findViewById(R.id.rv_materialslist);
        linearLayoutManager = new LinearLayoutManager(this);

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.not_move, R.anim.right_out);
            }
        });

        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, linearLayoutManager.getOrientation()));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);

        retrofitService = RetrofitHelper.getRetrofit().create(RetrofitService.class);

        retrofitService.getMaterial(1)
                .enqueue(new Callback<ArrayList<MaterialModel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<MaterialModel>> call, Response<ArrayList<MaterialModel>> response) {
                        if(response.isSuccessful()){
                            ArrayList<MaterialModel> materialList = response.body();
                            MaterialArray(R.drawable.icon_circle, materialList.get(0).getmName(), materialList.get(0).getmIntro(), 50);
//                            materialdata.add(new MaterialsData(R.drawable.icon_circle, "푸제르", "백단에서 채취한 두발용 향", 20));
//                            materialdata.add(new MaterialsData(R.drawable.icon_circle, "시트러스", "백단에서 채취한 두발용 향", 20));
//                            materialdata.add(new MaterialsData(R.drawable.icon_circle, "파우더", "백단에서 채취한 두발용 향", 10));

                            materialName.add(materialList.get(0).getmName());
                            getData(materialName);
                        }
                    }
                    @Override
                    public void onFailure(Call<ArrayList<MaterialModel>> call, Throwable t) {
                        Log.d("testest",t.getMessage());
                    }
                });

//        // Adapter생성
//        recyclerViewAdapter = new MaterialsAdapter(this, materialdata);
//        recyclerView.setAdapter(recyclerViewAdapter);

        int[] colorArray = new int[] {getResources().getColor(R.color.green6D),
                getResources().getColor(R.color.testColor2),
                getResources().getColor(R.color.testColor1),
                getResources().getColor(R.color.testColor)};

        //pie chart
        pieChart = (PieChart)findViewById(R.id.piechart);
        pieChart.getDescription().setEnabled(false);
        pieChart.getDescription().setText("");
        pieChart.setDrawEntryLabels(true);
        pieChart.setEntryLabelColor(Color.WHITE);
        pieChart.setExtraOffsets(5,10,5,5);
        pieChart.setTouchEnabled(false);
        pieChart.setDrawHoleEnabled(false);
        pieChart.setEntryLabelTextSize(13f);
        pieChart.getLegend().setEnabled(false);
        pieChart.setUsePercentValues(true);
        pieChart.animateY(1000, Easing.EaseInOutCubic); //애니메이션

        PieDataSet dataSet = new PieDataSet(getData(materialName),"");
        dataSet.setColors(colorArray);
        dataSet.setValueTextColor(Color.WHITE);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(15f);
        data.setValueFormatter(new PercentFormatter(pieChart));
        pieChart.setData(data);

    }

    private void MaterialArray (int img, String name, String desc, int rate) {
        ArrayList<MaterialsData> materialdata = new ArrayList<>();

        materialdata.add(new MaterialsData(img, name, desc, rate));

        // Adapter생성
        recyclerViewAdapter = new MaterialsAdapter(this, materialdata);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private ArrayList<PieEntry> getData(ArrayList name) {
        ArrayList<PieEntry> entries = new ArrayList<>();
        System.out.println(name);
        entries.add(new PieEntry(50, name.get(0)));
        entries.add(new PieEntry(20, "푸제르"));
        entries.add(new PieEntry(20, "시트러스"));
        entries.add(new PieEntry(10, "파우더"));
        return entries;
    }

    @Override
    public void onBackPressed() {

        super.finish();
        overridePendingTransition(R.anim.not_move, R.anim.right_out);
    }
}

