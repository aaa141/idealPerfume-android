package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.idealperfume.Adapter.MaterialsAdapter;
import com.example.idealperfume.Data.MaterialsData;
import com.example.idealperfume.R;
import com.example.idealperfume.Util.CustomBarChartRender;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MaterialsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    MaterialsAdapter recyclerViewAdapter;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materials);

        recyclerView = findViewById(R.id.rv_materialslist);
        linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, linearLayoutManager.getOrientation()));
        recyclerView.setLayoutManager(linearLayoutManager);

        pieChart = findViewById(R.id.pieChart);

        makeChart();

        // ArrayList에 person 객체(이름과 번호) 넣기
        List<MaterialsData> materialdata = new ArrayList<>();
        materialdata.add(new MaterialsData(R.drawable.icon_circle, "시프레", "백단에서 채취한 두발용 향", 50));
        materialdata.add(new MaterialsData(R.drawable.icon_circle, "푸제르", "백단에서 채취한 두발용 향", 20));
        materialdata.add(new MaterialsData(R.drawable.icon_circle, "시트러스", "백단에서 채취한 두발용 향", 20));
        materialdata.add(new MaterialsData(R.drawable.icon_circle, "파우더", "백단에서 채취한 두발용 향", 10));

        // Adapter생성
        recyclerViewAdapter = new MaterialsAdapter(this, materialdata);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void makeChart(){

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);

        pieChart.setDrawHoleEnabled(false);
        pieChart.getLegend().setEnabled(false);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> yValues = new ArrayList<PieEntry>();
        yValues.add(new PieEntry(50f,"시프레"));
        yValues.add(new PieEntry(20f,"푸제르"));
        yValues.add(new PieEntry(10f,"시트러스"));
        yValues.add(new PieEntry(20f,"파우더"));

        pieChart.animateY(1000, Easing.EaseInOutCubic); //애니메이션

        PieDataSet dataSet = new PieDataSet(yValues,"");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(getResources().getColor(R.color.green7C));

        PieData data = new PieData((dataSet));
        data.setValueTextSize(16f);
        data.setValueTextColor(Color.WHITE);

        pieChart.setData(data);

    }
}