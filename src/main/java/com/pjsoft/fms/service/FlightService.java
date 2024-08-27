package com.pjsoft.fms.service;

import com.pjsoft.fms.exception.*;
import com.pjsoft.fms.model.Flight;
import com.pjsoft.fms.repository.jpa.FlightCriteriaRepository;
import com.pjsoft.fms.repository.jpa.FlightRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightCriteriaRepository flightCriteriaRepository;

    private static final Logger logger = LoggerFactory.getLogger(FlightService.class);

    // 1. Get All the flights
    public List<Flight> getAllFlights(int pageNumber, int pageSize){
        // Pageable object
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return flightRepository.findAll(pageable).getContent();
    }

    // 2. Get flight details by id
    public Flight getFlightById(Long flightId){
        logger.debug("Please wait, Searching the flight of given Id!");
        return flightRepository.findById(flightId)
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found with id: "+flightId));
    }

    // 3. Save flight details
    public Flight saveFlight(Flight flight){
        return flightRepository.save(flight);
    }

    // Save all flights details
    public List<Flight> saveAllFlights(List<Flight> flightList){
        return flightRepository.saveAll(flightList);
    }

    // 4. Delete FLight details
    public void deleteFlight(long flightId){
        flightRepository.deleteById(flightId);
    }

    // Native Query
    public Integer getMaxSeat(){
        return flightRepository.getMaxSeat();
    }

    // criteria - custom query
    public List<Flight> findFlightsByCarrierNameAndSeatCapacity(String carrierName, int seatCapacity){
        return flightCriteriaRepository.findFlightsByCarrierNameAndSeatCapacity(carrierName, seatCapacity);
    }



}
