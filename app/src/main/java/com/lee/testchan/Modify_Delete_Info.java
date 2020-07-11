package com.lee.testchan;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Modify_Delete_Info extends AppCompatActivity {

    SQLiteDatabase database;
    String tableInfo = "InfoTable";
    String tableCare = "CareTable";

    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;
    private RadioGroup radioGroup3;

    private RadioButton male;
    private RadioButton female;
    private RadioButton dknow;
    private RadioButton vaccin_b;
    private RadioButton vaccin;
    private RadioButton vaccin_a;
    private RadioButton nenu_b;
    private RadioButton nenu_a;
    EditText write_name;
    EditText write_introduce;
    EditText write_birth;
    TextView breedinfo;
    TextView kindsinfo;
    TextView mdid;
    TextView sex_info;
    TextView vaccin_info;
    TextView nenutralization_info;

    String check_sex;
    String check_vaccin;
    String check_nenu;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motify_delete_info);

        write_name = (EditText) findViewById(R.id.input_name);
        write_introduce = (EditText) findViewById(R.id.input_introduce);
        write_birth = (EditText) findViewById(R.id.input_birth);
        kindsinfo = (TextView) findViewById(R.id.kinds_info);
        breedinfo = (TextView) findViewById(R.id.breed_info);
        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);
        dknow = (RadioButton) findViewById(R.id.dknow);
        vaccin_b = (RadioButton) findViewById(R.id.vaccin_after);
        vaccin = (RadioButton) findViewById(R.id.vaccin);
        vaccin_a = (RadioButton) findViewById(R.id.vaccin_after);
        nenu_b = (RadioButton) findViewById(R.id.nenu_before);
        nenu_a = (RadioButton) findViewById(R.id.nenu_after);
        mdid = (TextView)findViewById(R.id.mdId);
        sex_info = (TextView) findViewById(R.id.sex_info);
        vaccin_info = (TextView) findViewById(R.id.vaccin_info);
        nenutralization_info = (TextView) findViewById(R.id.nenutralization_info);

        showInfo(tableInfo);

        Button modifyButton = (Button) findViewById(R.id.modify_Infobutton);
        modifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String wname = write_name.getText().toString().trim();
                String wintroduce = write_introduce.getText().toString().trim();
                String wbirth = write_birth.getText().toString().trim();
                String wkind = kindsinfo.getText().toString().trim();
                String wbreed = breedinfo.getText().toString().trim();
                String sex = sex_info.getText().toString();
                String vaccin = vaccin_info.getText().toString();
                String nenu = nenutralization_info.getText().toString();

                int birth = -1;
                try{
                    birth = Integer.parseInt(wbirth);
                } catch (Exception e) {}

                updateInfo(tableInfo, wname, wkind, wbreed, wintroduce, birth, sex, vaccin, nenu);
                finish();
            }
        });

        Button deleteButton = (Button) findViewById(R.id.delete_Infobutton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteInfo(tableInfo);
                deleteCare(tableCare);
                finish();
            }
        });

        radioGroup1=(RadioGroup)findViewById(R.id.g_sex);
       // radioGroup1.setOnCheckedChangeListener(this);

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.male:
                        check_sex = "남아";
                        sex_info.setText(check_sex);
                        break;
                    case R.id.female:
                        check_sex = "여아";
                        sex_info.setText(check_sex);
                        break;
                }
            }
        });

        radioGroup2=(RadioGroup)findViewById(R.id.g_vaccin);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.dknow:
                        check_vaccin = "모름";
                        vaccin_info.setText(check_vaccin);
                        break;
                    case R.id.vaccin_before:
                        check_vaccin = "접종 전";
                        vaccin_info.setText(check_vaccin);
                        break;
                    case R.id.vaccin:
                        check_vaccin = "접종 중";
                        vaccin_info.setText(check_vaccin);
                        break;
                    case R.id.vaccin_after:
                        check_vaccin = "접종 후";
                        vaccin_info.setText(check_vaccin);
                        break;
                }
            }
        });

        radioGroup3=(RadioGroup)findViewById(R.id.g_nenu);
        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.nenu_before:
                        check_nenu = "중성화 전";
                        nenutralization_info.setText(check_nenu);
                        break;
                    case R.id.nenu_after:
                        check_nenu = "중성화 후";
                        nenutralization_info.setText(check_nenu);
                        break;
                }
            }
        });

        kindsinfo = (TextView) findViewById(R.id.kinds_info);
        breedinfo = (TextView) findViewById(R.id.breed_info);

        Button kinds = (Button) findViewById(R.id.kindButton);
        kinds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu kindmenu = new PopupMenu(getApplicationContext(), v);
                getMenuInflater().inflate(R.menu.kinds_option, kindmenu.getMenu());
                kindmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId()) {
                            case R.id.dog:
                                index = 0;
                                kindsinfo.setText("강아지");
                                Toast.makeText(getApplication(),"강아지 선택",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.cat:
                                index = 1;
                                kindsinfo.setText("고양이");
                                Toast.makeText(getApplication(),"고양이 선택",Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                        return false;
                    }
                });
                kindmenu.show();
            }
        });

        Button breeds = (Button) findViewById(R.id.breedButton);
        breeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu breedmenu = new PopupMenu(getApplicationContext(), v);
                if(index == 0) {
                    getMenuInflater().inflate(R.menu.dbreed_option, breedmenu.getMenu());
                    breedmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch(item.getItemId()) {
                                case R.id.dog001:
                                    breedinfo.setText("푸들");
                                    Toast.makeText(getApplication(),"푸들 선택",Toast.LENGTH_SHORT).show();
                                    break;
                                case R.id.dog002:
                                    breedinfo.setText("말티즈");
                                    Toast.makeText(getApplication(),"말티즈 선택",Toast.LENGTH_SHORT).show();
                                    break;
                                case R.id.dog003:
                                    breedinfo.setText("닥스훈트");
                                    Toast.makeText(getApplication(),"닥스훈트 선택",Toast.LENGTH_SHORT).show();
                                    break;
                                default:
                                    break;
                            }
                            return false;
                        }
                    });
                } else if(index == 1) {
                    getMenuInflater().inflate(R.menu.cbreed_option, breedmenu.getMenu());
                    breedmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch(item.getItemId()) {
                                case R.id.cat001:
                                    breedinfo.setText("러시안블루");
                                    Toast.makeText(getApplication(),"러시안블루 선택",Toast.LENGTH_SHORT).show();
                                    break;
                                case R.id.cat002:
                                    breedinfo.setText("샴");
                                    Toast.makeText(getApplication(),"샴 선택",Toast.LENGTH_SHORT).show();
                                    break;
                                default:
                                    break;
                            }
                            return false;
                        }
                    });
                }
                breedmenu.show();
            }
        });
    }
    //name text, kinds text, breed text, introduce text, birth integer, sex text, vaccin text, nenu text

    public void updateInfo(String tableName, String name, String kind, String breed, String introduce, int birth, String sex, String vaccin, String nenu) {
        database = openOrCreateDatabase("MyPetApp.db", MODE_PRIVATE , null);
        Intent intent = getIntent();
        int get_id = intent.getExtras().getInt("id");

        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("kinds",kind);
        values.put("breed",breed);
        values.put("introduce",introduce);
        values.put("birth",birth);
        values.put("sex",sex);
        values.put("vaccin",vaccin);
        values.put("nenu",nenu);
        database.update(tableName, values, "_id=" + get_id, null);

    }

    public void deleteInfo(String tableName) {
        database = openOrCreateDatabase("MyPetApp.db", MODE_PRIVATE , null);
        Intent intent = getIntent();
        int get_id = intent.getExtras().getInt("id");

        database.execSQL("delete from '" + tableName + "' where _id= '" + get_id + "';");
    }

    public void deleteCare(String tableName) {
        database = openOrCreateDatabase("MyPetApp.db", MODE_PRIVATE , null);
        Intent intent = getIntent();
        int get_id = intent.getExtras().getInt("id");

        database.execSQL("delete from '" + tableName + "' where info_id= '" + get_id + "';");
    }

    public void showInfo(String tableName){
        database = openOrCreateDatabase("MyPetApp.db", MODE_PRIVATE , null);
        Intent intent = getIntent();
        int get_id = intent.getExtras().getInt("id");

        if(database != null) {
            String sql = "select * from " + tableName + " where _id=" + get_id;
            Cursor cursor = database.rawQuery(sql,null);

            cursor.moveToNext();
            int id= cursor.getInt(0);
            mdid.setText(String.valueOf(id));
            String name = cursor.getString(1);
            write_name.setText(name);
            String kinds = cursor.getString(2);
            kindsinfo.setText(kinds);
            String breed = cursor.getString(3);
            breedinfo.setText(breed);
            String introduce = cursor.getString(4);
            write_introduce.setText(introduce);
            int birth = cursor.getInt(5);
            write_birth.setText(String.valueOf(birth));
            String sex = cursor.getString(6);
            sex_info.setText(sex);
            String vvaccin = cursor.getString(7);
            vaccin_info.setText(vvaccin);
            String nenu = cursor.getString(8);
            nenutralization_info.setText(nenu);

            Log.i(getClass().getName(),"i" + ":" + name + " | " + kinds + " | " + breed + " | " + introduce + " | " + birth + " | " + sex + " | " + vaccin + " | " + nenu );
            cursor.close();
        }
    }
}
