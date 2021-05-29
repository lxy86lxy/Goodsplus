package com.example.Goods.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.Goods.adapter.BannerAdapter;
import com.example.Goods.R;
import com.example.Goods.adapter.DoodsAdapter;
import com.example.Goods.activities.baby.TiActivity;
import com.example.Goods.activities.article.LeaderActivity;
import com.example.Goods.activities.article.SelectActivity;
import com.example.Goods.classes.Banner;
import com.example.Goods.classes.BannerRecycle;
import com.example.Goods.classes.Massage;
import com.example.Goods.classes.Passage;
import com.example.Goods.classes.RecyclerViewOnScrollListener;
import com.example.Goods.string.Strings;
import com.example.Goods.util.HttpBack;
import com.example.Goods.util.HttpUtil;
import com.example.Goods.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ListActivity extends AppCompatActivity {
    String address;
    String address1;
    RadioButton radioButton;
    EditText editText;
    Button buttonList;
    ListView listView;
    RecyclerView recyclerView;
    RecyclerView recyclerView1;
    BannerAdapter liuAdapter;
    SwipeRefreshLayout swipeRefreshLayout;
    static int count=0;
    int x;
    static int y;
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
                          Toast.makeText(ListActivity.this,"刷新成功！",Toast.LENGTH_SHORT).show();
                        }
                    },2000);
                }
            });

        }
    };
    //    private Handler handler=new Handler(new Handler.Callback() {
//        @Override
//        public boolean handleMessage(@NonNull Message msg) {
//            return false;
//        }
//    });
    private List<Massage> boardGameList = new ArrayList<>();
    private List<BannerRecycle>bannerRecycleList=new ArrayList<>();
    private ArrayList<Passage> passageArrayList = new ArrayList<>();
    private ArrayList<Banner> bannerArrayList= new ArrayList<>();
    DoodsAdapter boardAdapter;
    //会内存泄露
//    private Handler handler=new Handler(){
//    @SuppressLint("HandlerLeak")
//    @Override
//    public void handleMessage(@NonNull Message msg) {
//        super.handleMessage(msg);
//        if (msg.what == 123) {
//            Bundle bundle=msg.getData();
//            String response=bundle.getString(Strings.JSON_DATA);
//            Log.d(Strings.TAG, "请求成功");
//            passageArrayList = new JsonUtil().JsonPassage(response);
//
//            for (int i = 0; i < passageArrayList.size(); i++) {
//                Massage massage = new Massage(passageArrayList.get(i).getTitle(), passageArrayList.get(i).getAuthor(), R.drawable.ad,passageArrayList.get(i).getNiceDate(),passageArrayList.get(i).getChapterName(),passageArrayList.get(i).getTags(), passageArrayList.get(i).getLink());
//                Log.d("Json123", "Massage id is " + massage.getId());
//                boardGameList.add(massage);
//                Log.d("Json1234", "Massage id is " + boardGameList.get(i).getId());
//            }
//            boardAdapter.notifyDataSetChanged();
//            recyclerView1.setAdapter(boardAdapter);
//
//        }
//        else if(msg.what==12){
//            Bundle bundle=msg.getData();
//            String response=bundle.getString(Strings.JSON_BANNER);
//            Log.d(Strings.TAG, "请求成功");
//            bannerArrayList = new JsonUtil().JsonBanner(response);
////            for (int i = 0; i < bannerArrayList.size(); i++) {
////               BannerRecycle bannerRecycle=new BannerRecycle(,bannerArrayList.get(i).getUrl());
////               bannerRecycleList.add(bannerRecycle);
////            }
//            for (int i = 0; i < 1; i++) {
//                BannerRecycle bannerRecycle=new BannerRecycle(R.drawable.one,bannerArrayList.get(0).getUrl());
//                bannerRecycleList.add(bannerRecycle);
//                BannerRecycle bannerRecycle1=new BannerRecycle(R.drawable.two,bannerArrayList.get(1).getUrl());
//                bannerRecycleList.add(bannerRecycle1);
//                BannerRecycle bannerRecycle2=new BannerRecycle(R.drawable.three,bannerArrayList.get(2).getUrl());
//                bannerRecycleList.add(bannerRecycle2);
//                BannerRecycle bannerRecycle3=new BannerRecycle(R.drawable.four,bannerArrayList.get(2).getUrl());
//                bannerRecycleList.add(bannerRecycle3);
//            }
//            liuAdapter.notifyDataSetChanged();
//            recyclerView.setAdapter(liuAdapter);
//        }
//    }
//};



    LinearLayoutManager linearLayoutManager1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_list);
//        new Read_Write().verifyStoragePermissions(this);
        recyclerView1=findViewById(R.id.list_1);
         linearLayoutManager1=new LinearLayoutManager(this);
        recyclerView1.addOnScrollListener(new RecyclerViewOnScrollListener(onScrollListener));
        recyclerView1.setLayoutManager(linearLayoutManager1);
        updateList();
        boardAdapter=new DoodsAdapter(boardGameList);
        recyclerView1.setAdapter(boardAdapter);
        recyclerView1.setFocusable(false);
        recyclerView1.setFocusableInTouchMode(false);
