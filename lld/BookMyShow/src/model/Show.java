package model;

public class Show {
    int showId;

    String showTime;
    Events showEvent;

    String showScreen;

    public String getShowScreen() {
        return showScreen;
    }

    public void setShowScreen(String showScreen) {
        this.showScreen = showScreen;
    }


    public Show(String showTime,String showScreen) {
        this.showTime = showTime;
        this.showScreen = showScreen;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public String getshowTime() {
        return showTime;
    }

    public void setshowTime(String showTime) {
        this.showTime = showTime;
    }

    public Events getshowEvent() {
        return showEvent;
    }

    public void setshowEvent(Events showEvent) {
        this.showEvent = showEvent;
    }

}

