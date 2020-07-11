package com.lee.testchan;

import android.Manifest;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;

public class SIGN extends AppCompatActivity {

    private Boolean isPermission = true;
    SQLiteDatabase database;
    String databaseName = "MyPetApp.db";
    String tableInfo = "InfoTable";
    String tableLife = "LifeTable";
    String tableCare = "CareTable";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign);

        openDatabase(databaseName);
        createTableINFO(tableInfo);
        createTableLIFE(tableLife);
        createTableCARE(tableCare);

        database.execSQL("PRAGMA foreign_keys = ON;");

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainView.class);
                startActivity(intent);
            }
        });

    }

    public void openDatabase(String databaseName) {
        database = openOrCreateDatabase(databaseName, MODE_PRIVATE , null);
        if(database != null){
            Log.i(this.getClass().getName(), "데이터베이스 열림 " + database);
        }
    }

    public void createTableINFO(String tableName) {
        if(database != null) {
            String sql = "create table if not exists " + tableName + "(_id integer PRIMARY KEY autoincrement, name text, kinds text, breed text, introduce text, birth integer, sex text, vaccin text, nenu text)";
            database.execSQL(sql);
            Log.i(this.getClass().getName(), "INFO 테이블 생성 " + tableInfo);
        }
    }

    public void createTableLIFE(String tableName) {
        if(database != null) {
            String sql = "create table if not exists " + tableName + "(_lid integer PRIMARY KEY autoincrement, name text, create_date text, title text, story text)";
            database.execSQL(sql);
            Log.i(this.getClass().getName(), "LIFE 테이블 생성 " + tableLife);
        }
    }

    public void createTableCARE(String tableName) {
        if(database != null) {
            String sql = "create table if not exists " + tableName + "(_Cid integer PRIMARY KEY autoincrement, info_id integer, care_date text, walk text default '-', brush text default '-', wash text default '-', pee text default '-', foo text default '-', weight text default '-', memo text default '-', medicalmenu text default '-', medicalmemo text default '-' , foreign key (info_id) references InfoTable(_id))";
            database.execSQL(sql);
            Log.i(this.getClass().getName(), "CARE 테이블 생성");
        }
    }
}
