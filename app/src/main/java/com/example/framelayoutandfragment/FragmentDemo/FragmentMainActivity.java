package com.example.framelayoutandfragment.FragmentDemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.framelayoutandfragment.R;

public class FragmentMainActivity extends AppCompatActivity {

    LinearLayout lytHome, lytNotification, lytUpdates;
    FrameLayout frame;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);

        lytHome = findViewById(R.id.lytHome);
        lytNotification = findViewById(R.id.lytNotification);
        lytUpdates = findViewById(R.id.lytUpdates);
        frame = findViewById(R.id.frame);

        addFrag(new OneFragment());

        lytHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFrag(new OneFragment());
            }
        });

        lytNotification.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                addFrag(new TwoFragment());
            }
        });

        lytUpdates.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                addFrag(new UpdatesFragment());
            }
        });
    }

    private void addFrag(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.disallowAddToBackStack();
        ft.replace(R.id.frame, fragment, "My_Fragment").commitAllowingStateLoss();
    }


}