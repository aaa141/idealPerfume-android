package com.example.idealperfume.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.idealperfume.Data.RatingData;
import com.example.idealperfume.R;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class RatingFragment extends Fragment {

    ArrayList<RatingData> mList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_rating, container, false);

        TextView tv_rating = (TextView) view.findViewById(R.id.tv_rating);
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.rb_ProductRating);

        tv_rating.setText(mList.get(0).getStarPoint());
        ratingBar.setRating(Float.valueOf(mList.get(0).getStarPoint()));
        return view;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addItem("4.41", "3", "2", "3", "4", "3");

    }

    public void addItem(String starPoint, String one, String two,
                        String three, String four, String five) {
        RatingData item = new RatingData(starPoint, one, two, three, four, five);
        mList.add(item);
    }

}