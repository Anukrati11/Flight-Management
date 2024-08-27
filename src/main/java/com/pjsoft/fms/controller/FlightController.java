package com.pjsoft.fms.controller;

import com.pjsoft.fms.model.Flight;
import com.pjsoft.fms.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    // 1. Get All the flights - pagination applied
    @GetMapping
    public List<Flight> getAllFlights(@RequestParam(value="pageNumber", defaultValue = "0",required = false) int pageNumber, @RequestParam(value = "pageSize",defaultValue = "5", required = false) int pageSize){
        return flightService.getAllFlights(pageNumber, pageSize);
    }

    // 2. Get flight details by id
//    @GetMapping("/{id}")
//    public ResponseEntity<Object> getFlightById(@PathVariable Long id){
//        Flight flight = flightService.getFlightById(id);
//        return ResponseEntity.ok(flight);
//    }
    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable Long id){
        return flightService.getFlightById(id);
    }

    // 3. Create and save flight details
    @PatchMapping
    public Flight createFlight(@RequestBody Flight flight){
        return flightService.saveFlight(flight);
    }

    // 4. Create and save multiple flight details
    @PostMapping
    public List<Flight> createAllFlights(@RequestBody List<Flight> flightLists){
        return flightService.saveAllFlights(flightLists);
    }

    // 4. Update flight details
    @PutMapping("/{id}")
    public Flight updateFlight(@PathVariable Long id, @RequestBody Flight flight){
        flight.setId(id);
        return flightService.saveFlight(flight);
    }

    // 5. Delete Flight details
    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Long id){
        flightService.deleteFlight(id);
    }

    // Native Query
    @GetMapping("/maxSeat")
    public Integer getMaxSeat(){
        return flightService.getMaxSeat();
    }

    // criteria query
    @GetMapping("/flightByNameAndCapacity/{carrierName}/{seatCapacity}")
    public List<Flight> findFlightsByCarrierNameAndSeatCapacity(@PathVariable String carrierName, @PathVariable int seatCapacity){
        return flightService.findFlightsByCarrierNameAndSeatCapacity(carrierName, seatCapacity);
    }
}
