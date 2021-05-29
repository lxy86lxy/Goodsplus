package com.example.Goods.activities.baby;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.Goods.adapter.DoodsAdapter;
import com.example.Goods.R;
import com.example.Goods.classes.Massage;
import com.example.Goods.classes.Passage;
import com.example.Goods.string.Strings;
import com.example.Goods.util.HttpBack;
import com.example.Goods.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

public class LeaderDActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DoodsAdapter doodsAdapter;
    private int id;
    private String address;
    private List<Massage> massageList=new ArrayList<>();
    private List<Passage> passageArrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_dactivity);
        recyclerView=findViewById(R.id.recycle_view6);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        updateList();
        doodsAdapter=new DoodsAdapter(massageList);
        recyclerView.setAdapter(doodsAdapter);
    }
    private void updateList() {
        Intent intent=getIntent();
        id=intent.getIntExtra(Strings.TIXIID,60);
        address = Strings.LEADER_DAO;
        //重写解析
        new HttpUtil().sendHttpRequest(address, new HttpBack() {
            @Override
            public void onFinish(String response) {
//                passageArrayList=new JsonUtil().JsonPassage(response);重来
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < passageArrayList.size(); i++) {
                            Massage massage = new Massage(passageArrayList.get(i).getTitle(), passageArrayList.get(i).getAuthor(), R.drawable.hu,passageArrayList.get(i).getNiceDate(), passageArrayList.get(i).getChapterName(),passageArrayList.get(i).getTags(),passageArrayList.get(i).getLink());
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