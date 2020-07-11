package com.lee.testchan;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LifeAllViewRecyclerAdapter extends RecyclerView.Adapter<LifeAllViewRecyclerAdapter.ViewHolder>{
    Context context;

    ArrayList<Life_Board_Item> items = new ArrayList<Life_Board_Item>();
    OnLifeItemClickListener listener;

    public static interface OnLifeItemClickListener {
        public void onItemClick(ViewHolder holder, View view, int position);
    }

    public LifeAllViewRecyclerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.life_board_item,viewGroup,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Life_Board_Item item = items.get(position);
        viewHolder.setItem(item);
        viewHolder.lifeViewDate.setText(item.getLifeVeiwDate());

        viewHolder.setOnLifeItemClickListener(listener);
    }

    public void addItem(Life_Board_Item item) {
        items.add(item);
    }

    public void addItems(ArrayList<Life_Board_Item> items) {
        this.items = items;
    }

    public Life_Board_Item getItem(int position) {
        return items.get(position);
    }

    public void setOnLifeItemClickListener(OnLifeItemClickListener listener) {
        this.listener = listener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView lifeViewId;
        ImageView imageView;
        TextView lifeViewName;
        TextView lifeViewDate;
        TextView lifeViewTitle;

        OnLifeItemClickListener listener;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lifeViewId = itemView.findViewById(R.id.box_life_id);
            lifeViewName = itemView.findViewById(R.id.box_life_name);
            lifeViewDate = itemView.findViewById(R.id.box_life_date);
            lifeViewTitle = itemView.findViewById(R.id.box_life_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if(listener != null) {
                        listener.onItemClick(ViewHolder.this, v,position);
                    }
                }
            });
        }

        public void setItem(Life_Board_Item item) {
            lifeViewId.setText(String.valueOf(item.getLifeViewId()));
            lifeViewName.setText(item.getLifeViewName());
            lifeViewDate.setText(item.getLifeVeiwDate());
            lifeViewTitle.setText(item.getLifeViewTitle());
        }

        public void setOnLifeItemClickListener(OnLifeItemClickListener listener) {
            this.listener = listener;
        }
    }
}
