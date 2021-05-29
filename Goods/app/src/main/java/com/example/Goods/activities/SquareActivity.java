package com.example.Goods.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.Goods.adapter.DoodsAdapter;
import com.example.Goods.R;
import com.example.Goods.activities.baby.TiActivity;
import com.example.Goods.classes.Massage;
import com.example.Goods.classes.Passage;
import com.example.Goods.classes.RecyclerViewOnScrollListener;
import com.example.Goods.string.Strings;
import com.example.Goods.util.HttpBack;
import com.example.Goods.util.HttpUtil;
import com.example.Goods.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class SquareActivity extends AppCompatActivity {
    String address;
    ListView listView;
    RecyclerView recyclerView1;
    private List<Massage> boardGameList = new ArrayList<>();
    private ArrayList<Passage> passageArrayList = new ArrayList<>();
    DoodsAdapter boardAdapter;
    SwipeRefreshLayout swipeRefreshLayout;
    static int count=0;
    int x;
    private RecyclerViewOnScrollListener.UpPullOnScrollListener onScrollListener=new RecyclerViewOnScrollListener.UpPullOnScrollListener() {
        //上拉
        @Override
        public void onLoadMore() {
            count++;
            updateList();
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
                            boardGameList.clear();
                            updateList1();
                            swipeRefreshLayout.setRefreshing(false);
                            Toast.makeText(SquareActivity.this,"刷新成功！",Toast.LENGTH_SHORT).show();
                        }
                    },2000);
                }
            });

        }
    };
//    private Handler handler=new Handler() {
//        @SuppressLint("HandlerLeak")
//        @Override
//        public void handleMessage(@NonNull Message msg) {
//            super.handleMessage(msg);
//            if(msg.what==111){
//                Bundle bundle=msg.getData();
//                String response=bundle.getString(Strings.JSON_SQUARE);
//                Log.d(Strings.TAG, "请求成功");
//                passageArrayList = new JsonUtil().JsonPassage(response);
//                for (int i = 0; i < passageArrayList.size(); i++) {
//                    Massage massage = new Massage(passageArrayList.get(i).getTitle(), passageArrayList.get(i).getAuthor(), R.drawable.guang,passageArrayList.get(i).getNiceDate(),passageArrayList.get(i).getChapterName(),passageArrayList.get(i).getLink());
//                    boardGameList.add(massage);
//                }
//                boardAdapter.notifyDataSetChanged();
//                recyclerView1.setAdapter(boardAdapter);
//            }
//        }
//    };
LinearLayoutManager linearLayoutManager1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);
//        updateList();
//        boardAdapter = new DoodsAdapter(SquareActivity.this, R.layout.boardgame_item, boardGameList);
//        listView = findViewById(R.id.list_3);
//        listView.setAdapter(boardAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Massage boardGame = boardGameList.get(position);
//                Intent intent = new Intent(SquareActivity.this, Massages_1_Activity.class);
//                intent.putExtra(Strings.JSON_LINK,boardGame.getLink());
//                startActivity(intent);
//            }
//        });
        recyclerView1=findViewById(R.id.list_3);
        recyclerView1.addOnScrollListener(new RecyclerViewOnScrollListener(onScrollListener));
        swipeRefreshLayout=findViewById(R.id.refresh_layout1);
        linearLayoutManager1=new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(linearLayoutManager1);
        updateList();
        boardAdapter=new DoodsAdapter(boardGameList);
        recyclerView1.setAdapter(boardAdapter);

        RadioButton button = findViewById(R.id.List_radioButton11);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SquareActivity.this, My_characteristicActivity.class);
                startActivity(intent);
            }
        });
        RadioButton button1=findViewById(R.id.List_radioButton8);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SquareActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
       RadioButton button2=findViewById(R.id.List_radioButton9);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SquareActivity.this, RecommendActivity.class);
                startActivity(intent);
            }
        });
        RadioButton radioButton2=findViewById(R.id.List_radioButton123);
        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SquareActivity.this, TiActivity.class);
                startActivity(intent);
            }
        });
        RadioButton button3=findViewById(R.id.List_Guang_radioButton10);
        RadioButton[] rbs = new RadioButton[5];
        rbs[0]=button;
        rbs[1]=button1;
        rbs[2]=button2;
        rbs[3]=button3;
        rbs[4]=radioButton2;

        for (RadioButton rb : rbs) {
            Resources res = SquareActivity.this.getResources();
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
    private void updateList() {

        address = Strings.SQUARE+String.valueOf(count)+Strings.JSON;
        new HttpUtil().sendHttpRequest(address, new HttpBack() {
            @Override
            public void onFinish(String response) {
//                Message message=new Message();
//                message.what=111;
//                Bundle bundle=new Bundle();
//                bundle.putString(Strings.JSON_SQUARE,response);
//                message.setData(bundle);
//                handler.sendMessage(message);
                passageArrayList = new JsonUtil().JsonPassage(response);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < passageArrayList.size(); i++) {
                            Massage massage = new Massage(passageArrayList.get(i).getTitle(), passageArrayList.get(i).getAuthor(), R.drawable.guang,passageArrayList.get(i).getNiceDate(),passageArrayList.get(i).getChapterName(),passageArrayList.get(i).getTags(),passageArrayList.get(i).getLink());
                            boardGameList.add(massage);
                        }
                        x=linearLayoutManager1.findLastCompletelyVisibleItemPosition();
                        boardAdapter.notifyDataSetChanged();
                        recyclerView1.setAdapter(boardAdapter);
                        recyclerView1.scrollToPosition(x);
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

        address = Strings.SQUARE+String.valueOf(count)+Strings.JSON;
        new HttpUtil().sendHttpRequest(address, new HttpBack() {
            @Override
            public void onFinish(String response) {
//                Message message=new Message();
//                message.what=111;
//                Bundle bundle=new Bundle();
//                bundle.putString(Strings.JSON_SQUARE,response);
//                message.setData(bundle);
//                handler.sendMessage(message);
                passageArrayList = new JsonUtil().JsonPassage(response);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < passageArrayList.size(); i++) {
                            Massage massage = new Massage(passageArrayList.get(i).getTitle(), passageArrayList.get(i).getAuthor(), R.drawable.guang,passageArrayList.get(i).getNiceDate(),passageArrayList.get(i).getChapterName(),passageArrayList.get(i).getTags(),passageArrayList.get(i).getLink());
                            boardGameList.add(massage);
                        }

                        boardAdapter.notifyDataSetChanged();
                        recyclerView1.setAdapter(boardAdapter);

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
