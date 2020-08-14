package com.example.idealperfume.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.idealperfume.Fragment.PI_PSearchFragment;
import com.example.idealperfume.Fragment.RatingFragment;
import com.example.idealperfume.Fragment.ReviewFragment;
import com.example.idealperfume.R;

public class ReviewActivity extends AppCompatActivity {
    ReviewFragment ReviewFragment;
    RatingFragment RatingFragment;
    LinearLayout btn_filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        btn_filter = findViewById(R.id.btn_filter);
        btn_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ReviewFilterActivity.class);
                startActivity(intent);
            }
        });

        ReviewFragment = (ReviewFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_review);
        RatingFragment = (RatingFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_starRating);

    }
}
