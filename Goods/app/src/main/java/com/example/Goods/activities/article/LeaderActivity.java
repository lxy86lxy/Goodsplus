package com.example.Goods.activities.article;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.Goods.adapter.LeaderAdapter;
import com.example.Goods.R;
import com.example.Goods.classes.Leader;
import com.example.Goods.classes.LeaderB;
import com.example.Goods.classes.RecyclerViewOnScrollListener;
import com.example.Goods.string.Strings;
import com.example.Goods.util.HttpBack;
import com.example.Goods.util.HttpUtil;
import com.example.Goods.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class LeaderActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LeaderAdapter liuAdapter;
    static int count=1;
    private String address;
    private List<LeaderB> leaderListB = new ArrayList<>();
    private List<Leader>leaderList=new ArrayList<>();
    SwipeRefreshLayout swipeRefreshLayout;
    int x;
    LinearLayoutManager linearLayoutManager;
    private RecyclerViewOnScrollListener.UpPullOnScrollListener onScrollListener=new RecyclerViewOnScrollListener.UpPullOnScrollListener() {
        //上拉
        @Override
        public void onLoadMore() {
            count++;

            updateList1();

        }
        //下拉
        @SuppressLint("ResourceAsColor")
        @Override
        public void onRefresh() {
            count++;

            swipeRefreshLayout.setEnabled(true);
            //加颜色
            swipeRefreshLayout.setColorSchemeColors(R.color.teal_700,R.color.teal_200);
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            leaderListB.clear();
                            updateList();
                            swipeRefreshLayout.setRefreshing(false);
                            Toast.makeText(LeaderActivity.this,"刷新成功！",Toast.LENGTH_SHORT).show();
                        }
                    },2000);
                }
            });

        }
    };
//    private Handler handler = new Handler() {
//        @SuppressLint("HandlerLeak")
//        @Override
//        public void handleMessage(@NonNull Message msg) {
//            super.handleMessage(msg);
//            if (msg.what == 123) {
//                Bundle bundle = msg.getData();
//                String response = bundle.getString(Strings.JSON_DATA);
//                leaderList = new JsonUtil().JsonLeader(response);
//                for (int i = 0; i < leaderList.size(); i++) {
//                   LeaderB massage = new LeaderB(leaderList.get(i).getAuthor(), leaderList.get(i).getNiceDate(),leaderList.get(i).getTitle(),leaderList.get(i).getDesc(),leaderList.get(i).getEnvelopePic(), leaderList.get(i).getLink());
//                    Log.d("Json123", "Massage id is " + massage.getId());
//                    leaderListB.add(massage);
//                }
//                Log.d("JsonLeader123", "请求成功");
//
//                Log.d("Json123456",leaderList.get(0).getLink());//没问题
//                liuAdapter.notifyDataSetChanged();
//                recyclerView.setAdapter(liuAdapter);
//            }
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader);
        recyclerView = findViewById(R.id.recycle_view22);
        recyclerView.addOnScrollListener(new RecyclerViewOnScrollListener(onScrollListener));
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        updateList();
        liuAdapter = new LeaderAdapter(leaderListB);
        recyclerView.setAdapter(liuAdapter);
        swipeRefreshLayout=findViewById(R.id.refresh_layout_leader);
    }

    //    获取链接中的json
    private void updateList() {

        address = Strings.PROJECT+count+Strings.PROJECT_JSON;
        new HttpUtil().sendHttpRequest(address, new HttpBack() {
            @Override
            public void onFinish(String response) {
//                Message message = new Message();
//                message.what = 123;
//                Bundle bundle = new Bundle();
//                bundle.putString(Strings.JSON_DATA, response);
//                message.setData(bundle);
//                handler.sendMessage(message);
                leaderList = new JsonUtil().JsonLeader(response);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < leaderList.size(); i++) {
                            LeaderB massage = new LeaderB(leaderList.get(i).getAuthor(), leaderList.get(i).getNiceDate(),leaderList.get(i).getTitle(),leaderList.get(i).getDesc(),leaderList.get(i).getEnvelopePic(), leaderList.get(i).getLink());
                            Log.d("Json123", "Massage id is " + massage.getId());
                            leaderListB.add(massage);
                        }
                        Log.d("Json123456",leaderList.get(0).getLink());//没问题
                        liuAdapter.notifyDataSetChanged();
                        recyclerView.setAdapter(liuAdapter);
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
    private void updateList1() {

        address = Strings.PROJECT+count+Strings.PROJECT_JSON;
        new HttpUtil().sendHttpRequest(address, new HttpBack() {
            @Override
            public void onFinish(String response) {
//                Message message = new Message();
//                message.what = 123;
//                Bundle bundle = new Bundle();
//                bundle.putString(Strings.JSON_DATA, response);
//                message.setData(bundle);
//                handler.sendMessage(message);
                leaderList = new JsonUtil().JsonLeader(response);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < leaderList.size(); i++) {
                            LeaderB massage = new LeaderB(leaderList.get(i).getAuthor(), leaderList.get(i).getNiceDate(),leaderList.get(i).getTitle(),leaderList.get(i).getDesc(),leaderList.get(i).getEnvelopePic(), leaderList.get(i).getLink());
                            Log.d("Json123", "Massage id is " + massage.getId());
                            leaderListB.add(massage);
                        }
                        Log.d("JsonLeader123", "请求成功");

                        Log.d("Json123456",leaderList.get(0).getLink());//没问题
                        x=linearLayoutManager.findLastCompletelyVisibleItemPosition();
                        liuAdapter.notifyDataSetChanged();
                        recyclerView.setAdapter(liuAdapter);
                        recyclerView.scrollToPosition(x);
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