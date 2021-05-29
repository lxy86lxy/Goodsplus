package com.example.Goods.activities.article;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.Goods.adapter.TagsAdapter;
import com.example.Goods.R;
import com.example.Goods.classes.Massage;
import com.example.Goods.classes.Passage;
import com.example.Goods.string.Strings;
import com.example.Goods.util.HttpBack;
import com.example.Goods.util.HttpUtil;
import com.example.Goods.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class TagActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TagsAdapter doodsAdapter;
    private String address;
    private List<Massage> massageList=new ArrayList<>();
    private List<Passage> passageArrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag);
        recyclerView=findViewById(R.id.recycle_view4);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        updateList();
        doodsAdapter=new TagsAdapter(massageList);
        recyclerView.setAdapter(doodsAdapter);
    }
    private void updateList() {
          Intent intent=getIntent();
          String url=intent.getStringExtra(Strings.JSON_LINK);
        address = Strings.TAGS+url+Strings.JSON;
        new HttpUtil().sendHttpRequest(address, new HttpBack() {
            @Override
            public void onFinish(String response) {
                passageArrayList=new JsonUtil().JsonPassage(response);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < passageArrayList.size(); i++) {
                            Massage massage = new Massage(passageArrayList.get(i).getTitle(), passageArrayList.get(i).getAuthor(), R.drawable.gongz,passageArrayList.get(i).getNiceDate(), passageArrayList.get(i).getChapterName(),passageArrayList.get(i).getTags(),passageArrayList.get(i).getLink());
                            Log.d("Json123", "Massage id is " + massage.getId());
                            massageList.add(massage);
                            Log.d("Json1234", "Massage id is " + massageList.get(i).getId());
                        }
                        Log.d(Strings.TAG, "handler title is" + massageList.get(0).getName());
                        doodsAdapter.notifyDataSetChanged();
                        recyclerView.setAdapter(doodsAdapter);
                    }
                });
            }

            @Override
            public void onError(Exception e) {
                Log.d(Strings.TAG, "请求失败");
                e.printStackTrace();
            }
        });
    }
}