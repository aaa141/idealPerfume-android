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

        String tmp = getResources().getString(R.string.testReview);
        addItem("김가나다", "2000.20.00", tmp, tmp,
                tmp, "4", "10", "4.5",true, false, R.drawable.edit_gray);

        addItem("김가나다", "2000.20.00", "조아용", "사실 뻥이에요",
                "#다다", "4", "10", "1.5",true, false, R.drawable.edit_gray);

        addItem("김가나다", "2000.20.00", "조아용", "사실 뻥이에요",
                tmp, "4", "10", "4.5",true, false, R.drawable.edit_gray);

    }


    public void addItem(String userID, String date, String good, String bad,
                        String tag, String comment, String numberOfHeart, String numberOfStar, boolean heart, boolean bookmark , int userImage) {
        ReviewData item = new ReviewData(userID, date, good, bad, tag,
                comment, numberOfHeart, numberOfStar, heart, bookmark , userImage);
        mList.add(item);
    }


}