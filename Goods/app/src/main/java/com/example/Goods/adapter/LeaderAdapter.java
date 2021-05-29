package com.example.Goods.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.Goods.R;
import com.example.Goods.activities.article.Massages_1_Activity;
import com.example.Goods.classes.LeaderB;
import com.example.Goods.string.Strings;

import java.util.List;

public class LeaderAdapter extends RecyclerView.Adapter<LeaderAdapter.ViewHolder> {

    private List<LeaderB> mLiu;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView id;
        TextView name,date;
        TextView number,what;
        View dou_luo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dou_luo=itemView;
            id=itemView.findViewById(R.id.leader_image);
            name=itemView.findViewById(R.id.leader_title);
            number=itemView.findViewById(R.id.leader_author);
            date=itemView.findViewById(R.id.leader_date);
            what=itemView.findViewById(R.id.leader_what);
        }
    }
    //构造
    public LeaderAdapter(List<LeaderB> boardGameList){
        mLiu=boardGameList;
    }
    @NonNull
    @Override
    public LeaderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.leader,parent,false);
        LeaderAdapter.ViewHolder viewHolder=new LeaderAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderAdapter.ViewHolder holder, int position) {
        LeaderB boardGame=mLiu.get(position);
        Glide.with(holder.dou_luo.getContext()).load(boardGame.getEnvelopePic()).into(holder.id);
        holder.what.setText(boardGame.getDesc());
        holder.date.setText(boardGame.getNiceDate());
        holder.number.setText(boardGame.getAuthor());
        holder.name.setText(boardGame.getTitle());
        holder.dou_luo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p=holder.getAdapterPosition();
                LeaderB dou=mLiu.get(p);
                Intent intent=new Intent(v.getContext(), Massages_1_Activity.class);
                intent.putExtra(Strings.JSON_LINK,dou.getLink());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mLiu.size();
    }

}
