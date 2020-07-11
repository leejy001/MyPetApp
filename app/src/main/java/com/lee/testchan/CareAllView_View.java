package com.lee.testchan;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;


public class CareAllView_View extends AppCompatActivity {

    SQLiteDatabase database;
    CareAllViewRecyclerAdapter adapter;
    String tableCare = "CareTable";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.careallview_view);

        RecyclerView recyclerView = findViewById(R.id.care_allview_recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        showInfo_Care(tableCare);
        recyclerView.setAdapter(adapter);

        Button backButton = (Button) findViewById(R.id.careallview_backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void showInfo_Care(String tableName) {
        database = openOrCreateDatabase("MyPetApp.db", MODE_PRIVATE, null);
        Intent intent = getIntent();
        int get_forid = intent.getExtras().getInt("mid");
        adapter = new CareAllViewRecyclerAdapter(getApplicationContext());
        if (database != null) {
            String sql = "select * from " + tableName + " where Info_id=" + get_forid;
            Cursor cursor = database.rawQuery(sql, null);

            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                int id= cursor.getInt(0);
                int forid = cursor.getInt(1);
                String care_date = cursor.getString(2);
                String walk = cursor.getString(3);
                String brush = cursor.getString(4);
                String wash= cursor.getString(5);
                String pee= cursor.getString(6);
                String foo= cursor.getString(7);
                String weight= cursor.getString(8);
                String memo= cursor.getString(9);
                String medicalMenu= cursor.getString(10);
                String medicalMemo= cursor.getString(11);

                adapter.addItem(new CareAllView_item(id,forid, care_date, walk, brush, wash, pee, foo, weight, memo, medicalMenu, medicalMemo));
            }
            cursor.close();
        }
    }
}