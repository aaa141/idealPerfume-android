package com.example.idealperfume.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.idealperfume.Activity.MainActivity;
import com.example.idealperfume.Activity.MyPickActivity;
import com.example.idealperfume.Adapter.MyPickProductAdapter;
import com.example.idealperfume.Data.MyPickData;
import com.example.idealperfume.MyButtonClickListener;
import com.example.idealperfume.MyPickSwipeHelper;
import com.example.idealperfume.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class MyPickFragment1 extends Fragment implements MyPickDialogFragment1.OnInputSelected{

    View v;
    private RecyclerView recyclerview_product;
    private List<MyPickData> listpickdata = new ArrayList<>();
    private MyPickProductAdapter myPickProductAdapter;
    private FloatingActionButton floatbtn_plus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_my_pick1, container, false);
        recyclerview_product = v.findViewById(R.id.rv_mypickproduct);
        myPickProductAdapter = new MyPickProductAdapter(getContext(), listpickdata);
        recyclerview_product.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview_product.setAdapter(myPickProductAdapter);
        floatbtn_plus = v.findViewById(R.id.floatbtn_plus);

//        if(getArguments() != null) {
//            String foldername = getArguments().getString("foldername"); // 전달한 key 값
//            listpickdata.add(new MyPickData(foldername,20 + "", date_today, R.drawable.folder, MyPickData.Code.ViewType.FolderListItem));
////            listpickdata.notify();
//        }

//        myPickProductAdapter.notifyItemInserted(0);
//        myPickProductAdapter.notifyItemRangeChanged(0, listpickdata.size());
//        listpickdata.add(new MyPickData("일리윤", "illiyoon", "세라 마이드 아토 로션 350ml", R.drawable.icon_circle, MyPickData.Code.ViewType.ProductListItem));
//        listpickdata.add(new MyPickData("더마비", "Derma:B","데일리 모이스처 바디 로션 400ml", R.drawable.icon_circle,  MyPickData.Code.ViewType.ProductListItem));


        MyPickSwipeHelper myPickSwipeHelper = new MyPickSwipeHelper(getContext(), recyclerview_product, 280) {
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

        return v;
    }

    Date today = Calendar.getInstance().getTime();
    String date_today = new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault()).format(today);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println(listpickdata.size());

//        listpickdata.add(new MyPickData("폴더", "20", date_today, R.drawable.folder, MyPickData.Code.ViewType.FolderListItem));
//        listpickdata.add(new MyPickData("일리윤", "illiyoon", "세라 마이드 아토 로션 350ml", R.drawable.icon_circle, MyPickData.Code.ViewType.ProductListItem));
//        listpickdata.add(new MyPickData("더마비", "Derma:B","데일리 모이스처 바디 로션 400ml", R.drawable.icon_circle,  MyPickData.Code.ViewType.ProductListItem));


//        if(getArguments() != null) {
//            String foldername = getArguments().getString("foldername"); // 전달한 key 값
//            listpickdata.add(0, new MyPickData(foldername, 20+"", null, date_today, R.drawable.folder, MyPickData.Code.ViewType.FolderListItem));
//
//        }

    }

    @Override
    public void onResume() {
        super.onResume();
        myPickProductAdapter.notifyDataSetChanged();
    }

    @Override
    public void sendInput(String input) {

    }


}