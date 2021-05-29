package com.example.Goods.activities.article;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.Goods.R;
import com.example.Goods.classes.Massage;
import com.example.Goods.classes.Passage;
import com.example.Goods.string.Strings;
import com.example.Goods.util.HttpBack;
import com.example.Goods.util.HttpUtil;
import com.example.Goods.util.JsonUtil;

import java.util.ArrayList;

public class Massages_1_Activity extends AppCompatActivity {
    String address;
    WebView webView;
    ArrayList<Passage>passageArrayList;
//    private Handler handler=new Handler(){
//        @SuppressLint("HandlerLeak")
//        @Override
//        public void handleMessage(@NonNull Message msg) {
//            super.handleMessage(msg);
//          if(msg.what==1){
//              Bundle bundle=msg.getData();
//              String response=bundle.getString(Strings.JSON_DATA_WEB);
//              Log.d(Strings.TAG, "请求成功");
//              passageArrayList = new JsonUtil().JsonPassage(response);
//
//          }
//
//            webView.loadUrl(passageArrayList.get(0).getLink());
//          }
//
//    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_massages_1_);
        webView=findViewById(R.id.m1_web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        Intent intent=getIntent();
        String link=intent.getStringExtra(Strings.JSON_LINK);
        webView.loadUrl(link);
//        webView.loadUrl("http://www.baidu.com");
//        fun();
    }
    //获取对象里面的link属性
//    private void fun(){
//        address="https://www.wanandroid.com/article/list/0/json";
//        new HttpUtil().sendHttpRequest(address, new HttpBack() {
//            @Override
//            public void onFinish(String response) {
//                Message message=new Message();
//                message.what=1;
//                Bundle bundle=new Bundle();
//                bundle.putString(Strings.JSON_DATA_WEB,response);
//                message.setData(bundle);
//                handler.sendMessage(message);
//            }
//
//            @Override
//            public void onError(Exception e) {
//
//            }
//        });
//    }
}