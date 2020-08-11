package com.example.idealperfume.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.idealperfume.Activity.MainActivity;
import com.example.idealperfume.Adapter.MyPickProductAdapter;
import com.example.idealperfume.Data.MyPickData;
import com.example.idealperfume.MyButtonClickListener;
import com.example.idealperfume.MyPickSwipeHelper;
import com.example.idealperfume.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class MyPickFragment1 extends Fragment implements MyPickDialogFragment1.OnInputSelected{

    View v;
    private RecyclerView recyclerview;
    private List<MyPickData> listpickdata;
    private MyPickProductAdapter myPickProductAdapter;
    private FloatingActionButton floatbtn_plus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_my_pick1, container, false);
        recyclerview = v.findViewById(R.id.rv_mypickproduct);
        myPickProductAdapter = new MyPickProductAdapter(getContext(), listpickdata);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerview.setAdapter(myPickProductAdapter);
        floatbtn_plus = v.findViewById(R.id.floatbtn_plus);

        MyPickSwipeHelper myPickSwipeHelper = new MyPickSwipeHelper(getContext(), recyclerview, 280) {
            @Override
            public void instantiaterMyButton(RecyclerView.ViewHolder viewHolder, List<MyButton> buffer) {
                buffer.add(new MyButton(getContext(),
                        "지우기",
                        50,
                        0,
                        Color.parseColor("#6da048"),
                        new MyButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                listpickdata.remove(pos);
                            }
                        }));
            }
        };

        floatbtn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyPickDialogFragment1 dialog = new MyPickDialogFragment1();
                dialog.setTargetFragment(MyPickFragment1.this, 1);
                dialog.show(getFragmentManager(), "MyPickDialog1");
            }
        });


        recyclerview.addItemDecoration(new DividerItemDecoration(v.getContext(), 1));
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listpickdata = new ArrayList<>();
        listpickdata.add(new MyPickData("일리윤","illiyoon", "세라 마이드 아토 로션 350ml", R.drawable.icon_circle));
        listpickdata.add(new MyPickData("더마비", "Derma:B","데일리 모이스처 바디 로션 400ml", R.drawable.icon_circle));
    }

    @Override
    public void sendInput(String input) {

    }
}