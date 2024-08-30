package com.pjsoft.fms.controller;

import com.pjsoft.fms.dto.PassengerBookingFlightDto;
import com.pjsoft.fms.model.Passenger;
import com.pjsoft.fms.service.PassengerBookingFlightService;
import com.pjsoft.fms.service.PassengerBookingService;
import com.pjsoft.fms.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/passenger")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private PassengerBookingService passengerBookingService;

    @Autowired
    private PassengerBookingFlightService passengerBookingFlightService;

    // 1. Get All the passengers
    @GetMapping
    public List<Passenger> getAllPassengers(){
        return passengerService.getAllPassengers();
    }

    // 2. Get passenger details by id
//    @GetMapping("/{id}")
//    public ResponseEntity<Object> getPassengerById(@PathVariable Long id){
//        Passenger passenger = passengerService.getPassengerById(id);
//        return ResponseEntity.ok(passenger);
//    }
    @GetMapping("/{id}")
    public Passenger getPassengerById(@PathVariable Long id){
        return passengerService.getPassengerById(id);
    }

    // 3. Create and save passenger details
    @PostMapping
    public Passenger createPassenger(@RequestBody Passenger passenger){
        return passengerService.savePassenger(passenger);
    }

    // 4. Create and save multiple passenger details
//    @PostMapping
//    public List<Passenger> createAllPassengers(@RequestBody List<Passenger> passengerLists){
//        return passengerService.saveAllPassengers(passengerLists);
//    }

    // 4. Update passenger details
    @PutMapping("/{id}")
    public Passenger updatePassenger(@PathVariable Long id, @RequestBody Passenger passenger){
        passenger.setId(id);
        return passengerService.savePassenger(passenger);
    }

    // 5. Delete Passenger details
    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable Long id){
        passengerService.deletePassenger(id);
    }

    @GetMapping("/getConfirmedPassenger")
    public List<Passenger> getConfirmedPassengers(){ return passengerService.getConfirmedPassengers(); }

    @PostMapping("/getPassengerByStatus")
    public List<Passenger> getPassengerByStatus(@RequestParam(value="status", defaultValue = "Confirmed", required = false)String status) throws ExecutionException {
        return passengerBookingService.getAllPassengersByBookingStatusAsych(status);
    }

    @PostMapping("/getAllPassengersFlightsBookings")
    public PassengerBookingFlightDto getAllPassengersFlightsBookings() throws ExecutionException, InterruptedException {
        return passengerBookingFlightService.extractAllPassengerBookingFlightDetails();
    }

}
