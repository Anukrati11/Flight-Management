package com.pjsoft.fms.dto;

import com.pjsoft.fms.model.Booking;
import com.pjsoft.fms.model.Flight;
import com.pjsoft.fms.model.Passenger;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PassengerBookingFlightDto {

    List<Passenger> passengerList;
    List<Booking> bookingsList;
    List<Flight> flightList;



    public PassengerBookingFlightDto(List<Passenger> passengerList, List<Booking> bookingsList, List<Flight> flightList) {
        this.passengerList = passengerList;
        this.bookingsList = bookingsList;
        this.flightList = flightList;
    }

    public PassengerBookingFlightDto() {

    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public List<Booking> getBookingsList() {
        return bookingsList;
    }

    public void setBookingsList(List<Booking> bookingsList) {
        this.bookingsList = bookingsList;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }
}
