package com.example.Goods.activities.article;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import java.util.HashMap;
import java.util.List;

public class SelectActivity extends AppCompatActivity {
    EditText editText;
    Button buttonList;
    ListView listView;
    RecyclerView recyclerView1;
    private List<Massage> boardGameList = new ArrayList<>();
    private ArrayList<Passage> passageArrayList = new ArrayList<>();
    DoodsAdapter boardAdapter;
    //会内存泄露
//    private Handler handler=new Handler() {
//        @SuppressLint("HandlerLeak")
//        @Override
//        public void handleMessage(@NonNull Message msg) {
//            super.handleMessage(msg);
//            if (msg.what == 122) {
//                Bundle bundle = msg.getData();
//                String response = bundle.getString(Strings.JSON_DATA1);
//                Log.d(Strings.TAG, "请求寻找成功");
//                passageArrayList = new JsonUtil().JsonPassage(response);
//
//                for (int i = 0; i < passageArrayList.size(); i++) {
//                    Massage massage = new Massage(passageArrayList.get(i).getTitle(), passageArrayList.get(i).getAuthor(), R.drawable.ad, passageArrayList.get(i).getNiceDate(),passageArrayList.get(i).getChapterName(),passageArrayList.get(i).getLink());
//                    Log.d("Json123", "Massage id is " + massage.getId());
//                    boardGameList.add(massage);
//                    Log.d("Json1234", "Massage id is " + boardGameList.get(i).getId());
//                }
//                Log.d(Strings.TAG, "handler title is" + boardGameList.get(0).getName());
//            }
//            boardAdapter.notifyDataSetChanged();
//            recyclerView1.setAdapter(boardAdapter);
//        }
//    };
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
//        boardAdapter = new DoodsAdapter(SelectActivity.this, R.layout.boardgame_item, boardGameList);
////        BoardAdapter boardAdapter = new BoardAdapter(ListActivity.this, R.layout.boardgame_item, boardGameList);
//        listView = findViewById(R.id.list_4);
////        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
//        listView.setAdapter(boardAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Massage boardGame = boardGameList.get(position);
//                //返回这个位子的名字
////                Toast.makeText(ListActivity.this, boardGame.getName(), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(SelectActivity.this, Massages_1_Activity.class);
//                intent.putExtra(Strings.JSON_LINK,boardGame.getLink());
//                startActivity(intent);
//                boardAdapter.notifyDataSetChanged();
//            }
//        });
        recyclerView1=findViewById(R.id.list_4);
        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(linearLayoutManager1);
        boardAdapter=new DoodsAdapter(boardGameList);
        recyclerView1.setAdapter(boardAdapter);
        editText=findViewById(R.id.List_editTextTextPersonName2);
        buttonList = findViewById(R.id.List_select_button);
        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //搜索功能
                Log.d(Strings.TAG,editText.getText().toString());
                HashMap<String, String> map = new HashMap<>();
                map.put("k", editText.getText().toString());
                new HttpUtil().sendPostNetRequest(Strings.SELECT ,map ,new HttpBack() {
                    @Override
                    public void onFinish(String response) {
//                        Message message=new Message();
//                        message.what=122;
//                        Bundle bundle=new Bundle();
//                        bundle.putString(Strings.JSON_DATA1,response);
//                        message.setData(bundle);
//                        handler.sendMessage(message);
                        passageArrayList = new JsonUtil().JsonPassage(response);
runOnUiThread(new Runnable() {
    @Override
    public void run() {

        for (int i = 0; i < passageArrayList.size(); i++) {
            Massage massage = new Massage(passageArrayList.get(i).getTitle(), passageArrayList.get(i).getAuthor(), R.drawable.ad, passageArrayList.get(i).getNiceDate(),passageArrayList.get(i).getChapterName(),passageArrayList.get(i).getTags(),passageArrayList.get(i).getLink());
            Log.d("Json123", "Massage id is " + massage.getId());
            boardGameList.add(massage);
            Log.d("Json1234", "Massage id is " + boardGameList.get(i).getId());
        }
        Log.d(Strings.TAG, "handler title is" + boardGameList.get(0).getName());
        boardAdapter.notifyDataSetChanged();
        recyclerView1.setAdapter(boardAdapter) ;
    }
});
                    }
                    @Override
                    public void onError(Exception e) {
                    e.printStackTrace();
                    }
                });
            }
        });
    }
}