package com.lee.testchan;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class All_Animal_Item implements Parcelable {

    int allViewId;
    String allViewName;
    String allViewKind;
    String allViewBreed;
    String allViewIntroduce;
    int allViewBirth;
    String allViewSex;
    String allViewVaccin;
    String allViewNenu;

    public All_Animal_Item(int allViewId, String allViewName,String allViewKind, String allViewBreed,String allViewIntroduce,int allViewBirth,String allViewSex, String allViewVaccin, String allViewNenu) {
        this.allViewId = allViewId;
        this.allViewName = allViewName;
        this.allViewKind = allViewKind;
        this.allViewBreed = allViewBreed;
        this.allViewIntroduce = allViewIntroduce;
        this.allViewBirth = allViewBirth;
        this.allViewSex = allViewSex;
        this.allViewVaccin = allViewVaccin;
        this.allViewNenu = allViewNenu;
    }

    public int getAllViewId() {
        return allViewId;
    }

    public void setAllViewId(int allViewId) {
        this.allViewId = allViewId;
    }

    public String getAllViewName() {
        return allViewName;
    }

    public void setAllViewName(String allViewName) {
        this.allViewName = allViewName;
    }

    public String getAllViewKind() {
        return allViewKind;
    }

    public void setAllViewKind(String allViewKind) {
        this.allViewKind = allViewKind;
    }

    public String getAllViewBreed() {
        return allViewBreed;
    }

    public void setAllViewBreed(String allViewBreed) {
        this.allViewBreed = allViewBreed;
    }

    public String getAllViewIntroduce() {
        return allViewIntroduce;
    }

    public void setAllViewIntroduce(String allViewIntroduce) {
        this.allViewIntroduce = allViewIntroduce;
    }

    public int getAllViewBirth() {
        return allViewBirth;
    }

    public void setAllViewBirth(int allViewBirth) {
        this.allViewBirth = allViewBirth;
    }

    public String getAllViewSex() {
        return allViewSex;
    }

    public void setAllViewSex(String allViewSex) {
        this.allViewSex = allViewSex;
    }

    public String getAllViewVaccin() {
        return allViewVaccin;
    }

    public void setAllViewVaccin(String allViewVaccin) {
        this.allViewVaccin = allViewVaccin;
    }

    public String getAllViewNenu() {
        return allViewNenu;
    }

    public void setAllViewNenu(String allViewNenu) {
        this.allViewNenu = allViewNenu;
    }

    public All_Animal_Item(Parcel src) {
        allViewName = src.readString();
        allViewKind = src.readString();
        allViewBreed = src.readString();
        allViewIntroduce = src.readString();
        allViewBirth = src.readInt();
        allViewSex = src.readString();
        allViewVaccin = src.readString();
        allViewNenu = src.readString();
    }

    public static final Creator CREATOR = new Creator() {
        @Override
        public All_Animal_Item createFromParcel(Parcel source) {
            return new All_Animal_Item(source);
        }

        @Override
        public All_Animal_Item[] newArray(int size) {
            return new All_Animal_Item[size];
        }
    };

    @Override
    public int describeContents() {return 0;}

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(allViewName);
        dest.writeString(allViewKind);
        dest.writeString(allViewBreed);
        dest.writeString(allViewIntroduce);
        dest.writeInt(allViewBirth);
        dest.writeString(allViewSex);
        dest.writeString(allViewVaccin);
        dest.writeString(allViewNenu);
    }
}
