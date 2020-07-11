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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CareView extends AppCompatActivity {

    SQLiteDatabase database;
    String tableCare = "CareTable";
    TextView careId;
    TextView careforId;
    TextView care_Date;

    TextView c_walk;
    TextView c_brush;
    TextView c_wash;
    TextView c_pee;
    TextView c_foo;
    TextView medicalinfo;
    EditText careWeight;
    EditText careMemo;
    EditText careMedicalMemo;
    String careDate;
    int count;
    int get_forid;

    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;
    private RadioGroup radioGroup3;
    private RadioGroup radioGroup4;
    private RadioGroup radioGroup5;
    String check_pee;
    String check_foo;
    String isWalk;
    String isBrush;
    String isWash;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.care_view);
        careId = (TextView) findViewById(R.id.care_id);
        careforId = (TextView) findViewById(R.id.care_forid);
        care_Date = (TextView) findViewById(R.id.care_date);
        c_walk = (TextView) findViewById(R.id.c_walk);
        c_brush = (TextView) findViewById(R.id.c_brush);
        c_wash = (TextView) findViewById(R.id.c_wash);
        c_pee = (TextView) findViewById(R.id.c_pee);
        c_foo = (TextView) findViewById(R.id.c_foo);
        careWeight = (EditText) findViewById(R.id.care_weight);
        careMemo = (EditText) findViewById(R.id.care_memo);
        careMedicalMemo = (EditText) findViewById(R.id.care_medicalmemo);
        Date time = Calendar.getInstance().getTime();
        careDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(time);

        medicalinfo = (TextView) findViewById(R.id.care_medicalmenu_view);

        Intent intent = getIntent();
        get_forid = intent.getExtras().getInt("mid");

        showInfo2care(tableCare);


        radioGroup3=(RadioGroup)findViewById(R.id.g_walk);
        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.walk_t:
                        isWalk = "완료";
                        c_walk.setText(isWalk);
                        break;
                    case R.id.walk_f:
                        isWalk = "-";
                        c_walk.setText(isWalk);
                        break;
                }
            }
        });

        radioGroup4=(RadioGroup)findViewById(R.id.g_brush);
        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.brush_t:
                        isBrush = "완료";
                        c_brush.setText(isBrush);
                        break;
                    case R.id.brush_f:
                        isBrush = "-";
                        c_brush.setText(isBrush);
                        break;
                }
            }
        });

        radioGroup5=(RadioGroup)findViewById(R.id.g_wash);
        radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.wash_t:
                        isWash = "완료";
                        c_wash.setText(isWash);
                        break;
                    case R.id.wash_f:
                        isWash = "-";
                        c_wash.setText(isWash);
                        break;
                }
            }
        });


        radioGroup1=(RadioGroup)findViewById(R.id.g_pee);
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.pee_yellow:
                        check_pee = "노란색";
                        c_pee.setText(check_pee);
                        break;
                    case R.id.pee_brown:
                        check_pee = "연갈색";
                        c_pee.setText(check_pee);
                        break;
                    case R.id.pee_pink:
                        check_pee = "핑크색";
                        c_pee.setText(check_pee);
                        break;
                }
            }
        });

        radioGroup2=(RadioGroup)findViewById(R.id.g_foo);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.foo_crustiness:
                        check_foo = "딱딱함";
                        c_foo.setText(check_foo);
                        break;
                    case R.id.foo_normal:
                        check_foo = "보통";
                        c_foo.setText(check_foo);
                        break;
                    case R.id.foo_soften:
                        check_foo = "무름";
                        c_foo.setText(check_foo);
                        break;
                }
            }
        });


        final Button medicalmenu = (Button) findViewById(R.id.care_medicalmenu);
        medicalmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu meidcalmenu = new PopupMenu(getApplicationContext(), v);
                getMenuInflater().inflate(R.menu.medicalservice_menu, meidcalmenu.getMenu());
                meidcalmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId()) {
                            case R.id.medical_menu_vaccin:
                                index = 0;
                                medicalinfo.setText("필수접종");
                                break;
                            case R.id.medical_menu_check:
                                index = 1;
                                medicalinfo.setText("건강검진");
                                break;
                            case R.id.medical_menu_scaling:
                                index = 2;
                                medicalinfo.setText("스케일링");
                                break;
                            case R.id.medical_menu_heartworm:
                                index = 3;
                                medicalinfo.setText("심장사상충");
                                break;
                        }
                        return false;
                    }
                });
                meidcalmenu.show();
            }
        });

        final Button input = (Button)findViewById(R.id.careSaveButton);
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String walk = c_walk.getText().toString();
                String brush = c_brush.getText().toString();
                String wash = c_wash.getText().toString();
                String pee = c_pee.getText().toString();
                String foo = c_foo.getText().toString();
                String weight = careWeight.getText().toString();
                String memo = careMemo.getText().toString();
                String medicalMenu = medicalinfo.getText().toString();
                String medicalMemo = careMedicalMemo.getText().toString();

                //care_date, walk, brush, wash, pee, foo, weight, memo, medicalMenu, medicalMemo
                if(count == 0){
                    insertInfo_Care(get_forid,careDate, walk, brush, wash, pee, foo, weight, memo, medicalMenu, medicalMemo);
                } else {
                    updateInfo_Care(careDate, walk, brush, wash, pee, foo, weight, memo, medicalMenu, medicalMemo);
                }
                finish();
            }
        });

        Button goHome = (Button)findViewById(R.id.homeButton);
        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
