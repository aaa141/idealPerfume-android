package com.example.idealperfume.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.idealperfume.Fragment.MyPickFragment1;
import com.example.idealperfume.Fragment.MyPickFragment2;

import java.util.ArrayList;

public class MyPickAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> items;
    private ArrayList<String> menus = new ArrayList<String>();

    public MyPickAdapter(@NonNull FragmentManager fm) {
        super(fm);
        items = new ArrayList<>();
        items.add(new MyPickFragment1());
        items.add(new MyPickFragment2());

        menus.add("제품픽");
        menus.add("브랜드픽");
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
        return menus.get(position);
    }
}
