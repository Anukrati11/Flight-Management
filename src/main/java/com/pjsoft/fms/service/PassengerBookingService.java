package com.pjsoft.fms.service;

import com.pjsoft.fms.model.Passenger;
import io.jsonwebtoken.lang.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class PassengerBookingService {

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private BookingService bookingService;

    /**
     * Performance improvement using CompletableFuture to fetch passenger details asynchronously based on the booking status.
     * This will allow the passenger data to be fetched in parallel, leading to better performance.
     * @param status
     */
    public List<Passenger> getAllPassengersByBookingStatusAsych(String status) throws ExecutionException {

        // Get list of passenger IDs based on the booking status
        final List<Long> passengerIdList = bookingService.findPassengerIdsByStatus(status);
        final List<CompletableFuture<Passenger>> passengerFutures = new ArrayList<>();
        List<Passenger> allPassengers = new ArrayList<>();

        if(!Collections.isEmpty(passengerIdList)){
            for(Long id: passengerIdList){
                // Fetch passenger details asynchronously
                final CompletableFuture<Passenger> passengerCompletableFutures = CompletableFuture.supplyAsync(
                        () -> {
                            try {
                                return passengerService.getPassengerById(id);
                            } catch (Exception e) {
                                // Handle any exception while fetching passenger details
                                System.err.println("Error fetching passenger with ID: " + id + " - " + e.getMessage());
                                return null; // Return null in case of error
                            }
                        });

                // Add the future to the list
                passengerFutures.add(passengerCompletableFutures);
            }

            // Wait for all futures to complete and collect the results
            //The CompletableFuture.allOf() method is used to combine all the futures into a single CompletableFuture that completes when all the individual futures are complete.
            CompletableFuture<List<Passenger>> allPassengersFuture = CompletableFuture.allOf(passengerFutures.toArray(new CompletableFuture[0]))
                    .thenApply(v -> passengerFutures.stream() // Once all the tasks are complete, the thenApply callback is invoked. This callback uses stream and map to call join() on each future, converting it from a CompletableFuture<Passenger> to Passenger.
                            .map(CompletableFuture::join) // Wait for each future to complete.It waits for the future to complete and then returns its result. Unlike get(), join() does not throw a checked exception, so it simplifies the code.
                            .collect(Collectors.toList()));

            // Process the result
            try {
                allPassengers = allPassengersFuture.get(); // Blocking call to get the result
                return allPassengers;
            } catch (InterruptedException | ExecutionException e) {
                throw new ExecutionException("Error occurred while processing all passengers: ", e);
            }
        }
        return allPassengers;

    }



}
