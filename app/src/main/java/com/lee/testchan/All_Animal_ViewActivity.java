package com.lee.testchan;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class All_Animal_ViewActivity extends AppCompatActivity {
    SQLiteDatabase database;
    String tableInfo = "InfoTable";

    HomeAdapter adapter;
    ListView allView;

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.allanimal_view);
        allView = (ListView)findViewById(R.id.allView);
        adapter = new HomeAdapter();
        showInfo(tableInfo);
        allView.setAdapter(adapter);

        Button addinfo = (Button)findViewById(R.id.addInfButton);
        addinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"새로 추가합니다.",Toast.LENGTH_SHORT).show();
                showCommentWriteActivity();
            }
        });

        Button caninfo = (Button)findViewById(R.id.canInfButton);
        caninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        allView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                All_Animal_Item aa = adapter.getItem(position);
                int _id = aa.getAllViewId();
                Intent intent = new Intent(getApplicationContext(),Modify_Delete_Info.class);
                intent.putExtra("id", _id);
                startActivity(intent);
            }
        });
    }

    public void showCommentWriteActivity(){
        Intent intent = new Intent(getApplicationContext(),WriteInfo.class);
        startActivityForResult(intent,101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if(requestCode == 101) {
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    public void showInfo(String tableName){
        database = openOrCreateDatabase("MyPetApp.db", MODE_PRIVATE , null);

        if(database != null) {
            String sql = "select * from " + tableName;
            Cursor cursor = database.rawQuery(sql,null);

            for(int i = 0;i<cursor.getCount();i++) {
                cursor.moveToNext();
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String kinds = cursor.getString(2);
                String breed = cursor.getString(3);
                String introduce = cursor.getString(4);
                int birth = cursor.getInt(5);
                String sex = cursor.getString(6);
                String vaccin = cursor.getString(7);
                String nenu = cursor.getString(8);

                adapter.addItem(new All_Animal_Item(id, name, kinds, breed, introduce, birth, sex, vaccin, nenu));
                Log.i(getClass().getName(),"i" + ":" + name + " | " + kinds + " | " + breed + " | " + introduce + " | " + birth + " | " + sex + " | " + vaccin + " | " + nenu );
            }
            cursor.close();
        }
        allView.setAdapter(adapter);

    }

    class HomeAdapter extends BaseAdapter{
        ArrayList<All_Animal_Item> items = new ArrayList<All_Animal_Item>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(All_Animal_Item item) {
            items.add(item);
        }

        @Override
        public All_Animal_Item getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            All_Animal_Veiw view = null;
            if (convertView == null) {
                view = new All_Animal_Veiw(getApplicationContext());
            } else {
                view = (All_Animal_Veiw) convertView;
            }
            All_Animal_Item item = items.get(position);
            view.setAllViewId(item.getAllViewId());
            view.setAllViewName(item.getAllViewName());
            view.setAllViewKind(item.getAllViewKind());
            view.setAllViewBreed(item.getAllViewBreed());
            view.setAllViewintroduce(item.getAllViewIntroduce());
            view.setAllViewBirth(item.getAllViewBirth());
            view.setAllViewSex(item.getAllViewSex());
            view.setAllViewVaccin(item.getAllViewVaccin());
            view.setAllViewNenu(item.getAllViewNenu());

            return view;
        }
    }
}
