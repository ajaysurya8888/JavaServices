package model;

import java.util.List;

public class Screens {

    int screenId;

    String ScreenName;
    String ScreenLocation;
    String  ScreenAddress;
    Events screenEvent;

    List<Show> showList;

    public Screens(int screenId, String screenName, String screenLocation, String screenAddress,List<Show> showList) {
        this.screenId = screenId;
        ScreenName = screenName;
        ScreenLocation = screenLocation;
        ScreenAddress = screenAddress;
        this.showList = showList;
    }

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public String getScreenName() {
        return ScreenName;
    }

    public void setScreenName(String screenName) {
        ScreenName = screenName;
    }

    public String getScreenLocation() {
        return ScreenLocation;
    }

    public void setScreenLocation(String screenLocation) {
        ScreenLocation = screenLocation;
    }

    public String getScreenAddress() {
        return ScreenAddress;
    }

    public void setScreenAddress(String screenAddress) {
        ScreenAddress = screenAddress;
    }

    public Events getScreenEvent() {
        return screenEvent;
    }

    public void setScreenEvent(Events screenEvent) {
        this.screenEvent = screenEvent;
    }

    public List<Show> getShowList() {
        return showList;
    }

    public void setShowList(List<Show> showList) {
        this.showList = showList;
    }


}
