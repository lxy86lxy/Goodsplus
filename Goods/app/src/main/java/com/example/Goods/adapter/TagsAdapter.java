package com.example.Goods.adapter;

import android.content.Intent;
import android.util.Log;
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
import com.example.Goods.classes.Massage;
import com.example.Goods.string.Strings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TagsAdapter extends RecyclerView.Adapter<TagsAdapter.ViewHolder> {
    private Map<Integer, Boolean> map = new HashMap<>();
    private List<Massage> mLiu;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView id;
        TextView name;
        TextView number,data,bottom,tag;
        View dou_luo;
        CheckBox checkBox;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dou_luo=itemView;
            checkBox=itemView.findViewById(R.id.boardgame_Collect);
            id=itemView.findViewById(R.id.boardgame_image);
            name=itemView.findViewById(R.id.boardgame_name);
            number=itemView.findViewById(R.id.boardgame_id);
            bottom=itemView.findViewById(R.id.boardgame_bottom);
            data=itemView.findViewById(R.id.boardgame__date);
            tag=itemView.findViewById(R.id.boardgame_tags);
        }
    }
    //构造
    public TagsAdapter(List<Massage> boardGameList){
        mLiu=boardGameList;
    }
    @NonNull
    @Override
    public TagsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.boardgame_item,parent,false);
        TagsAdapter.ViewHolder viewHolder=new TagsAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TagsAdapter.ViewHolder holder, int position) {
        Massage boardGame=mLiu.get(position);
        Log.d("BBBBBB",String.valueOf(boardGame.getTagsBeanList().size()) );
        Log.d("BBBBBBBBBBBBBBBBBBBB",boardGame.getTagsBeanList().get(0).getName1());
        if (!boardGame.getTagsBeanList().get(0).getName1().equalsIgnoreCase("123")){
            Log.d("BBBBBBBAAAAAA","12345689946");
            String s=boardGame.getTagsBeanList().get(0).getName1()+"·";
            holder.tag.setText(s);
            holder.tag.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //
                }
            });
        }

        holder.id.setImageResource(boardGame.getImageId());
        holder.number.setText(boardGame.getId());
        holder.name.setText(boardGame.getName());
        holder.data.setText(boardGame.getData());
        holder.bottom.setText(boardGame.getBottom());
        holder.number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });
        holder.dou_luo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p=holder.getAdapterPosition();
                Massage dou=mLiu.get(p);
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