swipeRefreshLayout=findViewById(R.id.refresh_layout);
//         boardAdapter = new DoodsAdapter(ListActivity.this, R.layout.boardgame_item, boardGameList);
////        BoardAdapter boardAdapter = new BoardAdapter(ListActivity.this, R.layout.boardgame_item, boardGameList);
//        listView = findViewById(R.id.list_1);
////        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
//        listView.setAdapter(boardAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Massage boardGame = boardGameList.get(position);
//                //返回这个位子的名字
////                Toast.makeText(ListActivity.this, boardGame.getName(), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(ListActivity.this, Massages_1_Activity.class);
//                intent.putExtra(Strings.JSON_LINK,boardGame.getLink());
//                startActivity(intent);
//                boardAdapter.notifyDataSetChanged();
//            }
//        });

        //Banner
        recyclerView=findViewById(R.id.recycle_view1);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL); y=linearLayoutManager.findFirstVisibleItemPosition();
        recyclerView.setLayoutManager(linearLayoutManager);
        upRecycler();
        liuAdapter=new BannerAdapter(bannerRecycleList);
        recyclerView.setAdapter(liuAdapter);
        //一页一页滑动
        PagerSnapHelper pagerSnapHelper=new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(recyclerView);
        //自动轮播


    ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(1);
    scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
        @Override
        public void run() {
            Log.d("ssssssssssss",String.valueOf(y));
            y=y+1;
            recyclerView.smoothScrollToPosition(y);
        }
    },5000,5000, TimeUnit.MILLISECONDS);

//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(@NonNull  RecyclerView recyclerView, int newState) {
//              if (newState==RecyclerView.SCROLL_STATE_IDLE){
//
//              }
//            }
//        });
        radioButton=findViewById(R.id.leader);
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(ListActivity.this, LeaderActivity.class);
               startActivity(intent);
            }
        });
//        ScrollView scrollView=findViewById(R.id.scrollView);
//        scrollView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                scrollView.smoothScrollBy(0,200);//平滑偏移
//            }
//        });
       RadioButton button = findViewById(R.id.List_radioButton11);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, My_characteristicActivity.class);
                startActivity(intent);
            }
        });
        RadioButton button1=findViewById(R.id.List_Guang_radioButton10);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, SquareActivity.class);
                startActivity(intent);
            }
        });
        RadioButton button2=findViewById(R.id.List_radioButton9);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, RecommendActivity.class);
                startActivity(intent);
            }
        });
       RadioButton radioButton=findViewById(R.id.Select_Radio_Button);
       radioButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(ListActivity.this, SelectActivity.class);
               startActivity(intent);
           }
       });
        RadioButton radioButton1=findViewById(R.id.leader);
        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ListActivity.this,LeaderActivity.class);
                startActivity(intent);
            }
        });
        RadioButton radioButton2=findViewById(R.id.List_radioButton13);
        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ListActivity.this, TiActivity.class);
                startActivity(intent);
            }
        });
       RadioButton button3=findViewById(R.id.List_radioButton8);
        RadioButton[] rbs = new RadioButton[5];
        rbs[0]=button;
        rbs[1]=button1;
        rbs[2]=button2;
        rbs[3]=button3;
        rbs[4]=radioButton2;

        for (RadioButton rb : rbs) {
            Resources res = ListActivity.this.getResources();
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


//   Handler handler =new Handler();
//   Message message=handler.obtainMessage();
//   final Handler handler1=new Handler(){
//
//   };
    }
