package com.lee.testchan;

import android.os.Parcel;
import android.os.Parcelable;

public class CareAllView_item implements Parcelable {

    int careAllViewId;
    int careAllViewforId;
    String careAllViewDate;
    String careAllViewWalk;
    String careAllViewBrush;
    String careAllViewWash;
    String careAllViewPee;
    String careAllViewFoo;
    String careAllViewWeight;
    String careAllViewMemo;
    String careAllViewMedicalMenu;
    String careAllViewMedicalMemo;
    public CareAllView_item(int careAllViewId,int careAllViewforId,String careAllViewDate, String careAllViewWalk, String careAllViewBrush, String careAllViewWash, String careAllViewPee, String careAllViewFoo, String careAllViewWeight, String careAllViewMemo, String careAllViewMedicalMenu, String careAllViewMedicalMemo) {
        this.careAllViewId = careAllViewId;
        this.careAllViewforId = careAllViewforId;
        this.careAllViewDate = careAllViewDate;
        this.careAllViewWalk = careAllViewWalk;
        this.careAllViewBrush = careAllViewBrush;
        this.careAllViewWash = careAllViewWash;
        this.careAllViewPee = careAllViewPee;
        this.careAllViewFoo = careAllViewFoo;
        this.careAllViewWeight = careAllViewWeight;
        this.careAllViewMemo = careAllViewMemo;
        this.careAllViewMedicalMenu = careAllViewMedicalMenu;
        this.careAllViewMedicalMemo = careAllViewMedicalMemo;
    }

    public int getCareAllViewId() {
        return careAllViewId;
    }

    public void setCareAllViewId(int careAllViewId) {
        this.careAllViewId = careAllViewId;
    }

    public int getCareAllViewforId() {
        return careAllViewforId;
    }

    public void setCareAllViewforId(int careAllViewforId) {
        this.careAllViewforId = careAllViewforId;
    }

    public String getCareAllViewDate() {
        return careAllViewDate;
    }

    public void setCareAllViewDate(String careAllViewDate) {
        this.careAllViewDate = careAllViewDate;
    }

    public String getCareAllViewWalk() {
        return careAllViewWalk;
    }

    public void setCareAllViewWalk(String careAllViewWalk) {
        this.careAllViewWalk = careAllViewWalk;
    }

    public String getCareAllViewBrush() {
        return careAllViewBrush;
    }

    public void setCareAllViewBrush(String careAllViewBrush) {
        this.careAllViewBrush = careAllViewBrush;
    }

    public String getCareAllViewWash() {
        return careAllViewWash;
    }

    public void setCareAllViewWash(String careAllViewWash) {
        this.careAllViewWash = careAllViewWash;
    }

    public String getCareAllViewPee() {
        return careAllViewPee;
    }

    public void setCareAllViewPee(String careAllViewPee) {
        this.careAllViewPee = careAllViewPee;
    }

    public String getCareAllViewFoo() {
        return careAllViewFoo;
    }

    public void setCareAllViewFoo(String careAllViewFoo) {
        this.careAllViewFoo = careAllViewFoo;
    }

    public String getCareAllViewWeight() {
        return careAllViewWeight;
    }

    public void setCareAllViewWeight(String careAllViewWeight) {
        this.careAllViewWeight = careAllViewWeight;
    }

    public String getCareAllViewMemo() {
        return careAllViewMemo;
    }

    public void setCareAllViewMemo(String careAllViewMemo) {
        this.careAllViewMemo = careAllViewMemo;
    }

    public String getCareAllViewMedicalMenu() {
        return careAllViewMedicalMenu;
    }

    public void setCareAllViewMedicalMenu(String careAllViewMedicalMenu) {
        this.careAllViewMedicalMenu = careAllViewMedicalMenu;
    }

    public String getCareAllViewMedicalMemo() {
        return careAllViewMedicalMemo;
    }

    public void setCareAllViewMedicalMemo(String careAllViewMedicalMemo) {
        this.careAllViewMedicalMemo = careAllViewMedicalMemo;
    }

    public CareAllView_item(Parcel src) {
        careAllViewId = src.readInt();
        careAllViewforId = src.readInt();
        careAllViewDate = src.readString();
        careAllViewWalk = src.readString();
        careAllViewBrush = src.readString();
        careAllViewWash = src.readString();
        careAllViewPee = src.readString();
        careAllViewFoo = src.readString();
        careAllViewWeight = src.readString();
        careAllViewMemo = src.readString();
        careAllViewMedicalMenu = src.readString();
        careAllViewMedicalMemo = src.readString();
    }

    public static final Creator CREATOR = new Creator() {
        @Override
        public CareAllView_item createFromParcel(Parcel source) {
            return new CareAllView_item(source);
        }

        @Override
        public CareAllView_item[] newArray(int size) {
            return new CareAllView_item[size];
        }
    };

    @Override
    public int describeContents() {return 0;}

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(careAllViewId);
        dest.writeInt(careAllViewforId);
        dest.writeString(careAllViewDate);
        dest.writeString(careAllViewWalk);
        dest.writeString(careAllViewBrush);
        dest.writeString(careAllViewWash);
        dest.writeString(careAllViewPee);
        dest.writeString(careAllViewFoo);
        dest.writeString(careAllViewWeight);
        dest.writeString(careAllViewMemo);
        dest.writeString(careAllViewMedicalMenu);
        dest.writeString(careAllViewMedicalMemo);
    }

}
