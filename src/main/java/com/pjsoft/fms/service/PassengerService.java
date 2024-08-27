package com.pjsoft.fms.service;

import com.pjsoft.fms.exception.ResourceNotFoundException;
import com.pjsoft.fms.model.Passenger;
import com.pjsoft.fms.repository.jpa.PassengerRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;

    private static final Logger logger = LoggerFactory.getLogger(PassengerService.class);

    // 1. Get All the passengers
    public List<Passenger> getAllPassengers(){
        return passengerRepository.findAll();
    }

    // 2. Get passenger details by id
    public Passenger getPassengerById(Long passengerId){
        // TODO : not able to handle the exception
        logger.debug("Please wait, Searching the passenger of given Id!");
        return passengerRepository.findById(passengerId)
                .orElseThrow(() -> new ResourceNotFoundException("Passenger not found with id: "+passengerId));
    }

    // 3. Save passenger details
    public Passenger savePassenger(@Valid Passenger passenger){
        return passengerRepository.save(passenger);
    }

    // Save all passengers details
//    public List<Passenger> saveAllPassengers(List<Passenger> passengerList){
//        return passengerRepository.saveAll(passengerList);
//    }

    // 4. Delete FLight details
    public void deletePassenger(long passengerId){
        passengerRepository.deleteById(passengerId);
    }


    public List<Passenger> getConfirmedPassengers(){ return passengerRepository.getConfirmedPassengers(); }

}
