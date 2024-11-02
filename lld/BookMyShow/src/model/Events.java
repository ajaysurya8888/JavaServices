package model;

import enums.Genre;

public class Events {
    int EventId;
    String EventName;

    String Duration;
    Genre genre;

    public Events(int eventId, String eventName, String duration, Genre genre) {
        this.EventId = eventId;
        this.EventName = eventName;
        this.Duration = duration;
        this.genre = genre;
    }

    public int getEventId() {
        return EventId;
    }

    public void setEventId(int eventId) {
        EventId = eventId;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
