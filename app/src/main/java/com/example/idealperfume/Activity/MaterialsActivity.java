package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;

import com.example.idealperfume.Adapter.MaterialsAdapter;
import com.example.idealperfume.Data.MaterialsData;
import com.example.idealperfume.R;

import java.util.ArrayList;
import java.util.List;

public class MaterialsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    MaterialsAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materials);

        recyclerView = findViewById(R.id.rv_materialslist);
        linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, linearLayoutManager.getOrientation()));
        recyclerView.setLayoutManager(linearLayoutManager);

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
}