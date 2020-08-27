package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;

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
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class MaterialsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    MaterialsAdapter recyclerViewAdapter;
    private AnyChartView vennDiagramChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materials);

        recyclerView = findViewById(R.id.rv_materialslist);
        linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, linearLayoutManager.getOrientation()));
        recyclerView.setLayoutManager(linearLayoutManager);

        vennDiagramChart = (AnyChartView)findViewById(R.id.vennDiagramChart);
//        vennDiagramChart.setProgressBar(findViewById(R.id.progress_bar));
        Venn venn = AnyChart.venn();
        venn.data(getData());
        venn.stroke("#7caf57");
        venn.labels().format("{%Name}" + "" +
                "{%value}" + "%");
//        venn.intersections().hovered().fill("#000000", 0.25d);
        venn.intersections().labels().fontWeight("medium");
//        venn.intersections().hovered().background("#ffffff");
//        venn.intersections().hovered().fontColor("#7caf57");
        venn.fill("#ffffff");
        venn.fill("#ffffff");
        venn.labels().fontColor("#7caf57");
        venn.labels().fontSize("10sp"); // 원래는 12sp
        venn.labels().fontFamily();
//        venn.intersections().labels().format("{%Name}");
//        venn.tooltip().titleFormat("{%Name}");
        vennDiagramChart.setChart(venn);

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

    private ArrayList getData(){
        ArrayList<DataEntry> entries = new ArrayList<>();
        entries.add(new NameValueDataEntry("A", "시프레", 50));
        entries.add(new NameValueDataEntry("C", "푸제르", 35));
        entries.add(new NameValueDataEntry("B", "시트러스" , 35));
        entries.add(new NameValueDataEntry("D", "파우더", 30));
        return entries;
    }


}