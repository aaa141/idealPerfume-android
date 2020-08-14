package com.example.idealperfume.Fragment;

import android.graphics.Paint;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.idealperfume.Adapter.ReviewAdapter;
import com.example.idealperfume.Data.ReviewData;
import com.example.idealperfume.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ReviewFragment extends Fragment {

    ArrayList<ReviewData> mList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_review, container, false);

        RecyclerView mRecyclerView = view.findViewById(R.id.rcv_review);
        ReviewAdapter ReviewAdapter = new ReviewAdapter(getContext(), mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(ReviewAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL));
        mRecyclerView.setHasFixedSize(true);

        return view;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String good = getResources().getString(R.string.testGoodReview);
        String bad = getResources().getString(R.string.testBadReview);
        String tag = getResources().getString(R.string.testTagReview);
        addItem("김현지", "2020.08.07", good, bad,
                tag, "4", "15", "5.0",true, true, R.drawable.tmp_review3);

        addItem("이현우", "2020.07.17", "부드럽고 포근한 향이에요 :)\n클린의 웜코튼과 비슷한 향입니다!", "가격이 비싸다는 것과 지속력이 많이 떨어져요ㅠㅠ\n 이러한 점들만 보완되면 좋겠어요",
                "#섬유유연제향 #촉촉 #부드러움 #포근함", "1", "10", "2.5",false, true, R.drawable.tmp_review2);

        addItem("최민아", "2020.07.31", "겨울에 어울리는 포근한 향이에요!", "향은 너무 좋지만 생각보다 지속력이 떨어져요",
                "#복숭아 #달콤 #과일향", "0", "8", "3.5",false, false, R.drawable.tmp_review1);

    }


    public void addItem(String userID, String date, String good, String bad,
                        String tag, String comment, String numberOfHeart, String numberOfStar, boolean heart, boolean bookmark , int userImage) {
        ReviewData item = new ReviewData(userID, date, good, bad, tag,
                comment, numberOfHeart, numberOfStar, heart, bookmark , userImage);
        mList.add(item);
    }


}