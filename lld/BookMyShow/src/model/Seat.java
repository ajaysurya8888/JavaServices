package model;

import java.util.Map;

public class Seat {
    int seatId;

    int seatNumber;
    char seatRow;
    Map<String,Integer> screenTypeCostMap;

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public char getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(char seatRow) {
        this.seatRow = seatRow;
    }

    public Map<String, Integer> getScreenTypeCostMap() {
        return screenTypeCostMap;
    }

    public void setScreenTypeCostMap(Map<String, Integer> screenTypeCostMap) {
        this.screenTypeCostMap = screenTypeCostMap;
    }

}
