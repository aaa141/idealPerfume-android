package com.example.idealperfume.Fragment;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.idealperfume.Adapter.MyPickProductAdapter;
import com.example.idealperfume.Data.MyPickData;
import com.example.idealperfume.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MyPickDialogFragment1 extends DialogFragment {

    private static final String TAG = "MyPickDialog1";

    List<MyPickData> listpickdata = new ArrayList<>();

    public interface OnInputSelected{
        void sendInput(String input);
    }

    public OnInputSelected mOnInputSelected;

    MyPickProductAdapter myPickProductAdapter;

    //widgets
    private EditText et_foldername;
    private Button btn_cancel, btn_make;


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, final Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.dialog_make_forder, container, false);

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

                myPickProductAdapter = new MyPickProductAdapter(getContext(),listpickdata);

                Date today = Calendar.getInstance().getTime();
                String date_today = new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault()).format(today);

                if(foldername.equals("")) {
                    Toast.makeText(getActivity(), "폴더명을 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else if(!foldername.equals("")){
                    MyPickDialogFragment2 dialog = new MyPickDialogFragment2();
                    dialog.setTargetFragment(MyPickDialogFragment1.this, 1);
                    dialog.show(getFragmentManager(), "MyPickDialog2");
                    getDialog().dismiss();

                    MyPickFragment1 myPickFragment1 = new MyPickFragment1();
                    Bundle bundle = new Bundle();
                    bundle.putString("foldername", foldername);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    MyPickFragment1 fragment1 = new MyPickFragment1();
                    fragment1.setArguments(bundle);
                    transaction.replace(R.id.frame_mypick, fragment1);
                    transaction.commit();
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


