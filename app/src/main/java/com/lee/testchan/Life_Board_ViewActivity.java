package com.lee.testchan;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Life_Board_ViewActivity extends AppCompatActivity {

    SQLiteDatabase database;
    String tableLife = "LifeTable";
    EditText lifeViewName;
    EditText lifeViewTitle;
    EditText lifeViewStory;
    String lifeDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.life_board_info);

        lifeViewName = (EditText) findViewById(R.id.life_nameInput);
        lifeViewTitle = (EditText) findViewById(R.id.life_titleInput);
        lifeViewStory = (EditText) findViewById(R.id.life_StoryInput);

        Date time = Calendar.getInstance().getTime();
        lifeDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(time);

        Button saveButton = (Button) findViewById(R.id.life_SaveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = lifeViewName.getText().toString().trim();
                String title = lifeViewTitle.getText().toString().trim();
                String story = lifeViewStory.getText().toString().trim();
                insertInfolife(tableLife,name,lifeDate,title,story);
                finish();
            }
        });

        Button cancelButton = (Button) findViewById(R.id.life_cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void insertInfolife(String tableName, String name,String time, String title, String story) {
        database = openOrCreateDatabase("MyPetApp.db", MODE_PRIVATE , null);

        if(database != null) {
            String sql ="insert into " + tableName + "(name, create_date, title, story) values(?,?,?,?)";
            Object[] params = {name,time,title,story};
            Log.i(this.getClass().getName(), "insertInfo : " + params);
            database.execSQL(sql,params);

        }
    }
}
