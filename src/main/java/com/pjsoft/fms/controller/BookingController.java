package com.pjsoft.fms.controller;

import com.pjsoft.fms.model.Booking;
import com.pjsoft.fms.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // 1. Get All the bookings
    @GetMapping
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    // 2. Get booking details by id
//    @GetMapping("/{id}")
//    public ResponseEntity<Object> getBookingById(@PathVariable Long id){
//        Booking booking = bookingService.getBookingById(id);
//        return ResponseEntity.ok(booking);
//    }
    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id){
        return bookingService.getBookingById(id);
    }

    // 3. Create and save booking details
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking){
        return bookingService.saveBooking(booking);
    }

    // 4. Create and save multiple booking details
//    @PostMapping
//    public List<Booking> createAllBookings(@RequestBody List<Booking> bookingLists){
//        return bookingService.saveAllBookings(bookingLists);
//    }

    // 4. Update booking details
    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable Long id, @RequestBody Booking booking){
        booking.setId(id);
        return bookingService.saveBooking(booking);
    }

    // 5. Delete Booking details
    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id){
        bookingService.deleteBooking(id);
    }
}
