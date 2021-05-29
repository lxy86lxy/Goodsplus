package com.example.Goods.activities.baby;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.Goods.R;
import com.example.Goods.activities.article.Massages_1_Activity;
import com.example.Goods.classes.LeaderD;
import com.example.Goods.string.Strings;
import com.google.android.material.chip.Chip;

import java.util.List;

public class Body2Fragment extends Fragment {
private List<LeaderD> leaderDList;
//private Handler handler=new Handler(){
//    @Override
//    public void handleMessage(@NonNull Message msg) {
//        if (msg.what == 12) {
//        Bundle bundle=msg.getData();
//        String response=bundle.getString(Strings.JSON_DATA);
//        leaderDList=new JsonUtil().JsonD(response);
//        }
//    }
//};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view=inflater.inflate(R.layout.fragment_body2, container, false);
        Chip chip=view.findViewById(R.id.chip29);
        chip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Massages_1_Activity.class);
                intent.putExtra(Strings.JSON_LINK,"https://developers.google.cn/");
                startActivity(intent);
            }
        });

        Chip chip39=view.findViewById(R.id.chip39);
        chip39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Massages_1_Activity.class);
                intent.putExtra(Strings.JSON_LINK,"http://www.github.com/");
                startActivity(intent);
            }
        });

        Chip chip49=view.findViewById(R.id.chip49);
        chip49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Massages_1_Activity.class);
                intent.putExtra(Strings.JSON_LINK,"https://juejin.im/");
                startActivity(intent);
            }
        });

        Chip chip59=view.findViewById(R.id.chip59);
        chip59.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Massages_1_Activity.class);
                intent.putExtra(Strings.JSON_LINK,"https://www.csdn.net/");
                startActivity(intent);
            }
        });

        Chip chip129=view.findViewById(R.id.chip129);
        chip129.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Massages_1_Activity.class);
                intent.putExtra(Strings.JSON_LINK,"http://www.wanandroid.com/blog/show/2314");
                startActivity(intent);
            }
        });

        Chip chip139=view.findViewById(R.id.chip139);
        chip139.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Massages_1_Activity.class);
                intent.putExtra(Strings.JSON_LINK,"https://www.wanandroid.com/blog/show/2350");
                startActivity(intent);
            }
        });

        Chip chip149=view.findViewById(R.id.chip149);
        chip149.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Massages_1_Activity.class);
                intent.putExtra(Strings.JSON_LINK,"http://www.wanandroid.com/blog/show/2277");
                startActivity(intent);
            }
        });

        Chip chip159=view.findViewById(R.id.chip159);
        chip159.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Massages_1_Activity.class);
                intent.putExtra(Strings.JSON_LINK,"https://github.com/mzlogin/awesome-adb");
                startActivity(intent);
            }
        });

        Chip chip169=view.findViewById(R.id.chip169);
        chip169.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Massages_1_Activity.class);
                intent.putExtra(Strings.JSON_LINK,"http://www.wanandroid.com/blog/show/2309");
                startActivity(intent);
            }
        });

        Chip chip229=view.findViewById(R.id.chip229);
        chip229.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Massages_1_Activity.class);
                intent.putExtra(Strings.JSON_LINK,"http://androidxref.com/");
                startActivity(intent);
            }
        });

        Chip chip239=view.findViewById(R.id.chip239);
        chip239.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Massages_1_Activity.class);
                intent.putExtra(Strings.JSON_LINK,"https://www.androidos.net.cn/sourcecode");
                startActivity(intent);
            }
        });

        Chip chip249=view.findViewById(R.id.chip249);
        chip249.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Massages_1_Activity.class);
                intent.putExtra(Strings.JSON_LINK,"http://aospxref.com/");
                startActivity(intent);
            }
        });

        Chip chip259=view.findViewById(R.id.chip259);
        chip259.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Massages_1_Activity.class);
                intent.putExtra(Strings.JSON_LINK,"https://cs.android.com/");
                startActivity(intent);
            }
        });


//        new HttpUtil().sendHttpRequest(Strings.LEADER_DAO, new HttpBack() {
//            @Override
//            public void onFinish(String response) {
//                Message message=new Message();
//                message.what=12;
//                Bundle bundle=new Bundle();
//                bundle.putString(Strings.JSON_BANNER,response);
//                message.setData(bundle);
//                handler.sendMessage(message);
//
//            }
//
//            @Override
//            public void onError(Exception e) {
//
//            }
//        });
     return view;
    }
}