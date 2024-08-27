package com.pjsoft.fms.model;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class ScheduledFlight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // many - scheduled flight for one flight
    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    // many - scheduled flight for one scedule
    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;
    @Column(nullable = false)
    private Integer availableSeats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }
}
