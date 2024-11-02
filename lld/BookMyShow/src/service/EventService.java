package service;

import enums.Genre;
import model.Events;

import java.util.HashMap;
import java.util.Map;

public class EventService {
    Map<String,Events> eventMap = new HashMap<String,Events>();
    public void addEvent(int eventId, String eventName, String duration, Genre genre) {
        Events events = new Events(eventId,eventName,duration,genre);
        eventMap.put(eventName,events);
    }

    public Events getEvent(String eventName) {
        return eventMap.get(eventName);
    }

}
