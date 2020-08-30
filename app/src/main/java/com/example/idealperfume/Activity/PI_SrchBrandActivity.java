package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.idealperfume.Adapter.PI_SearchAdapter;
import com.example.idealperfume.Fragment.PI_PSearchFragment;
import com.example.idealperfume.R;

import org.w3c.dom.Text;

public class PI_SrchBrandActivity extends AppCompatActivity {

    PI_PSearchFragment PI_PSearchFragment;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pi_srch_brand);

        TextView tv_brandName = (TextView) findViewById(R.id.tv_brandName);
        TextView tv_slogan = (TextView) findViewById(R.id.tv_slogan);
//        PI_SearchAdapter PI_SearchAdapter = new PI_SearchAdapter(getSupportFragmentManager());

        PI_PSearchFragment = (PI_PSearchFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_pi_product);
    }
}
