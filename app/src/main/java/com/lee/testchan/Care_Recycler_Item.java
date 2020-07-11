package com.lee.testchan;

import android.graphics.drawable.Drawable;

public class Care_Recycler_Item {
    //Drawable imageDrawalbe;
    int id;
    String name;
    int birth;
    String breed;
    String introduce;


    public Care_Recycler_Item(int id,String name, int birth, String breed, String introduce){
        this.id=id;
        this.name = name;
        this.birth = birth;
        this.breed = breed;
        this.introduce = introduce;
    }
//    public Drawable getImageDrawalbe() {
//        return imageDrawalbe;
//    }
//
//    public void setImageDrawalbe(Drawable imageDrawalbe) {
//        this.imageDrawalbe = imageDrawalbe;
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
