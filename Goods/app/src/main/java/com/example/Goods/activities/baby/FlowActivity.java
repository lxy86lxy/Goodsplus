package com.example.Goods.activities.baby;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.Goods.R;
import com.google.android.material.chip.Chip;

import java.util.ArrayList;
import java.util.List;

public class FlowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow);
        FlowLayout mFlowLayout=findViewById(R.id.mFlowLayout);
        List<String>list=new ArrayList<>();
        list.add("java5");
        list.add("java1");
        list.add("java2");
        list.add("java3");
        list.add("java4");
        for (int i = 0; i < list.size(); i++) {
            View inflate= LayoutInflater.from(this).inflate(R.layout.flowww,null);
            Chip chip=inflate.findViewById(R.id.Flow_chip2);
            chip.setText(list.get(i));
            mFlowLayout.addView(inflate);
        }
    }
}