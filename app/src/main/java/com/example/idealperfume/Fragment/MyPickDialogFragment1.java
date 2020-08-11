package com.example.idealperfume.Fragment;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.idealperfume.Adapter.MyPickAdapter;
import com.example.idealperfume.Adapter.MyPickProductAdapter;
import com.example.idealperfume.Data.MyPickData;
import com.example.idealperfume.R;

import java.util.ArrayList;
import java.util.List;

public class MyPickDialogFragment1 extends DialogFragment {

    private static final String TAG = "MyPickDialog1";

    public interface OnInputSelected{
        void sendInput(String input);
    }

    public OnInputSelected mOnInputSelected;

    //widgets
    private EditText et_foldername;
    private Button btn_cancel, btn_make;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_make_forder, container, false);

        Dialog dialog = getDialog();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // 모서리 투명하게
        dialog.setCanceledOnTouchOutside(false);
        btn_cancel = view.findViewById(R.id.btn_cancle);
        btn_make = view.findViewById(R.id.btn_make);
        et_foldername= view.findViewById(R.id.et_fordername);

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        btn_make.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String foldername = et_foldername.getText().toString();

                if(foldername.equals("")) {
                    Toast.makeText(getActivity(), "폴더명을 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else if(!foldername.equals("")){
//                    mOnInputSelected.sendInput(foldername);
                    MyPickDialogFragment2 dialog = new MyPickDialogFragment2();
                    dialog.setTargetFragment(MyPickDialogFragment1.this, 1);
                    dialog.show(getFragmentManager(), "MyPickDialog2");
                    getDialog().dismiss();
                    Toast.makeText(getActivity(), foldername+"만들었음", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mOnInputSelected = (OnInputSelected) getTargetFragment();
        }catch (ClassCastException e){
            Log.e(TAG, "onAttach: ClassCastException : " + e.getMessage() );
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        int dialogWidth = getResources().getDimensionPixelSize(R.dimen.mypick_dialog_width);
        int dialogHeight = ActionBar.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setLayout(dialogWidth, dialogHeight);
    }
}


