package com.lee.testchan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CareAllViewRecyclerAdapter extends RecyclerView.Adapter<CareAllViewRecyclerAdapter.ViewHolder> {

    Context context;

    ArrayList<CareAllView_item> items = new ArrayList<CareAllView_item>();
    OnItemClickListener listener;

    public static interface OnItemClickListener {
        public void onItemClick(ViewHolder holder, View view, int position);
    }

    public CareAllViewRecyclerAdapter(Context context) {
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
        View itemView = inflater.inflate(R.layout.careallview_item,viewGroup,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CareAllViewRecyclerAdapter.ViewHolder viewHolder, int position) {
        CareAllView_item item = items.get(position);
        viewHolder.setItem(item);

        viewHolder.setOnItemClickListener(listener);
    }

    public void addItem(CareAllView_item item) {
        items.add(item);
    }

    public void addItems(ArrayList<CareAllView_item> items) {
        this.items = items;
    }

    public CareAllView_item getItem(int position) {
        return items.get(position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView id;
        TextView forId;
        TextView date;
        TextView walk;
        TextView brush;
        TextView wash;
        TextView pee;
        TextView foo;
        TextView weight;
        TextView memo;
        TextView medicalmenu;
        TextView medicalmemo;

        OnItemClickListener listener;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.care_allview_id);
            forId = itemView.findViewById(R.id.care_allview_forgin_id);
            date = itemView.findViewById(R.id.care_allview_date);
            walk = itemView.findViewById(R.id.care_allview_walk);
            brush = itemView.findViewById(R.id.care_allview_brush);
            wash = itemView.findViewById(R.id.care_allview_wash);
            pee = itemView.findViewById(R.id.care_allview_pee);
            foo = itemView.findViewById(R.id.care_allview_foo);
            weight = itemView.findViewById(R.id.care_allview_weight);
            memo = itemView.findViewById(R.id.care_allview_memo);
            medicalmenu = itemView.findViewById(R.id.care_allview_medicalmenu);
            medicalmemo = itemView.findViewById(R.id.care_allview_medicalmemo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if(listener != null) {
                        listener.onItemClick(CareAllViewRecyclerAdapter.ViewHolder.this, v,position);
                    }
                }
            });
        }

        public void setItem(CareAllView_item item) {
            id.setText(String.valueOf(item.getCareAllViewId()));
            forId.setText(String.valueOf(item.getCareAllViewforId()));
            date.setText(item.getCareAllViewDate());
            walk.setText(item.getCareAllViewWalk());
            brush.setText(item.getCareAllViewBrush());
            wash.setText(item.getCareAllViewWash());
            pee.setText(item.getCareAllViewPee());
            foo.setText(item.getCareAllViewFoo());
            weight.setText(item.getCareAllViewWeight());
            memo.setText(item.getCareAllViewMemo());
            medicalmenu.setText(item.getCareAllViewMedicalMenu());
            medicalmemo.setText(item.getCareAllViewMedicalMemo());
        }

        public void setOnItemClickListener(OnItemClickListener listener) {
            this.listener = listener;
        }
    }
}
