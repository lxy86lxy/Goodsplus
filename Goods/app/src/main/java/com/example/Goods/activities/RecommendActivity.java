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

import com.example.Goods.adapter.BoardAdapter;
import com.example.Goods.R;
import com.example.Goods.activities.baby.TiActivity;
import com.example.Goods.classes.BoardGame;
import com.example.Goods.classes.Question;
import com.example.Goods.classes.RecyclerViewOnScrollListener;
import com.example.Goods.string.Strings;
import com.example.Goods.util.HttpBack;
import com.example.Goods.util.HttpUtil;
import com.example.Goods.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class RecommendActivity extends AppCompatActivity {
    String address;
    ListView listView;
    RecyclerView recyclerView1;
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
                            Toast.makeText(RecommendActivity.this,"刷新成功！",Toast.LENGTH_SHORT).show();
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
//            if (msg.what == 123) {
//                Bundle bundle = msg.getData();
//                String response = bundle.getString(Strings.JSON_DATA);
//                Log.d(Strings.TAG, "请求成功");
//                //没有登录，使用sp来本地永久保存
//
//                    questionArrayList = new JsonUtil().JsonQuestion(response);
////                Log.d("Json","title123 is  "+passageArrayList.get(0).getTitle());成功
//                    for (int i = 0; i < questionArrayList.size(); i++) {
//                       BoardGame boardGame = new BoardGame(questionArrayList.get(i).getTitle(),  R.drawable.reading,questionArrayList.get(i).getNiceDate(),questionArrayList.get(i).getDesc().replace("\n","").substring(0,60)+"...", questionArrayList.get(i).getLink());
//                           boardGameList.add(boardGame);
//                    }
//
//                }
//                boardAdapter.notifyDataSetChanged();
//                listView.setAdapter(boardAdapter);
//
//        }
//    };
LinearLayoutManager linearLayoutManager1;
    private List<BoardGame> boardGameList = new ArrayList<>();
    private ArrayList<Question> questionArrayList = new ArrayList<>();
   BoardAdapter boardAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);
//        boardAdapter = new BoardAdapter(RecommendActivity.this, R.layout.question_item, boardGameList);
//        updateList();
//        listView = findViewById(R.id.list_2);
////        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
//        listView.setAdapter(boardAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                BoardGame boardGame = boardGameList.get(position);
//                //返回这个位子的名字
////                Toast.makeText(ListActivity.this, boardGame.getName(), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(RecommendActivity.this, Massages_1_Activity.class);
//                intent.putExtra(Strings.JSON_LINK,boardGame.getLink());
//                startActivity(intent);
//                boardAdapter.notifyDataSetChanged();
//            }
//        });
        recyclerView1=findViewById(R.id.list_12);
        recyclerView1.addOnScrollListener(new RecyclerViewOnScrollListener(onScrollListener));
         linearLayoutManager1=new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(linearLayoutManager1);
        updateList();
        boardAdapter=new BoardAdapter(boardGameList);
        recyclerView1.setAdapter(boardAdapter);
        recyclerView1.setFocusableInTouchMode(false);
        swipeRefreshLayout=findViewById(R.id.refresh_layout2);
        RadioButton button = findViewById(R.id.List_radioButton11);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecommendActivity.this, My_characteristicActivity.class);
                startActivity(intent);
            }
        });
        RadioButton button1=findViewById(R.id.List_Guang_radioButton10);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecommendActivity.this, SquareActivity.class);
                startActivity(intent);
            }
        });
        RadioButton button2=findViewById(R.id.List_radioButton8);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecommendActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
        RadioButton radioButton2=findViewById(R.id.List_radioButton123);
        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecommendActivity.this, TiActivity.class);
                startActivity(intent);
            }
        });
        RadioButton button3=findViewById(R.id.List_radioButton9);
        RadioButton[] rbs = new RadioButton[5];
        rbs[0]=button;
        rbs[1]=button1;
        rbs[2]=button2;
        rbs[3]=button3;
        rbs[4]=radioButton2;

        for (RadioButton rb : rbs) {
            Resources res = RecommendActivity.this.getResources();
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
//     fun(button3);
    }

//    public void fun(RadioButton button3){
//        Resources res = RecommendActivity.this.getResources();
//        Drawable myImage = res.getDrawable(R.drawable.girl1);
//        myImage.setBounds(1, 1, 100, 100);
//        button3.setCompoundDrawables(null, myImage, null, null);
//        //挨着给每个RadioButton加入drawable限制边距以控制显示大小
//        Drawable[] drawables = button3.getCompoundDrawables();
//        //获取drawables
//        Rect r = new Rect(0, 0, drawables[1].getMinimumWidth()*2/3, drawables[1].getMinimumHeight()*2/3);
//        //定义一个Rect边界
//        drawables[1].setBounds(r);
//        //添加限制给控件
//        button3.setCompoundDrawables(null,drawables[1],null,null);
//    }
    private void updateList() {

        address = Strings.QUESTION+count+Strings.JSON;
        new HttpUtil().sendHttpRequest(address, new HttpBack() {
            @Override
            public void onFinish(String response) {
//                Message message=new Message();
//                message.what=123;
//                Bundle bundle=new Bundle();
//                bundle.putString(Strings.JSON_DATA,response);
//                message.setData(bundle);
//                handler.sendMessage(message);

                questionArrayList = new JsonUtil().JsonQuestion(response);
//                Log.d("Json","title123 is  "+passageArrayList.get(0).getTitle());成功
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < questionArrayList.size(); i++) {
                            BoardGame boardGame = new BoardGame(questionArrayList.get(i).getTitle(),  R.drawable.reading,questionArrayList.get(i).getNiceDate(),questionArrayList.get(i).getDesc().replace("\n","").substring(0,60)+"...", questionArrayList.get(i).getLink());
                            boardGameList.add(boardGame);
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

        address = Strings.QUESTION+count+Strings.JSON;
        new HttpUtil().sendHttpRequest(address, new HttpBack() {
            @Override
            public void onFinish(String response) {
//                Message message=new Message();
//                message.what=123;
//                Bundle bundle=new Bundle();
//                bundle.putString(Strings.JSON_DATA,response);
//                message.setData(bundle);
//                handler.sendMessage(message);

                questionArrayList = new JsonUtil().JsonQuestion(response);
//                Log.d("Json","title123 is  "+passageArrayList.get(0).getTitle());成功
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < questionArrayList.size(); i++) {
                            BoardGame boardGame = new BoardGame(questionArrayList.get(i).getTitle(),  R.drawable.reading,questionArrayList.get(i).getNiceDate(),questionArrayList.get(i).getDesc().replace("\n","").substring(0,60)+"...", questionArrayList.get(i).getLink());
                            boardGameList.add(boardGame);
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