//_Cid integer PRIMARY KEY autoincrement, name text, birth integer, care_date text, walk text, brush text, wash text, pee text, foo text, weight real, memo text, medicalmenu text, medicalmemo text

    public void updateInfo_Care(String date, String walk, String brush, String wash, String pee, String foo, String weight, String memo, String medicalMenu, String medicalMemo) {
        database = openOrCreateDatabase("MyPetApp.db",MODE_PRIVATE,null);
        int show_id = Integer.parseInt(careId.getText().toString());
        if(database!=null){
            ContentValues values = new ContentValues();
            values.put("care_date",date);
            values.put("walk",walk);
            values.put("brush",brush);
            values.put("wash",wash);
            values.put("pee",pee);
            values.put("foo",foo);
            values.put("weight",weight);
            values.put("memo",memo);
            values.put("medicalMenu",medicalMenu);
            values.put("medicalMemo",medicalMemo);
            //Toast.makeText(getApplicationContext(),"update:" + show_id,Toast.LENGTH_SHORT).show();
            database.update(tableCare, values, "_Cid=" + show_id , null);
        }
    }

    public void insertInfo_Care(int info_id, String date, String walk, String brush, String wash, String pee, String foo, String weight, String memo, String medicalMenu, String medicalMemo) {
        database = openOrCreateDatabase("MyPetApp.db",MODE_PRIVATE,null);
        if(database!= null){
            String sql = "insert into " + tableCare + "(info_id, care_date, walk, brush, wash, pee, foo, weight, memo, medicalMenu, medicalMemo) values(?,?,?,?,?,?,?,?,?,?,?)";
            Object[] params = {info_id,date,walk,brush,wash,pee,foo,weight,memo,medicalMenu,medicalMemo};
            database.execSQL(sql,params);
            Toast.makeText(getApplicationContext(),"insert:"+info_id,Toast.LENGTH_SHORT);
        }
    }

    public void showInfo2care(String tableName) {
        database = openOrCreateDatabase("MyPetApp.db", MODE_PRIVATE, null);
        Intent intent = getIntent();
        int show_forid = intent.getExtras().getInt("mid");
        careforId.setText(String.valueOf(get_forid));
        care_Date.setText(careDate);

        Date time = Calendar.getInstance().getTime();
        String forDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(time);
        forDate = "'" + forDate + "'";

        if(database != null) {
            String sql = "select * from " + tableName + " where care_date= " + forDate + " and info_id=" + show_forid;
            //String sql = "select * from " + tableName + " where "+ "info_id=" + show_forid;

            Cursor cursor = database.rawQuery(sql,null);
            count = cursor.getCount();
            cursor.moveToNext();
            //Toast.makeText(getApplicationContext(),"count:" + count + "info_id:" + show_forid ,Toast.LENGTH_SHORT).show();
            if(cursor != null && cursor.getCount() != 0) {
                int cid = cursor.getInt(0);
                careId.setText(String.valueOf(cid));
                int Info_id = cursor.getInt(1);
                careforId.setText(String.valueOf(Info_id));
                String care_date = cursor.getString(2);
                care_Date.setText(care_date);
                String isWalk  = cursor.getString(3);
                c_walk.setText(isWalk);
                String isBrush = cursor.getString(4);
                c_brush.setText(isBrush);
                String isWash = cursor.getString(5);
                c_wash.setText(isWash);
                String pee = cursor.getString(6);
                c_pee.setText(pee);
                String foo = cursor.getString(7);
                c_foo.setText(foo);
                String weight = cursor.getString(8);
                careWeight.setText(weight);
                String memo = cursor.getString(9);
                careMemo.setText(memo);
                String medicalmenu = cursor.getString(10);
                medicalinfo.setText(medicalmenu);
                String medicalmemo = cursor.getString(11);
                careMedicalMemo.setText(medicalmemo);
                Log.i(this.getClass().getName(), "Cid:" + cid + " info_id:" + Info_id + " careDate: " + care_date);
            }
            cursor.close();
        }
    }
}
