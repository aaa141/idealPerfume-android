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

import com.example.idealperfume.Util.Bar;
import com.example.idealperfume.Util.CustomBarChartRender;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class RatingFragment extends Fragment {

    ArrayList<RatingData> mList = new ArrayList<>();
    ArrayList<String> xVals = new ArrayList<String>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_rating, container, false);

        TextView tv_rating = (TextView) view.findViewById(R.id.tv_rating);
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.rb_ProductRating);

        tv_rating.setText(mList.get(0).getStarPoint());
        ratingBar.setRating(Float.valueOf(mList.get(0).getStarPoint()));

        //bar chart
        BarChart BarChart = (BarChart) view.findViewById(R.id.bar_rating);
        CreateBarChart(BarChart);

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

    //여기가 초록색 그래프 데이터자리입니다!
    private ArrayList<BarEntry>data1(){
        ArrayList<BarEntry>vals1 = new ArrayList<BarEntry>();
        vals1.add(new BarEntry(0,Integer.parseInt(mList.get(0).getFive())));
        vals1.add(new BarEntry(1,Integer.parseInt(mList.get(0).getFour())));
        vals1.add(new BarEntry(2,Integer.parseInt(mList.get(0).getThree())));
        vals1.add(new BarEntry(3,Integer.parseInt(mList.get(0).getTwo())));
        vals1.add(new BarEntry(4,Integer.parseInt(mList.get(0).getOne())));
        return vals1;
    }

    //뒷 배경인 그레이색 그래프
    private ArrayList<BarEntry>data2(){
        ArrayList<BarEntry>vals2 = new ArrayList<BarEntry>();
        vals2.add(new BarEntry(0,5));
        vals2.add(new BarEntry(1,5));
        vals2.add(new BarEntry(2,5));
        vals2.add(new BarEntry(3,5));
        vals2.add(new BarEntry(4,5));
        return vals2;
    }

    private void CreateBarChart(BarChart BarChart){
        CustomBarChartRender barChartRender = new CustomBarChartRender(BarChart,BarChart.getAnimator(), BarChart.getViewPortHandler());
        barChartRender.setRadius(10);
        BarChart.setRenderer(barChartRender);

        BarDataSet barDataSet = new BarDataSet(data2(),"1");
        BarDataSet barDataSet2 = new BarDataSet(data1(),"2");

        barDataSet2.setColor(getResources().getColor(R.color.green6D));
        barDataSet.setColor(getResources().getColor(R.color.gray));

        YAxis leftAxis = BarChart.getAxisLeft();
        leftAxis.setAxisMaximum(5);
        leftAxis.setAxisMinimum((float)-0.1);

        BarData barData = new BarData(barDataSet);
        barData.addDataSet(barDataSet2);

        BarChart.setExtraOffsets(0f, 0f, 0f, 15f);

        BarChart.setMinimumHeight(270);

        barData.setBarWidth((float)0.18);
        barData.setValueTextSize(0);
        BarChart.setData(barData);
        BarChart.invalidate();

        BarChart.setDrawBorders(false);
        BarChart.setDrawGridBackground(false);
        BarChart.setTouchEnabled(false);
        BarChart.setClickable(false);

        BarChart.getDescription().setEnabled(false);
        BarChart.getLegend().setEnabled(false);
        BarChart.getAxisLeft().setDrawGridLines(false);
        BarChart.getAxisLeft().setDrawLabels(false);
        BarChart.getAxisLeft().setDrawAxisLine(false);

        BarChart.getXAxis().setDrawGridLines(false);
        BarChart.getXAxis().setDrawAxisLine(false);
        BarChart.getXAxis().setAxisMaximum(data1().size());

        BarChart.getAxisRight().setDrawGridLines(false);
        BarChart.getAxisRight().setDrawLabels(false);
        BarChart.getAxisRight().setDrawAxisLine(false);

        for(int i=5; i>=1; i--){
            xVals.add(i+"점");
        }

        BarChart.getXAxis().setGranularity(1.0f);
        BarChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(xVals));
        BarChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
    }
}