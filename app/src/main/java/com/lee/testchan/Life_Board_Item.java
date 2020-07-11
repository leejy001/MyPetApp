package com.lee.testchan;

public class Life_Board_Item {

    int lifeViewId;
    String lifeViewName;
    String lifeVeiwDate;
    String lifeViewTitle;
    String lifeViewStory;

    public Life_Board_Item(int lifeViewId, String lifeViewName, String lifeVeiwDate, String lifeVeiwTitle, String lifeViewStory) {
        this.lifeViewId = lifeViewId;
        this.lifeViewName = lifeViewName;
        this.lifeVeiwDate = lifeVeiwDate;
        this.lifeViewTitle = lifeVeiwTitle;
        this.lifeViewStory = lifeViewStory;
    }

    public int getLifeViewId() {
        return lifeViewId;
    }

    public void setLifeViewId(int lifeViewId) {
        this.lifeViewId = lifeViewId;
    }

    public String getLifeViewName() {
        return lifeViewName;
    }

    public void setLifeViewName(String lifeViewName) {
        this.lifeViewName = lifeViewName;
    }

    public String getLifeVeiwDate() {
        return lifeVeiwDate;
    }

    public void setLifeVeiwDate(String lifeVeiwDate) {
        this.lifeVeiwDate = lifeVeiwDate;
    }

    public String getLifeViewTitle() {
        return lifeViewTitle;
    }

    public void setLifeViewTitle(String lifeViewTitle) {
        this.lifeViewTitle = lifeViewTitle;
    }

    public String getLifeViewStory() {
        return lifeViewStory;
    }

    public void setLifeViewStory(String lifeViewStory) {
        this.lifeViewStory = lifeViewStory;
    }

}
