package controller;

import model.Events;
import model.Screens;
import model.Show;
import service.ScreenService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ScreenController {
   private ScreenService screenService;

    public ScreenController() {
        this.screenService = new ScreenService();
    }

    public void addScreen(String screenName, String location, String address,List<String> showList) {
       screenService.addScreen(screenName,location,address,showList);
    }

    public void addEventToScreen(String screenName,Events events,List<String> showList){
        screenService.addEventToScreen(screenName,events,showList);
    }

    public HashSet<Events> getEventsByLocation(String screenLocation) {
        return screenService.getEventsByLocation(screenLocation);
    }

    public  List<Screens> getScreenByLocation(String location) {
        return screenService.getScreenByLocation(location);
    }

    public List<Show> getShowTime(String screenName) {
        return screenService.getScreenShow(screenName);
    }

    public List<String> getShowTimeForEvent(String eventName, String screenName) {
        return screenService.getShowTimeForEvent(eventName,screenName);
    }
}
