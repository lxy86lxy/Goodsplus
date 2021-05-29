package com.example.Goods.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Goods.R;
import com.example.Goods.activities.article.Massages_1_Activity;
import com.example.Goods.classes.BannerRecycle;
import com.example.Goods.string.Strings;

import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.ViewHolder> {

    private List<BannerRecycle> mLiu;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView id,in;
        TextView name;
        TextView number;
        View dou_luo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dou_luo=itemView;
            id=itemView.findViewById(R.id.dou_luo_image);

        }
    }
    //构造
    public BannerAdapter(List<BannerRecycle> boardGameList){
        mLiu=boardGameList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.banner,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BannerRecycle boardGame=mLiu.get(position);
        holder.id.setImageResource(boardGame.getImage());
        holder.dou_luo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p=holder.getAdapterPosition();
                BannerRecycle dou=mLiu.get(p);
                Intent intent=new Intent(v.getContext(), Massages_1_Activity.class);
                intent.putExtra(Strings.JSON_LINK,dou.getLink());
                v.getContext().startActivity(intent);
            }
        });
    }
//无限滚动
    @Override
    public int getItemCount() {
//        return mLiu==null||mLiu.size()==0?0:Integer.MAX_VALUE;
        return mLiu.size();
    }

}
