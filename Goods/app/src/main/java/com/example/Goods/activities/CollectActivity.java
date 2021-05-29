package com.example.Goods.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.Goods.adapter.DoodsAdapter;
import com.example.Goods.R;
import com.example.Goods.classes.Massage;
import com.example.Goods.classes.Passage;
import com.example.Goods.string.Strings;
import com.example.Goods.util.HttpBack;
import com.example.Goods.util.HttpUtil;
import com.example.Goods.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class CollectActivity extends AppCompatActivity {
    String address;
    ListView listView;
    RecyclerView recyclerView1;
//    private Handler handler=new Handler() {
//        @SuppressLint("HandlerLeak")
//        @Override
//        public void handleMessage(@NonNull Message msg) {
//            super.handleMessage(msg);
//            if (msg.what == 112) {
//                Bundle bundle = msg.getData();
//                String response = bundle.getString(Strings.JSON_COLLECT);
//                Log.d(Strings.TAG, "请求成功");
//                Log.d("ccccccccccccc",response);
//                //没有登录，使用sp来本地永久保存
//                if(response.isEmpty()){
//                    Log.d("ccccccccccccc","111111111");
//                    Massage massage=new Massage("还没收藏任何宝贝儿","0",R.drawable.ad,"NULL","NULL","NULL");
//                    boardGameList.add(massage);
//                }else {
//                    passageArrayList=new JsonUtil().JsonPassage(response);
////                Log.d("Json","title123 is  "+passageArrayList.get(0).getTitle());成功
//                    for (int i = 0; i < passageArrayList.size(); i++) {
//                        Massage massage = new Massage(passageArrayList.get(i).getTitle(), passageArrayList.get(i).getAuthor(), R.drawable.ad,passageArrayList.get(i).getNiceDate(),passageArrayList.get(i).getChapterName(), passageArrayList.get(i).getLink());
//
//                        boardGameList.add(massage);
//                        Log.d("Json1234", "Massage id is " + boardGameList.get(i).getId());
//                    }
//
//                }
//                boardAdapter.notifyDataSetChanged();
//                recyclerView1.setAdapter(boardAdapter);
//            }
//        }
//    };
    private List<Massage> boardGameList = new ArrayList<>();
    private ArrayList<Passage> passageArrayList = new ArrayList<>();
    DoodsAdapter boardAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
//        updateList();
//        boardAdapter = new DoodsAdapter(CollectActivity.this, R.layout.boardgame_item, boardGameList);
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
//                Intent intent = new Intent(CollectActivity.this, Massages_1_Activity.class);
//                intent.putExtra(Strings.JSON_LINK,boardGame.getLink());
//                startActivity(intent);
//                boardAdapter.notifyDataSetChanged();
//            }
//        });
        recyclerView1=findViewById(R.id.list_12);
        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(linearLayoutManager1);
        updateList();
        boardAdapter=new DoodsAdapter(boardGameList);
        recyclerView1.setAdapter(boardAdapter);

    }
    private void updateList() {

        address = Strings.COLLECT_LIST+"0"+Strings.JSON;
        new HttpUtil().sendHttpRequest(address, new HttpBack() {
            @Override
            public void onFinish(String response) {
//                Message message=new Message();
//                message.what=112;
//                Bundle bundle=new Bundle();
//                bundle.putString(Strings.JSON_COLLECT,response);
//                message.setData(bundle);
//                handler.sendMessage(message);
                passageArrayList=new JsonUtil().JsonPassage(response);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(response.isEmpty()){
                            Log.d("ccccccccccccc","111111111");
//                            Massage massage=new Massage("还没收藏任何宝贝儿","0",R.drawable.ad,"NULL","NULL",,"NULL");
//                            boardGameList.add(massage);
                        }else {

//                Log.d("Json","title123 is  "+passageArrayList.get(0).getTitle());成功
                            for (int i = 0; i < passageArrayList.size(); i++) {
                                Massage massage = new Massage(passageArrayList.get(i).getTitle(), passageArrayList.get(i).getAuthor(), R.drawable.ad,passageArrayList.get(i).getNiceDate(),passageArrayList.get(i).getChapterName(), passageArrayList.get(i).getTags(),passageArrayList.get(i).getLink());

                                boardGameList.add(massage);
                                Log.d("Json1234", "Massage id is " + boardGameList.get(i).getId());
                            }

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