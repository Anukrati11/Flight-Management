package com.pjsoft.fms.service;

import com.pjsoft.fms.exception.ResourceNotFoundException;
import com.pjsoft.fms.model.ScheduledFlight;
import com.pjsoft.fms.repository.jpa.ScheduledFlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduledFlightService {
    @Autowired
    private ScheduledFlightRepository scheduledFlightRepository;

    private static final Logger logger = LoggerFactory.getLogger(ScheduledFlightService.class);

    // 1. Get All the scheduledFlights
    public List<ScheduledFlight> getAllScheduledFlights(){
        return scheduledFlightRepository.findAll();
    }

    // 2. Get scheduledFlight details by id
    public ScheduledFlight getScheduledFlightsById(Long scheduledFlightId){
        logger.debug("Please wait, Searching the scheduledFlight of given Id!");
        return scheduledFlightRepository.findById(scheduledFlightId)
                .orElseThrow(() -> new ResourceNotFoundException("ScheduledFlight not found with id: "+scheduledFlightId));
    }

    // 3. Save scheduledFlight details
    public ScheduledFlight saveScheduledFlights(ScheduledFlight scheduledFlight){
        return scheduledFlightRepository.save(scheduledFlight);
    }

//    // Save all scheduledFlights details
//    public List<ScheduledFlight> saveAllScheduledFlights(List<ScheduledFlight> scheduledFlightList){
//        return scheduledFlightRepository.saveAll(scheduledFlightList);
//    }

    // 4. Delete FLight details
    public void deleteScheduledFlight(long scheduledFlightId){
        scheduledFlightRepository.deleteById(scheduledFlightId);
    }



}
