package com.lee.testchan;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class LifeView extends AppCompatActivity {

    Cursor cursor;
    SQLiteDatabase database;
    String tableLife = "LifeTable";
    LifeAllViewRecyclerAdapter adapter;

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.life_view);

        final RecyclerView recyclerView = findViewById(R.id.lifeRecycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        showInfoLife(tableLife);
        recyclerView.setAdapter(adapter);

        adapter.setOnLifeItemClickListener(new LifeAllViewRecyclerAdapter.OnLifeItemClickListener() {
            @Override
            public void onItemClick(LifeAllViewRecyclerAdapter.ViewHolder holder, View view, int position) {
                Life_Board_Item ll = adapter.getItem(position);
                int lifeid = ll.getLifeViewId();
                Intent intent = new Intent(getApplicationContext(),Life_Board_All_View.class);
                intent.putExtra("lifeid",lifeid);
                startActivity(intent);
            }
        });


        Button writeButton = (Button) findViewById(R.id.writeStoryButton);
        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Life_Board_ViewActivity.class);
                startActivity(intent);
            }
        });

        Button goHome = (Button)findViewById(R.id.homeButton);
        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainView.class);
                startActivity(intent);
            }
        });

    }

    public void showInfoLife(String tableName){
        database = openOrCreateDatabase("MyPetApp.db", MODE_PRIVATE , null);
        adapter = new LifeAllViewRecyclerAdapter(getApplicationContext());
        if(database != null) {
            String sql = "select * from " + tableName;
            cursor = database.rawQuery(sql,null);

            for(int i = 0;i<cursor.getCount();i++) {
                cursor.moveToNext();
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String date = cursor.getString(2);
                String title = cursor.getString(3);
                String story= cursor.getString(4);

                adapter.addItem(new Life_Board_Item(id, name, date,title,story));
                Log.i(getClass().getName(),"i" + ":" + name + " | " + name + " | " + date +  " | " + title + " | " + story );
            }
            cursor.close();
        }
    }
}
