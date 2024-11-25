package model;

import java.util.List;

public class Location {
    Long locationId;
    String locationName;
    List<Integer> eventListInLocation;
    List<Integer> screenListInLocation;

    public Location(Long locationId, String locationName) {
        this.locationId = locationId;
        this.locationName = locationName;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public List<Integer> getEventListInLocation() {
        return eventListInLocation;
    }

    public void setEventListInLocation(List<Integer> eventListInLocation) {
        this.eventListInLocation = eventListInLocation;
    }

    public List<Integer> getScreenListInLocation() {
        return screenListInLocation;
    }

    public void setScreenListInLocation(List<Integer> screenListInLocation) {
        this.screenListInLocation = screenListInLocation;
    }

}
