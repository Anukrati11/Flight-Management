package com.pjsoft.fms.service;

import com.pjsoft.fms.exception.ResourceNotFoundException;
import com.pjsoft.fms.model.Booking;
import com.pjsoft.fms.repository.jpa.BookingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);

    // 1. Get All the bookings
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    // 2. Get booking details by id
    public Booking getBookingById(Long bookingId){
        logger.debug("Please wait, Searching the booking of given Id!");
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: "+bookingId));
    }

    // 3. Save booking details
    public Booking saveBooking(Booking booking){
        return bookingRepository.save(booking);
    }

    // Save all bookings details
//    public List<Booking> saveAllBookings(List<Booking> bookingList){
//        return bookingRepository.saveAll(bookingList);
//    }

    // 4. Delete FLight details
    public void deleteBooking(long bookingId){
        bookingRepository.deleteById(bookingId);
    }

    public List<Long> findPassengerIdsByStatus(String status){
        return bookingRepository.findPassengerIdsByStatus(status);
    }


}