private void upRecycler(){
        address1=Strings.BANNER;
        new HttpUtil().sendHttpRequest(address1, new HttpBack() {
            @Override
            public void onFinish(String response) {
//                Message message=new Message();
//                message.what=12;
//                Bundle bundle=new Bundle();
//                bundle.putString(Strings.JSON_BANNER,response);
//                message.setData(bundle);
//                handler.sendMessage(message);
                bannerArrayList = new JsonUtil().JsonBanner(response);
//            for (int i = 0; i < bannerArrayList.size(); i++) {
//               BannerRecycle bannerRecycle=new BannerRecycle(,bannerArrayList.get(i).getUrl());
//               bannerRecycleList.add(bannerRecycle);
//            }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 1; i++) {
                            BannerRecycle bannerRecycle=new BannerRecycle(R.drawable.one,bannerArrayList.get(0).getUrl());
                            bannerRecycleList.add(bannerRecycle);
                            BannerRecycle bannerRecycle1=new BannerRecycle(R.drawable.two,bannerArrayList.get(1).getUrl());
                            bannerRecycleList.add(bannerRecycle1);
                            BannerRecycle bannerRecycle2=new BannerRecycle(R.drawable.three,bannerArrayList.get(2).getUrl());
                            bannerRecycleList.add(bannerRecycle2);
                            BannerRecycle bannerRecycle3=new BannerRecycle(R.drawable.four,bannerArrayList.get(2).getUrl());
                            bannerRecycleList.add(bannerRecycle3);
                        }
                        liuAdapter.notifyDataSetChanged();
                        recyclerView.setAdapter(liuAdapter);
                    }
                });

            }

            @Override
            public void onError(Exception e) {

            }
        });
}


    //    获取链接中的json
    private void updateList() {

        address = Strings.FIRST+String.valueOf(count)+Strings.JSON;
        new HttpUtil().sendHttpRequest(address, new HttpBack() {
            @Override
            public void onFinish(String response) {
//                Message message=new Message();
//                message.what=123;
//                Bundle bundle=new Bundle();
//                bundle.putString(Strings.JSON_DATA,response);
//                message.setData(bundle);
//                handler.sendMessage(message);
                passageArrayList = new JsonUtil().JsonPassage(response);
runOnUiThread(new Runnable() {
    @Override
    public void run() {
        for (int i = 0; i < passageArrayList.size(); i++) {
            Massage massage = new Massage(passageArrayList.get(i).getTitle(), passageArrayList.get(i).getAuthor(), R.drawable.ad,passageArrayList.get(i).getNiceDate(),passageArrayList.get(i).getChapterName(),passageArrayList.get(i).getTags(), passageArrayList.get(i).getLink());
            Log.d("Json123", "Massage id is " + massage.getId());
            boardGameList.add(massage);
            Log.d("Json1234", "Massage id is " + boardGameList.get(i).getId());
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

    //    获取链接中的json
    private void updateList1() {

        address = Strings.FIRST+String.valueOf(count)+Strings.JSON;
        new HttpUtil().sendHttpRequest(address, new HttpBack() {
            @Override
            public void onFinish(String response) {
//                Message message=new Message();
//                message.what=123;
//                Bundle bundle=new Bundle();
//                bundle.putString(Strings.JSON_DATA,response);
//                message.setData(bundle);
//                handler.sendMessage(message);
                passageArrayList = new JsonUtil().JsonPassage(response);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < passageArrayList.size(); i++) {
                            Massage massage = new Massage(passageArrayList.get(i).getTitle(), passageArrayList.get(i).getAuthor(), R.drawable.ad,passageArrayList.get(i).getNiceDate(),passageArrayList.get(i).getChapterName(),passageArrayList.get(i).getTags(), passageArrayList.get(i).getLink());
                            Log.d("Json123", "Massage id is " + massage.getId());
                            boardGameList.add(massage);
                            Log.d("Json1234", "Massage id is " + boardGameList.get(i).getId());
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



//    private static class MyHandler extends Handler {
//        private WeakReference<HandlerOOMActivity> weakReference;
////        private HandlerOOMActivity activity;
//
//        public MyHandler(HandlerOOMActivity activity) {
//            weakReference = new WeakReference<>(activity);
////            this.activity = activity;
//        }
//
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            Log.e(Strings.TAG, "handleMessage: ");
////            HandlerOOMActivity activity = weakReference.get();
//            switch (msg.what) {
//                case 0:
////                    if (activity != null) {
////                        activity.tv.setText("我是更改后的文字");
////                    }
////                    activity.tv.setText("我是更改后的文字");
//                    break;
//            }
//        }
//    }


//    private void fun() {
//        for (int i = 0; i < 1; i++) {
//            BoardGame xiangQi = new BoardGame("象棋", R.drawable.ad);
//            boardGameList.add(xiangQi);
//            BoardGame weiQi = new BoardGame("围棋", R.drawable.ad);
//            boardGameList.add(weiQi);
//            BoardGame douSouQi = new BoardGame("斗兽棋", R.drawable.ad);
//            boardGameList.add(douSouQi);
//            BoardGame duiJiaoQi = new BoardGame("对角棋", R.drawable.ad);
//            boardGameList.add(duiJiaoQi);
//            BoardGame ba = new BoardGame("八卦棋", R.drawable.ad);
//            boardGameList.add(ba);
//            BoardGame liuZiQi = new BoardGame("六子棋", R.drawable.ad);
//            boardGameList.add(liuZiQi);
//            BoardGame jun = new BoardGame("四国军棋", R.drawable.ad);
//            boardGameList.add(jun);
//        }
//    }
//    private void fun() {
//        for (int i = 0; i < 1; i++) {
//            Massage xiangQi = new Massage("象棋", 1, R.drawable.ad);
//            boardGameList.add(xiangQi);
//            Massage weiQi = new Massage("围棋", 2, R.drawable.ad);
//            boardGameList.add(weiQi);
//            Massage douSouQi = new Massage("斗兽棋", 3, R.drawable.ad);
//            boardGameList.add(douSouQi);
//            Massage duiJiaoQi = new Massage("对角棋", 4, R.drawable.ad);
//            boardGameList.add(duiJiaoQi);
//            Massage ba = new Massage("八卦棋", 5, R.drawable.ad);
//            boardGameList.add(ba);
//            Massage liuZiQi = new Massage("六子棋", 6, R.drawable.ad);
//            boardGameList.add(liuZiQi);
//            Massage jun = new Massage("四国军棋", 7, R.drawable.ad);
//            boardGameList.add(jun);
//        }
//    }
}