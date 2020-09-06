package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.NameValueDataEntry;
import com.anychart.charts.Venn;
import com.example.idealperfume.Adapter.MaterialsAdapter;
import com.example.idealperfume.Data.MaterialsData;
import com.example.idealperfume.R;
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

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        recyclerView.setNestedScrollingEnabled(false);
        // ArrayList에 person 객체(이름과 번호) 넣기
        List<MaterialsData> materialdata = new ArrayList<>();
        materialdata.add(new MaterialsData(R.drawable.icon_circle, "시프레", "백단에서 채취한 두발용 향", 50));
        materialdata.add(new MaterialsData(R.drawable.icon_circle, "푸제르", "백단에서 채취한 두발용 향", 20));
        materialdata.add(new MaterialsData(R.drawable.icon_circle, "시트러스", "백단에서 채취한 두발용 향", 20));
        materialdata.add(new MaterialsData(R.drawable.icon_circle, "파우더", "백단에서 채취한 두발용 향", 10));

        // Adapter생성
        recyclerViewAdapter = new MaterialsAdapter(this, materialdata);
        recyclerView.setAdapter(recyclerViewAdapter);

        int[] colorArray = new int[] {getResources().getColor(R.color.green6D),
                getResources().getColor(R.color.testColor2),
                getResources().getColor(R.color.testColor1),
                getResources().getColor(R.color.testColor)};
//        List<Integer> textColorArray = new ArrayList<>();
//        textColorArray.add(Color.WHITE);
//        textColorArray.add(getResources().getColor(R.color.green6D));

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


        PieDataSet dataSet = new PieDataSet(getData(),"");
        dataSet.setColors(colorArray);
        dataSet.setValueTextColor(Color.WHITE);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(15f);
        data.setValueFormatter(new PercentFormatter(pieChart));
        pieChart.setData(data);

    }

    private ArrayList<PieEntry> getData(){
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(50, "시프레"));
        entries.add(new PieEntry(20, "푸제르"));
        entries.add(new PieEntry(20, "시트러스"));
        entries.add(new PieEntry(10, "파우더"));
        return entries;
    }


}

