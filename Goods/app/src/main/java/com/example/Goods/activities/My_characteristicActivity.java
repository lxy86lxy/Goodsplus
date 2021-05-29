package com.example.Goods.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.Goods.R;
import com.example.Goods.activities.baby.TiActivity;

public class My_characteristicActivity extends AppCompatActivity {
    Button buttonCollect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_characteristic);
        buttonCollect=findViewById(R.id.Collect_textView6);
        buttonCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(My_characteristicActivity.this,CollectActivity.class);
                startActivity(intent);
            }
        });
        RadioButton button = findViewById(R.id.List_radioButton8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(My_characteristicActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
        RadioButton button1=findViewById(R.id.List_Guang_radioButton10);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(My_characteristicActivity.this, SquareActivity.class);
                startActivity(intent);
            }
        });
      RadioButton button2=findViewById(R.id.List_radioButton9);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(My_characteristicActivity.this, RecommendActivity.class);
                startActivity(intent);
            }
        });
        RadioButton radioButton2=findViewById(R.id.List_radioButton123);
        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(My_characteristicActivity.this, TiActivity.class);
                startActivity(intent);
            }
        });
        RadioButton button3=findViewById(R.id.List_radioButton11);
        RadioButton[] rbs = new RadioButton[5];
        rbs[0]=button;
        rbs[1]=button1;
        rbs[2]=button2;
        rbs[3]=button3;
        rbs[4]=radioButton2;

        for (RadioButton rb : rbs) {
            Resources res = My_characteristicActivity.this.getResources();
            Drawable myImage = res.getDrawable(R.drawable.girl);
            myImage.setBounds(1, 1, 100, 100);
            rb.setCompoundDrawables(null, myImage, null, null);
            //挨着给每个RadioButton加入drawable限制边距以控制显示大小
            Drawable[] drawables = rb.getCompoundDrawables();
            //获取drawables
            Rect r = new Rect(0, 0, drawables[1].getMinimumWidth()*2/3, drawables[1].getMinimumHeight()*2/3);
            //定义一个Rect边界
            drawables[1].setBounds(r);
            //添加限制给控件
            rb.setCompoundDrawables(null,drawables[1],null,null);
        }
    }
}