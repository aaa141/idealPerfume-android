package com.example.idealperfume.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.idealperfume.Fragment.MyPickFragment1;
import com.example.idealperfume.Fragment.MyPickFragment2;
import com.example.idealperfume.Fragment.Ranking_10sFragment;

import java.util.ArrayList;

public class MainRankingAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> items;
    private ArrayList<String> item = new ArrayList<String>();;

    public MainRankingAdapter(@NonNull FragmentManager fm) {
        super(fm);
        items = new ArrayList<>();
        items.add(new Ranking_10sFragment());

        item.add("10대");
        item.add("20대");
        item.add("30대");
        item.add("40대 이상");
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return item.get(position);
    }
}
