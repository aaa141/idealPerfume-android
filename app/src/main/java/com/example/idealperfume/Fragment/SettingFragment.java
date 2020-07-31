package com.example.idealperfume.Fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.idealperfume.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class SettingFragment extends BottomSheetDialogFragment {
    public SettingFragment () {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_setting_fragment, container, false);
    }
}