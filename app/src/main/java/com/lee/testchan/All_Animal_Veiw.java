package com.lee.testchan;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class All_Animal_Veiw extends LinearLayout {

    TextView allViewId;
    TextView allViewName;
    TextView allViewKind;
    TextView allViewBreed;
    TextView allViewIntroduce;
    TextView allViewBirth;
    TextView allViewSex;
    TextView allViewVaccin;
    TextView allViewNenu;

    public All_Animal_Veiw(Context context) {
        super(context);
        init(context);
    }

    public All_Animal_Veiw(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.allanimal_item, this,true);

        allViewId = (TextView) findViewById(R.id.allViewId);
        allViewName = (TextView) findViewById(R.id.allViewName);
        allViewKind = (TextView) findViewById(R.id.allViewKind);
        allViewBreed = (TextView) findViewById(R.id.allViewBreed);
        allViewIntroduce = (TextView) findViewById(R.id.allViewIntroduce);
        allViewBirth = (TextView) findViewById(R.id.allViewBirth);
        allViewSex = (TextView) findViewById(R.id.allViewSex);
        allViewVaccin = (TextView) findViewById(R.id.allViewVaccin);
        allViewNenu = (TextView) findViewById(R.id.allViewNenu);
    }

    public void setAllViewId(int id) {
        allViewId.setText(String.valueOf(id));
    }

    public void setAllViewName(String name) {
        allViewName.setText(name);
    }

    public void setAllViewKind(String kind) {
        allViewKind.setText(kind);
    }

    public void setAllViewBreed(String breed) {
        allViewBreed.setText(breed);
    }

    public void setAllViewintroduce(String introduce) {
        allViewIntroduce.setText(introduce);
    }

    public void setAllViewBirth(int birth) {
        allViewBirth.setText(String.valueOf(birth));
    }

    public void setAllViewSex(String sex) {
        allViewSex.setText(sex);
    }

    public void setAllViewVaccin(String vaccin) {
        allViewVaccin.setText(vaccin);
    }

    public void setAllViewNenu(String nenu) {
        allViewNenu.setText(nenu);
    }
}
