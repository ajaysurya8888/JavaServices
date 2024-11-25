package controller;

import service.LocationService;

import java.util.Collection;
import java.util.List;

public class LocationController {
    LocationService locationService = new LocationService();

    public void addLocation(String locationName){
        locationService.addLocation(locationName);
    }

    public Collection<String> showAllLocation(){
       return locationService.getAllLocation();
    }
}
