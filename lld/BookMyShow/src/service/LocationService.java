package service;

import model.Location;

import java.util.*;

public class LocationService {

    private Map<Long,String> locationMap = new HashMap<Long,String>();
    private Map<String, String> eventLocationMap = new HashMap<>();
    private Long nextId = 1L;
    public void addLocation(String locationName) {
        Location location = new Location(nextId,locationName);
        locationMap.put(nextId++,locationName);


    }

    public Collection<String> getAllLocation() {
        return locationMap.values();
    }

}
