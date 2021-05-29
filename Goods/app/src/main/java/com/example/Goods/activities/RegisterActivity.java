package com.example.Goods.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.Goods.R;
import com.example.Goods.classes.Data;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button register=findViewById(R.id.bin_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data.getInstance().register(((EditText)findViewById(R.id.r_id)).getText().toString(),((EditText)findViewById(R.id.r_password)).getText().toString());
                Intent intend=new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intend);
                Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}