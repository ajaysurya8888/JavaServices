package model;

import java.util.List;

public class Booking {

    int bookingId;

    int bookingSeats;
    List<Seat> occupiedSeats;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getBookingSeats() {
        return bookingSeats;
    }

    public void setBookingSeats(int bookingSeats) {
        this.bookingSeats = bookingSeats;
    }

    public List<Seat> getOccupiedSeats() {
        return occupiedSeats;
    }

    public void setOccupiedSeats(List<Seat> occupiedSeats) {
        this.occupiedSeats = occupiedSeats;
    }

}
