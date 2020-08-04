package com.example.idealperfume.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.idealperfume.Fragment.PI_BSearchFragment;
import com.example.idealperfume.Fragment.PI_PSearchFragment;

import java.util.ArrayList;

public class PI_SearchAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> items;
    private ArrayList<String> menus = new ArrayList<>();

    public PI_SearchAdapter(@NonNull FragmentManager fm) {
        super(fm);
        items = new ArrayList<>();
        items.add(new PI_PSearchFragment());
        items.add(new PI_BSearchFragment());

        menus.add("제품");
        menus.add("브랜드");
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

