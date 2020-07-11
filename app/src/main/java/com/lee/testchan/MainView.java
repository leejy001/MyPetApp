package com.lee.testchan;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainView extends AppCompatActivity {

    SQLiteDatabase database;
    CareRecyclerAdapter adapter;
    RecyclerView recyclerView;
    String tableInfo = "InfoTable";
    TextView careName;
    TextView careBirth;
    TextView careBreed;
    int _id;

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.main_view);

        careName = (TextView) findViewById(R.id.main_name);
        careBirth = (TextView) findViewById(R.id.main_birth);
        careBreed = (TextView) findViewById(R.id.main_breed);

        recyclerView = findViewById(R.id.care_RecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        showInfo_Care(tableInfo);
        recyclerView.setAdapter(adapter);

        Button goLife = (Button)findViewById(R.id.lifeButton);
        goLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LifeView.class);
                startActivity(intent);
            }
        });

        Button register = (Button)findViewById(R.id.registerButton);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"등록화면으로 이동합니다.",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),WriteInfo.class);
                startActivity(intent);
            }
        });

        Button allview = (Button)findViewById(R.id.AllViewButton);
        allview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"모두보기로 이동합니다.",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),All_Animal_ViewActivity.class);
                startActivity(intent);
            }
        });

        Button careview = (Button) findViewById(R.id.careViewButton);
        careview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getT = careName.getText().toString().trim();
                if(getT.getBytes().length <= 0) {
                    Toast.makeText(getApplicationContext(),"반려동물을 선택하세요",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "케어화면으로 이동합니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), CareView.class);
                    intent.putExtra("mid", _id);
                    startActivity(intent);
                }
            }
        });

        Button goallView = (Button)findViewById(R.id.allviewButton);
        goallView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getT = careName.getText().toString().trim();

                if(getT.getBytes().length <= 0) {
                    Toast.makeText(getApplicationContext(),"반려동물을 선택하세요",Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), CareAllView_View.class);
                    intent.putExtra("mid", _id);
                    startActivity(intent);
                }
            }
        });

        adapter.setOnItemClickListener(new CareRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(CareRecyclerAdapter.ViewHolder holder, View view, int position) {
                Care_Recycler_Item item = adapter.getItem(position);
                careName.setText(item.getName());
                careBirth.setText(String.valueOf(item.getBirth()));
                careBreed.setText(item.getBreed());
                _id = item.getId();
                Toast.makeText(getApplicationContext(),"반려동물 선택 : " + item.getName(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void showInfo_Care(String tableName) {
        database = openOrCreateDatabase("MyPetApp.db", MODE_PRIVATE, null);
        adapter = new CareRecyclerAdapter(getApplicationContext());

        if (database != null) {
            String sql = "select _id, name, breed, introduce, birth from " + tableName;
            Cursor cursor = database.rawQuery(sql, null);

            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String breed = cursor.getString(2);
                String introduce = cursor.getString(3);
                int birth = cursor.getInt(4);

                adapter.addItem(new Care_Recycler_Item(id, name, birth, breed, introduce));
                Log.i(getClass().getName(), "i" + ":" + name + " | "  + breed + " | " + introduce + " | " + birth );
            }
            cursor.close();
        }
    }

}
