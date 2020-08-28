package com.example.idealperfume.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.idealperfume.Data.RatingData;
import com.example.idealperfume.R;
import com.example.idealperfume.Util.CustomBarChartRender;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class RatingFragment extends Fragment {

    ArrayList<RatingData> mList = new ArrayList<>();
    ArrayList<String> xVals = new ArrayList<String>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_rating, container, false);

        //BarChart BarChart = (BarChart) view.findViewById(R.id.barchart);
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

    private ArrayList<BarEntry>data1(){
        ArrayList<BarEntry>vals1 = new ArrayList<BarEntry>();
        vals1.add(new BarEntry(0,Integer.parseInt(mList.get(0).getFive())));
        vals1.add(new BarEntry(1,Integer.parseInt(mList.get(0).getFour())));
        vals1.add(new BarEntry(2,Integer.parseInt(mList.get(0).getThree())));
        vals1.add(new BarEntry(3,Integer.parseInt(mList.get(0).getTwo())));
        vals1.add(new BarEntry(4,Integer.parseInt(mList.get(0).getOne())));
        return vals1;
    }

    private ArrayList<BarEntry>data2(){
        ArrayList<BarEntry>vals2 = new ArrayList<BarEntry>();
        vals2.add(new BarEntry(0,5));
        vals2.add(new BarEntry(1,5));
        vals2.add(new BarEntry(2,5));
        vals2.add(new BarEntry(3,5));
        vals2.add(new BarEntry(4,5));
        return vals2;
    }

}