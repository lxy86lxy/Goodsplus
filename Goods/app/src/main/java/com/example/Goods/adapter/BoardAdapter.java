package com.example.Goods.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Goods.R;
import com.example.Goods.activities.article.Massages_1_Activity;
import com.example.Goods.classes.BoardGame;
import com.example.Goods.string.Strings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {
    private Map<Integer, Boolean> map = new HashMap<>();
    private List<BoardGame> mLiu;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView id;
        TextView name,date;
        TextView what;
        CheckBox checkBox;
        View dou_luo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dou_luo=itemView;
            id=itemView.findViewById(R.id.question_image);
            name=itemView.findViewById(R.id.question_name);
            date=itemView.findViewById(R.id.question_date);
            what=itemView.findViewById(R.id.question_what);
            checkBox=itemView.findViewById(R.id.question_collect);
        }
    }
    //构造
    public BoardAdapter(List<BoardGame> boardGameList){
        mLiu=boardGameList;
    }
    @NonNull
    @Override
    public BoardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        if (viewType==1){
//            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.footer,parent,false);
//            BoardAdapter.ViewHolder viewHolder=new BoardAdapter.ViewHolder(view);
//            return viewHolder;
//        }else if (viewType==0){
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.question_item,parent,false);
            BoardAdapter.ViewHolder viewHolder=new BoardAdapter.ViewHolder(view);
            return viewHolder;
//        }
//      return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BoardAdapter.ViewHolder holder, int position) {
        BoardGame boardGame=mLiu.get(position);
        holder.what.setText(boardGame.getWhat());
        holder.date.setText(boardGame.getDate());
        holder.name.setText(boardGame.getName());
        holder.dou_luo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p=holder.getAdapterPosition();
               BoardGame dou=mLiu.get(p);
                Intent intent=new Intent(v.getContext(), Massages_1_Activity.class);
                intent.putExtra(Strings.JSON_LINK,dou.getLink());
                v.getContext().startActivity(intent);
            }
        });
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    map.put(position, true);
                } else {
                    map.remove(position);
                }
            }
        });
        if (map != null && map.containsKey(position)) {
            holder.checkBox.setChecked(true);
        } else {
            holder.checkBox.setChecked(false);
        }
    }

    @Override
    public int getItemCount() {
        return mLiu.size();
    }
    }

