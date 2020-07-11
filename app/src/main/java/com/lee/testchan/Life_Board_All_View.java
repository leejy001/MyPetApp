package com.lee.testchan;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Life_Board_All_View extends AppCompatActivity {

    SQLiteDatabase database;
    String tableLife = "LifeTable";
    TextView writeName;
    TextView writeDate;
    TextView writeId;
    TextView writeTitle;
    TextView writeStory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.life_board_view);

        writeName = (TextView) findViewById(R.id.life_name);
        writeDate = (TextView) findViewById(R.id.life_date);
        writeId = (TextView) findViewById(R.id.life_id);
        writeTitle = (TextView) findViewById(R.id.life_title);
        writeStory = (TextView) findViewById(R.id.life_story);

        showInfoLife(tableLife);

        Button backButton = (Button)findViewById(R.id.returnLifeButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button deleteButton  = (Button)findViewById(R.id.deleteLifeButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteInfoLife(tableLife);
                finish();
            }
        });
    }

    public void deleteInfoLife(String tableName) {
        database = openOrCreateDatabase("MyPetApp.db", MODE_PRIVATE , null);
        Intent intent = getIntent();
        int get_id = intent.getExtras().getInt("lifeid");

        database.execSQL("delete from '" + tableName + "' where _lid= '" + get_id + "';");

    }
    public void showInfoLife(String tableName){
        database = openOrCreateDatabase("MyPetApp.db", MODE_PRIVATE , null);
        Intent intent = getIntent();
        int get_id = intent.getExtras().getInt("lifeid");

        if(database != null) {
            String sql = "select * from " + tableName + " where _lid=" + get_id;
            Cursor cursor = database.rawQuery(sql,null);

                cursor.moveToNext();
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                writeName.setText(name);
                String date = cursor.getString(2);
                writeDate.setText(date);
                String title = cursor.getString(3);
                writeTitle.setText(title);
                String story= cursor.getString(4);
                writeStory.setText(story);

            cursor.close();
        }

    }
}
