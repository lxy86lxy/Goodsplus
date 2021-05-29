package com.example.Goods.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Goods.R;
import com.example.Goods.classes.Data;
import com.example.Goods.string.Strings;
import com.example.Goods.util.HttpBack;
import com.example.Goods.util.HttpUtil;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {
    SharedPreferences.Editor editor;
    SharedPreferences.Editor editor1;
    SharedPreferences sharedPreferences;
    SharedPreferences sharedPreferences1;
    CheckBox checkBox;
    EditText editText;
    EditText editText1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Data.getInstance().Data("lxy", "020806");
        setContentView(R.layout.activity_login);
        TextView register = findViewById(R.id.xv_zhuce);
        sharedPreferences = getSharedPreferences("mmmmm", MODE_PRIVATE);
        editText = findViewById(R.id.l_password);
        editText1 = findViewById(R.id.l_id);
        checkBox = findViewById(R.id.l_checkBox);
        //保存输入的上一次登录的账号密码
        boolean isRemember = sharedPreferences.getBoolean("l_checkbox", false);
        if (isRemember) {
            //将账号和密码设置到文本框
            String name = sharedPreferences.getString("name", "");
            String password = sharedPreferences.getString("password", "");
            editText.setText(name);
            editText1.setText(password);
            checkBox.setChecked(true);
        }

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intend = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intend);
            }
        });
        Button login = findViewById(R.id.login);
        //主观显现密码操作
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                String password = editText1.getText().toString();
                if (Data.getInstance().login(((EditText) findViewById(R.id.l_id)).getText().toString(), ((EditText) findViewById(R.id.l_password)).getText().toString())) {
//登录请求
    sharedPreferences1 = getSharedPreferences("Login", MODE_PRIVATE);//储存用户信息
    HashMap<String, String> map = new HashMap<>();
    map.put("username", "lxy");
    map.put("password", "020806");
    new HttpUtil().sendPostNetRequest(Strings.LOGIN, map, new HttpBack() {
        @Override
        public void onFinish(String response) {
            Log.d("Login","登陆成功");

//            editor1 = sharedPreferences1.edit();
//            editor1.putString("LoginDate",response);
//            editor1.apply();
        }

        @Override
        public void onError(Exception e) {
                e.printStackTrace();
        }
    });
                    editor = sharedPreferences.edit();
                    if (checkBox.isChecked()) {//检查是否选中
                        editor.putBoolean("l_checkbox", true);
                        editor.putString("name", name);
                        editor.putString("password", password);
                    } else {
                        editor.clear();
                    }
                    editor.apply();
                    Intent intend = new Intent(LoginActivity.this, ListActivity.class);
                    startActivity(intend);
                    Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
                }
            }
        });

        intiView();
    }
//密码的显示
    private void intiView() {
        final EditText editText = findViewById(R.id.l_password);
        final CheckBox checkBox = findViewById(R.id.l_checkbox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                editText.setSelection(editText.length());

            }

        });
    }
}