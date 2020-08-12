package com.example.idealperfume.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.idealperfume.R;

public class OnBoardingSliderAdapter extends RecyclerView.Adapter<OnBoardingSliderAdapter.OnBoardingSliderViewHolder> {

    Context context;
    LayoutInflater layoutInflater;

    public OnBoardingSliderAdapter(Context context) {
        this.context = context;
    }

    public String[] slide_mainText ={
            "향을 간접적으로 체험해보세요",
            "시간적인 비용을 최소화해요",
            "향기가 가득한 선물을 해보세요"
    };

    public String[] slide_subText ={
            "당신의 향을 이미지로 찾아주는 이상향 테스트로 향을 간접적으로 체험해보세요!",
            "당신의 향을 이미지로 찾아주는 이상향 테스트로 시간적인 비용을 최소화 해보세요!",
            "당신의 향을 이미지로 찾아주는 이상향 테스트로 향기로운 선물을 해보세요!"
    };


    @NonNull
    @Override
    public OnBoardingSliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.on_boarding_slide_layout, parent, false);

        return new OnBoardingSliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OnBoardingSliderViewHolder holder, int position) {
        holder.mainText.setText(slide_mainText[position]);
        holder.subText.setText(slide_subText[position]);

    }

    @Override
    public int getItemCount() {
        return slide_mainText.length;
    }


    //**ViewHolder**
    public class OnBoardingSliderViewHolder extends RecyclerView.ViewHolder{
        public TextView mainText, subText;

        public OnBoardingSliderViewHolder(@NonNull View itemView) {
            super(itemView);
            mainText = itemView.findViewById(R.id.tv_main);
            subText = itemView.findViewById(R.id.tv_sub);
        }
    }
}
