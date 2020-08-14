package com.example.idealperfume.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.idealperfume.Adapter.BSBasicAdapter;
import com.example.idealperfume.Adapter.PI_PSearchAdapter;
import com.example.idealperfume.Data.Pi_PSearchData;
import com.example.idealperfume.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Arrays;

public class PI_PSearchFragment extends Fragment {

    ArrayList<Pi_PSearchData> mList = new ArrayList<>();
    ArrayList<String> mSort = new ArrayList<>(Arrays.asList("즐겨찾기순", "높은 가격순", "낮은 가격순", "리뷰 많은순"));
    BottomSheetDialog BottomSheet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_pi_psearch, container, false);

        //???왜 되는거지??
        if(container == view.findViewById(R.id.pi_quick_container)) {
            LinearLayout ll = (LinearLayout) view.findViewById(R.id.ll_only_pi);
            ll.setVisibility(View.GONE);
        }
        else {
            TextView tv_sortBy = (TextView) view.findViewById(R.id.tv_sortBy);
            tv_sortBy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    createDialog(mSort, "", view);
                }
            });
        }

        RecyclerView mRecyclerView = view.findViewById(R.id.rcv_pi_psearch);
        PI_PSearchAdapter searchAdapter = new PI_PSearchAdapter(getContext(), mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(searchAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL));
        mRecyclerView.setHasFixedSize(true);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addItem(R.drawable.ic_launcher_background, false,
                "세라마이드 아토 로션 350ml", "4.41", "(9,267)", "일리윤 (illiyoon)", "19,900원");
        addItem(R.drawable.ic_launcher_background,true,
                "데일리 모이스처 바디 로션 400ml", "4.32", "(2,934)", "더마비 (Derma:B)", "16,000원");
        addItem(R.drawable.ic_launcher_background, false,
                "베이비 로션", "4.33", "(1,274)", "보타니컬테라티 (Botanical Therapy)", "25,000원");
        addItem(R.drawable.ic_launcher_background, false,
                "아토베리어 로션", "4.23", "(1,557)", "에스트라 (Aestura)", "35,000원");
        addItem(R.drawable.ic_launcher_background, false,
                "세라마이드 아토 로션 350ml", "4.41", "(9,267)", "일리윤 (illiyoon)", "19,900원");
        addItem(R.drawable.ic_launcher_background,true,
                "데일리 모이스처 바디 로션 400ml", "4.32", "(2,934)", "더마비 (Derma:B)", "16,000원");
    }


    public void addItem(int prodImage, boolean heart, String prodName, String starPoint,
                        String reviewCnt, String brandName, String price) {
        Pi_PSearchData item = new Pi_PSearchData(brandName, prodName, price,
                starPoint, reviewCnt, prodImage, heart);

        mList.add(item);
    }

    private void createDialog(final ArrayList<String> list, String title, View v) {
        BSBasicAdapter adapter = new BSBasicAdapter(list);
        View view = getLayoutInflater().inflate(R.layout.dialog_bs_basic, null);
        TextView titles = (TextView) view.findViewById(R.id.tv_bs_basic_title);
        View line = (View) view.findViewById(R.id.line_bs_title);

        //"xx"를 선택하세요.
        if (!title.equals("")) {
            titles.setText(title);
        }
        else{
            titles.setVisibility(View.GONE);
            line.setVisibility(View.GONE);
        }

        final TextView result = (TextView) v.findViewById(R.id.tv_sortBy);

        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcv_bs_basic);
        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new BSBasicAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                result.setText(list.get(position)+ " ∨");
                result.setTextColor(getResources().getColor(R.color.green6D));
                BottomSheet.dismiss();
            }
        });

        BottomSheet = new BottomSheetDialog(getContext());
        BottomSheet.setContentView(view);
        BottomSheet.show();
    }

}