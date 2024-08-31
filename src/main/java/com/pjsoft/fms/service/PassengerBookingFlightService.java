package com.pjsoft.fms.service;

import com.pjsoft.fms.dto.PassengerBookingFlightDto;
import com.pjsoft.fms.model.Booking;
import com.pjsoft.fms.model.Flight;
import com.pjsoft.fms.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class PassengerBookingFlightService {


    @Autowired
    private PassengerService passengerService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private FlightService flightService;

    /**
     * Extract all passengers booking and Flight Details concurrently via Completable Futures.
     */
    public PassengerBookingFlightDto extractAllPassengerBookingFlightDetails() throws ExecutionException, InterruptedException {

        PassengerBookingFlightDto passengerBookingFlightDto;

        // Fetch all data asynchronously
        CompletableFuture<List<Passenger>> passengersFuture = fetchAllPassengers();
        CompletableFuture<List<Booking>> bookingsFuture = fetchAllBookings();
        CompletableFuture<List<Flight>> flightsFuture = fetchAllFlights();

        // Wait for all futures to complete
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(passengersFuture, bookingsFuture, flightsFuture);

        // When all futures are done, create and return the DTO
        passengerBookingFlightDto = allFutures.thenApply(v -> {
            try {
                List<Passenger> passengers = passengersFuture.get();
                List<Booking> bookings = bookingsFuture.get();
                List<Flight> flights = flightsFuture.get();

                return new PassengerBookingFlightDto(passengers, bookings, flights);

            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Error fetching details", e);
            }
        }).get();

        return passengerBookingFlightDto;
    }

    public CompletableFuture<List<Passenger>> fetchAllPassengers(){

        final CompletableFuture<List<Passenger>> passengersCompletableFutures = CompletableFuture.supplyAsync(() -> {
            try {
                return passengerService.getAllPassengers();
            } catch (Exception e) {
                // Handle any exception while fetching passenger details
                System.err.println("Error fetching passengers" + " - " + e.getMessage());
                return null; // Return null in case of error
            }
        });

        return passengersCompletableFutures;
    }

    public CompletableFuture<List<Booking>> fetchAllBookings(){

        final CompletableFuture<List<Booking>> bookingsCompletableFutures = CompletableFuture.supplyAsync(() -> {
            try {
                return bookingService.getAllBookings();
            } catch (Exception e) {
                // Handle any exception while fetching bookings details
                System.err.println("Error fetching bookings" + " - " + e.getMessage());
                return null; // Return null in case of error
            }
        });
        return bookingsCompletableFutures;
    }

    public CompletableFuture<List<Flight>> fetchAllFlights(){

        final CompletableFuture<List<Flight>> flightsCompletableFutures = CompletableFuture.supplyAsync(() -> {
            try {
                return flightService.getAllFlights(0,10);
            } catch (Exception e) {
                // Handle any exception while fetching flights details
                System.err.println("Error fetching flights" + " - " + e.getMessage());
                return null; // Return null in case of error
            }
        });

        return flightsCompletableFutures;
    }
}
