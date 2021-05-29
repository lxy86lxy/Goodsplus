package com.example.Goods.activities.baby;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.Goods.R;
import com.example.Goods.string.Strings;
import com.google.android.material.chip.Chip;

public class Body1Fragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View square = inflater.inflate(R.layout.fragment_body1, container, false);
        Chip chip=square.findViewById(R.id.chip2);
        chip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),TiZiActivity.class);
                intent.putExtra(Strings.TIXIID,60);
                startActivity(intent);
            }
        });
        Chip chip3=square.findViewById(R.id.chip3);
        chip3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),TiZiActivity.class);
                intent.putExtra(Strings.TIXIID,169);
                startActivity(intent);
            }
        });
        Chip chip4=square.findViewById(R.id.chip4);
        chip4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),TiZiActivity.class);
                intent.putExtra(Strings.TIXIID,269);
                startActivity(intent);
            }
        });
        Chip chip5=square.findViewById(R.id.chip5);
        chip5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),TiZiActivity.class);
                intent.putExtra(Strings.TIXIID,529);
                startActivity(intent);
            }
        });

        Chip chip12=square.findViewById(R.id.chip12);
        chip12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),TiZiActivity.class);
                intent.putExtra(Strings.TIXIID,10);
                startActivity(intent);
            }
        });
        Chip chip13=square.findViewById(R.id.chip13);
        chip13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),TiZiActivity.class);
                intent.putExtra(Strings.TIXIID,15);
                startActivity(intent);
            }
        });
        Chip chip14=square.findViewById(R.id.chip14);
        chip14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),TiZiActivity.class);
                intent.putExtra(Strings.TIXIID,19);
                startActivity(intent);
            }
        });
        Chip chip15=square.findViewById(R.id.chip15);
        chip15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),TiZiActivity.class);
                intent.putExtra(Strings.TIXIID,40);
                startActivity(intent);
            }
        });
        Chip chip16=square.findViewById(R.id.chip16);
        chip16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),TiZiActivity.class);
                intent.putExtra(Strings.TIXIID,16);
                startActivity(intent);
            }
        });
        Chip chip22=square.findViewById(R.id.chip22);
        chip22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),TiZiActivity.class);
                intent.putExtra(Strings.TIXIID,26);
                startActivity(intent);
            }
        });
        Chip chip23=square.findViewById(R.id.chip23);
        chip23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),TiZiActivity.class);
                intent.putExtra(Strings.TIXIID,121);
                startActivity(intent);
            }
        });
        Chip chip24=square.findViewById(R.id.chip24);
        chip24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),TiZiActivity.class);
                intent.putExtra(Strings.TIXIID,124);
                startActivity(intent);
            }
        });
        Chip chip25=square.findViewById(R.id.chip25);
        chip25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),TiZiActivity.class);
                intent.putExtra(Strings.TIXIID,259);
                startActivity(intent);
            }
        });
        Chip chip32=square.findViewById(R.id.chip32);
        chip32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),TiZiActivity.class);
                intent.putExtra(Strings.TIXIID,91);
                startActivity(intent);
            }
        });
        Chip chip33=square.findViewById(R.id.chip33);
        chip33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),TiZiActivity.class);
                intent.putExtra(Strings.TIXIID,188);
                startActivity(intent);
            }
        });
        Chip chip34=square.findViewById(R.id.chip34);
        chip34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),TiZiActivity.class);
                intent.putExtra(Strings.TIXIID,92);
                startActivity(intent);
            }
        });
        Chip chip35=square.findViewById(R.id.chip35);
        chip35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),TiZiActivity.class);
                intent.putExtra(Strings.TIXIID,238);
                startActivity(intent);
            }
        });


        return square;
    }
}