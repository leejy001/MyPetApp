package com.lee.testchan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class CareRecyclerAdapter extends RecyclerView.Adapter<CareRecyclerAdapter.ViewHolder>{
    Context context;

    ArrayList<Care_Recycler_Item> items = new ArrayList<Care_Recycler_Item>();
    OnItemClickListener listener;

    public static interface OnItemClickListener {
        public void onItemClick(ViewHolder holder, View view, int position);
    }

    public CareRecyclerAdapter(Context context) {
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
        View itemView = inflater.inflate(R.layout.main_profile_item,viewGroup,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Care_Recycler_Item item = items.get(position);
        viewHolder.setItem(item);

        viewHolder.setOnItemClickListener(listener);
    }

    public void addItem(Care_Recycler_Item item) {
        items.add(item);
    }

    public void addItems(ArrayList<Care_Recycler_Item> items) {
        this.items = items;
    }

    public Care_Recycler_Item getItem(int position) {
        return items.get(position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView id;
        TextView name;
        TextView birth;
        TextView introduce;
        TextView breed;

        OnItemClickListener listener;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.care_profile_id);
            name = itemView.findViewById(R.id.care_profile_name);
            birth = itemView.findViewById(R.id.care_profile_birth);
            introduce = itemView.findViewById(R.id.care_profile_introduce);
            breed = itemView.findViewById(R.id.care_profile_breed);

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

        public void setItem(Care_Recycler_Item item) {
            id.setText(String.valueOf(item.getId()));
            name.setText(item.getName());
            birth.setText(String.valueOf(item.getBirth()));
            introduce.setText(item.getIntroduce());
            breed.setText(item.getBreed());
        }

        public void setOnItemClickListener(OnItemClickListener listener) {
            this.listener = listener;
        }
    }
}