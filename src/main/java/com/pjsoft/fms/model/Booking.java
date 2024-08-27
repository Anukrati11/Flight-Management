package com.pjsoft.fms.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime bookingDate;
    @Column(nullable = false)
    private String status;

    // One passenger can have many bookings, so many = booking and one is passenger
    @ManyToOne
    @JoinColumn(name = "passenger_id", nullable = false)
    private Passenger passenger;

    // One ScheduledFlight can have many bookings, so many = booking and one is ScheduledFlight
    @ManyToOne
    @JoinColumn(name = "scheduled_flight_id", nullable = false)
    private ScheduledFlight scheduledFlight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public ScheduledFlight getScheduledFlight() {
        return scheduledFlight;
    }

    public void setScheduledFlight(ScheduledFlight scheduledFlight) {
        this.scheduledFlight = scheduledFlight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
