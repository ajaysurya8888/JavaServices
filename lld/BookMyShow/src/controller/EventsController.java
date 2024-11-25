package controller;

import enums.Genre;
import model.Events;
import service.EventService;

import java.util.HashMap;
import java.util.Map;

public class EventsController {
    EventService eventService = new EventService();

    int eventId = 1;
    public void addEvent(String eventName, String duration, Genre genre) {
        eventService.addEvent(eventId,eventName, duration,genre);
    }

    public Events getEvent(String eventName) {
        return eventService.getEvent(eventName);
    }
}
