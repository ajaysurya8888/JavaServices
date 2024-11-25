package service;

import controller.ShowController;
import model.Events;
import model.Screens;
import model.Show;

import java.util.*;
import java.util.stream.Collectors;

public class ScreenService {
    int screenId;
    Map<String,Screens> screensMap= new HashMap<String,Screens>();
    Map<String, ArrayList<Screens>> locationMap = new HashMap<String, ArrayList<Screens>>();

    Map<String, HashSet<Events>> locationEventsMap = new HashMap<String, HashSet<Events>>();

    private ShowController showController;

    public  ScreenService() {
        this.showController = new ShowController();
    }

    public  List<Screens> getScreenByLocation(String location) {

        return locationMap.getOrDefault(location,new ArrayList<Screens>());
    }

    public void addScreen(String screenName, String location, String address,List<String> showList) {
        List<Show> showLists = new ArrayList<Show>();
        for(String showTime : showList) {
            Show show = new Show(showTime,screenName);
            showLists.add(show);
        }
        Screens screen = new Screens(screenId++,screenName,location,address,showLists);
        screensMap.put(screenName,screen);
        locationMap.putIfAbsent(location,new ArrayList<Screens>());
        locationMap.get(location).add(screen);

    }

    public List<String> getShowTimeForEvent(String eventsName,String screenName) {
        return getScreenShow(screenName).stream()
                .filter(name-> name.getshowEvent() != null && name.getshowEvent().getEventName().equals(eventsName)).
                map(name->name.getshowTime())
                .collect(Collectors.toList());
    }

    public void addEventToScreen(String screenName,Events events,List<String> showList){

        for(String showTime: showList) {
            Show show = getScreenShow(screenName).stream().filter(name->name.getshowTime().equals(showTime)).findFirst().get();
            show.setshowEvent(events);

        }
        Screens screen = screensMap.get(screenName);
        screen.setScreenEvent(events);
        locationEventsMap.putIfAbsent(screen.getScreenLocation(),new HashSet<Events>());
        locationEventsMap.get(screen.getScreenLocation()).add(events);

    }

    public HashSet<Events> getEventsByLocation(String screenLocation) {
        return locationEventsMap.get(screenLocation);
    }

    public List<Show> getScreenShow(String screenName) {
        return screensMap.get(screenName).getShowList();
    }
}
