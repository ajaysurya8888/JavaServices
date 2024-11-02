import controller.EventsController;
import controller.LocationController;
import controller.ScreenController;
import enums.Genre;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        //add 2  location
LocationController locationController = new LocationController();
locationController.addLocation("chennai");
locationController.addLocation("bengalore");

//get all location

       System.out.println("select any location\n"+locationController.showAllLocation());

        //add 2 event
        EventsController eventsController = new EventsController();
        eventsController.addEvent("amaran","2:30", Genre.Thriller);
        eventsController.addEvent("bloddybeggar","2:30", Genre.Thriller);
        eventsController.addEvent("brother","2:30", Genre.Thriller);
        String location = "chennai";


        //add 2 screen
        ScreenController screenController = new ScreenController();
        screenController.addScreen("lathangi","chennai","udumalpet", Arrays.asList("9:15","12:30","3:30"));
        screenController.addScreen("anusham","chennai","udumalpet",Arrays.asList("9:15","12:30","3:30"));
        screenController.addScreen("pvr","bangalore","greenfield",Arrays.asList("9:15","12:30","3:30"));
        screenController.addScreen("inox","bangalore","whitefield",Arrays.asList("9:15","12:30","3:30"));

        //add events to screen
        screenController.addEventToScreen("lathangi",eventsController.getEvent("amaran"),Arrays.asList("9:15","12:30"));
     screenController.addEventToScreen("anusham",eventsController.getEvent("amaran"),Arrays.asList("9:15","12:30","3:30"));
     screenController.addEventToScreen("anusham",eventsController.getEvent("brother"),Arrays.asList("9:15","12:30","3:30"));
        //show event in location
     System.out.println("show  event in " +location);
        screenController.getEventsByLocation(location);
     System.out.println(screenController.getEventsByLocation(location).stream()
             .map(name -> name.getEventName())
             .collect(Collectors.toList()));
    String eventName = "amaran";

     System.out.println("screens in "+ location+" which shows "+ eventName);
     System.out.println(screenController.getScreenByLocation(location).stream()
                     .filter(name-> name.getScreenEvent().getEventName().equals(eventName))
                     .map(name -> name.getScreenName())
                     .collect(Collectors.toList()));
     String screenName = "lathangi";
        // get show timing for a screen

        System.out.println("get showtiming for the screen+"+screenName);
        System.out.println(screenController.getShowTime(screenName).stream().map(name->name.getshowTime()).collect(Collectors.toList()));
    }
}
