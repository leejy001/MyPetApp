package com.lee.testchan;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class WriteInfo extends AppCompatActivity {

    SQLiteDatabase database;
    String tableInfo = "InfoTable";

    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;
    private RadioGroup radioGroup3;
    EditText write_name;
    EditText write_introduce;
    EditText write_birth;
    TextView breedinfo;
    TextView kindsinfo;
    String check_sex;
    String check_vaccin;
    String check_nenu;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_info);

        write_name = (EditText) findViewById(R.id.input_name);
        write_introduce = (EditText) findViewById(R.id.input_introduce);
        write_birth = (EditText) findViewById(R.id.input_birth);

        Button saveButton = (Button) findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wname = write_name.getText().toString().trim();
                String wintroduce = write_introduce.getText().toString().trim();
                String wbirth = write_birth.getText().toString().trim();
                String wbreed = breedinfo.getText().toString();
                String wkinds = kindsinfo.getText().toString();

                int birth = -1;
                try{
                    birth = Integer.parseInt(wbirth);
                } catch (Exception e) {}
                String getT = write_name.getText().toString().trim();
                if(getT.getBytes().length <= 0) {
                    Toast.makeText(getApplicationContext(),"이름을 입력하세요",Toast.LENGTH_SHORT).show();
                } else {
                    insertInfo(wname, wkinds, wbreed, wintroduce, birth, check_sex, check_vaccin, check_nenu);
                    finish();
                }
            }
        });

        Button cancleButton = (Button) findViewById(R.id.cancel_button);
        cancleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        radioGroup1=(RadioGroup)findViewById(R.id.g_sex);
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.male:
                        check_sex = "남아";
                        break;
                    case R.id.female:
                        check_sex = "여아";
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
                        break;
                    case R.id.vaccin_before:
                        check_vaccin = "접종 전";
                        break;
                    case R.id.vaccin:
                        check_vaccin = "접종 중";
                        break;
                    case R.id.vaccin_after:
                        check_vaccin = "접종 후";
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
                        break;
                    case R.id.nenu_after:
                        check_nenu = "중성화 후";
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

    private void insertInfo(String name, String kinds, String breed, String introduce, int birth, String sex, String vaccin, String nenu) {
        database = openOrCreateDatabase("MyPetApp.db", MODE_PRIVATE , null);

        if(database != null) {
            String sql ="insert into " + tableInfo + "( name, kinds, breed, introduce, birth, sex, vaccin, nenu) values(?,?,?,?,?,?,?,?)";
            Object[] params = {name,kinds,breed,introduce,birth,sex,vaccin,nenu};
            database.execSQL(sql,params);

        }
    }
}
