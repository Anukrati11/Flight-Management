package com.pjsoft.fms.service;

import com.pjsoft.fms.exception.ResourceNotFoundException;
import com.pjsoft.fms.model.Airport;
import com.pjsoft.fms.repository.jpa.AirportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// Business logic layer classes, ideally one interface and then impl
@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;

    private static final Logger logger = LoggerFactory.getLogger(AirportService.class);

    // 1. Get All the airports
    public List<Airport> getAllAirports(){
        return airportRepository.findAll();
    }

    // 2. Get airport details by id
    public Airport getAirportById(Long airportId){
        logger.debug("Please wait, Searching the airport of given Id!");
        return airportRepository.findById(airportId)
                .orElseThrow(() -> new ResourceNotFoundException("Airport not founf with id: "+airportId));
    }

    // 3. Save airport details
    public Airport saveAirport(Airport airport){
        return airportRepository.save(airport);
    }

    // Save multiple airports details
    public List<Airport> saveAllAirports(List<Airport> airportList){
        return airportRepository.saveAll(airportList);
    }

    // 4. Delete airport details
    public void deleteAirport(long airportId){
        airportRepository.deleteById(airportId);
    }



}
