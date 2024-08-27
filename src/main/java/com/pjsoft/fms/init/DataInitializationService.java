package com.pjsoft.fms.init;

import com.pjsoft.fms.model.*;
import com.pjsoft.fms.repository.jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class DataInitializationService {

    private final AirportRepository airportRepository;
    private final FlightRepository flightRepository;
    private final PassengerRepository passengerRepository;
    private final ScheduleRepository scheduleRepository;
    private final ScheduledFlightRepository scheduledFlightRepository;
    private final BookingRepository bookingRepository;

    @Autowired
    public DataInitializationService(AirportRepository airportRepository,
                                     FlightRepository flightRepository,
                                     PassengerRepository passengerRepository,
                                     ScheduleRepository scheduleRepository,
                                     ScheduledFlightRepository scheduledFlightRepository,
                                     BookingRepository bookingRepository) {
        this.airportRepository = airportRepository;
        this.flightRepository = flightRepository;
        this.passengerRepository = passengerRepository;
        this.scheduleRepository = scheduleRepository;
        this.scheduledFlightRepository = scheduledFlightRepository;
        this.bookingRepository = bookingRepository;
    }

    @PostConstruct
    public void initializeData() {
        // Initialize Airports
        Airport jfk = new Airport();
        jfk.setCode("JFK");
        jfk.setName("John F. Kennedy International Airport");
        jfk.setCity("New York");
        jfk.setCountry("USA");
        jfk.setLatitude(40.6413);
        jfk.setLongitude(-73.7781);

        Airport lax = new Airport();
        lax.setCode("LAX");
        lax.setName("Los Angeles International Airport");
        lax.setCity("Los Angeles");
        lax.setCountry("USA");
        lax.setLatitude(33.9416);
        lax.setLongitude(-118.4085);

        Airport ord = new Airport();
        ord.setCode("ORD");
        ord.setName("O'Hare International Airport");
        ord.setCity("Chicago");
        ord.setCountry("USA");
        ord.setLatitude(41.9742);
        ord.setLongitude(-87.9073);

        Airport dfw = new Airport();
        dfw.setCode("DFW");
        dfw.setName("Dallas/Fort Worth International Airport");
        dfw.setCity("Dallas");
        dfw.setCountry("USA");
        dfw.setLatitude(32.8998);
        dfw.setLongitude(-97.0403);

        Airport sfo = new Airport();
        sfo.setCode("SFO");
        sfo.setName("San Francisco International Airport");
        sfo.setCity("San Francisco");
        sfo.setCountry("USA");
        sfo.setLatitude(37.6213);
        sfo.setLongitude(-122.3790);

        airportRepository.save(jfk);
        airportRepository.save(lax);
        airportRepository.save(ord);
        airportRepository.save(dfw);
        airportRepository.save(sfo);

        // Initialize Flights
        Flight flight1 = new Flight();
        flight1.setFlightNo(new BigInteger("12345"));
        flight1.setCarrierName("Delta Airlines");
        flight1.setFlightModel("Boeing 737");
        flight1.setSeatCapacity(200);

        Flight flight2 = new Flight();
        flight2.setFlightNo(new BigInteger("67890"));
        flight2.setCarrierName("United Airlines");
        flight2.setFlightModel("Airbus A320");
        flight2.setSeatCapacity(180);

        Flight flight3 = new Flight();
        flight3.setFlightNo(new BigInteger("54321"));
        flight3.setCarrierName("American Airlines");
        flight3.setFlightModel("Boeing 787");
        flight3.setSeatCapacity(250);

        Flight flight4 = new Flight();
        flight4.setFlightNo(new BigInteger("98765"));
        flight4.setCarrierName("Southwest Airlines");
        flight4.setFlightModel("Boeing 737");
        flight4.setSeatCapacity(190);

        Flight flight5 = new Flight();
        flight5.setFlightNo(new BigInteger("13579"));
        flight5.setCarrierName("JetBlue Airways");
        flight5.setFlightModel("Airbus A321");
        flight5.setSeatCapacity(200);

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);
        flightRepository.save(flight4);
        flightRepository.save(flight5);

        // Initialize Passengers
        Passenger passenger1 = new Passenger();
        passenger1.setFirstName("John");
        passenger1.setLastName("Doe");
        passenger1.setEmail("john.doe@example.com");
        passenger1.setPhone("1234567890");
        passenger1.setDateOfBirth(LocalDate.of(1990, 5, 15));

        Passenger passenger2 = new Passenger();
        passenger2.setFirstName("Jane");
        passenger2.setLastName("Smith");
        passenger2.setEmail("jane.smith@example.com");
        passenger2.setPhone("9876543210");
        passenger2.setDateOfBirth(LocalDate.of(1995, 8, 20));

        Passenger passenger3 = new Passenger();
        passenger3.setFirstName("Alice");
        passenger3.setLastName("Johnson");
        passenger3.setEmail("alice.johnson@example.com");
        passenger3.setPhone("5551234567");
        passenger3.setDateOfBirth(LocalDate.of(1988, 3, 10));

        Passenger passenger4 = new Passenger();
        passenger4.setFirstName("Bob");
        passenger4.setLastName("Brown");
        passenger4.setEmail("bob.brown@example.com");
        passenger4.setPhone("4449876543");
        passenger4.setDateOfBirth(LocalDate.of(1985, 7, 25));

        Passenger passenger5 = new Passenger();
        passenger5.setFirstName("Charlie");
        passenger5.setLastName("Davis");
        passenger5.setEmail("charlie.davis@example.com");
        passenger5.setPhone("6665554444");
        passenger5.setDateOfBirth(LocalDate.of(1992, 12, 30));

        passengerRepository.save(passenger1);
        passengerRepository.save(passenger2);
        passengerRepository.save(passenger3);
        passengerRepository.save(passenger4);
        passengerRepository.save(passenger5);

        // Initialize Schedules
        Schedule schedule1 = new Schedule();
        schedule1.setDepartureTime(LocalDateTime.now().plusDays(1));
        schedule1.setArrivalTime(LocalDateTime.now().plusDays(1).plusHours(3));
        schedule1.setDepartureAirport(jfk);
        schedule1.setArrivalAirport(lax);

        Schedule schedule2 = new Schedule();
        schedule2.setDepartureTime(LocalDateTime.now().plusDays(2));
        schedule2.setArrivalTime(LocalDateTime.now().plusDays(2).plusHours(4));
        schedule2.setDepartureAirport(lax);
        schedule2.setArrivalAirport(jfk);

        Schedule schedule3 = new Schedule();
        schedule3.setDepartureTime(LocalDateTime.now().plusDays(3));
        schedule3.setArrivalTime(LocalDateTime.now().plusDays(3).plusHours(5));
        schedule3.setDepartureAirport(ord);
        schedule3.setArrivalAirport(dfw);

        Schedule schedule4 = new Schedule();
        schedule4.setDepartureTime(LocalDateTime.now().plusDays(4));
        schedule4.setArrivalTime(LocalDateTime.now().plusDays(4).plusHours(6));
        schedule4.setDepartureAirport(dfw);
        schedule4.setArrivalAirport(sfo);

        Schedule schedule5 = new Schedule();
        schedule5.setDepartureTime(LocalDateTime.now().plusDays(5));
        schedule5.setArrivalTime(LocalDateTime.now().plusDays(5).plusHours(7));
        schedule5.setDepartureAirport(sfo);
        schedule5.setArrivalAirport(jfk);

        scheduleRepository.save(schedule1);
        scheduleRepository.save(schedule2);
        scheduleRepository.save(schedule3);
        scheduleRepository.save(schedule4);
        scheduleRepository.save(schedule5);

        // Initialize Scheduled Flights
        ScheduledFlight scheduledFlight1 = new ScheduledFlight();
        scheduledFlight1.setFlight(flight1);
        scheduledFlight1.setSchedule(schedule1);
        scheduledFlight1.setAvailableSeats(180);

        ScheduledFlight scheduledFlight2 = new ScheduledFlight();
        scheduledFlight2.setFlight(flight2);
        scheduledFlight2.setSchedule(schedule2);
        scheduledFlight2.setAvailableSeats(160);

        ScheduledFlight scheduledFlight3 = new ScheduledFlight();
        scheduledFlight3.setFlight(flight3);
        scheduledFlight3.setSchedule(schedule3);
        scheduledFlight3.setAvailableSeats(230);

        ScheduledFlight scheduledFlight4 = new ScheduledFlight();
        scheduledFlight4.setFlight(flight4);
        scheduledFlight4.setSchedule(schedule4);
        scheduledFlight4.setAvailableSeats(170);

        ScheduledFlight scheduledFlight5 = new ScheduledFlight();
        scheduledFlight5.setFlight(flight5);
        scheduledFlight5.setSchedule(schedule5);
        scheduledFlight5.setAvailableSeats(180);

        scheduledFlightRepository.save(scheduledFlight1);
        scheduledFlightRepository.save(scheduledFlight2);
        scheduledFlightRepository.save(scheduledFlight3);
        scheduledFlightRepository.save(scheduledFlight4);
        scheduledFlightRepository.save(scheduledFlight5);

        // Initialize Bookings
        Booking booking1 = new Booking();
        booking1.setBookingDate(LocalDateTime.now());
        booking1.setPassenger(passenger1);
        booking1.setScheduledFlight(scheduledFlight1);
        booking1.setStatus("Confirmed");

        Booking booking2 = new Booking();
        booking2.setBookingDate(LocalDateTime.now().minusDays(1));
        booking2.setPassenger(passenger2);
        booking2.setScheduledFlight(scheduledFlight2);
        booking2.setStatus("Confirmed");

        Booking booking3 = new Booking();
        booking3.setBookingDate(LocalDateTime.now().minusDays(2));
        booking3.setPassenger(passenger3);
        booking3.setScheduledFlight(scheduledFlight3);
        booking3.setStatus("Cancelled");

        Booking booking4 = new Booking();
        booking4.setBookingDate(LocalDateTime.now().minusDays(3));
        booking4.setPassenger(passenger4);
        booking4.setScheduledFlight(scheduledFlight4);
        booking4.setStatus("Pending");

        Booking booking5 = new Booking();
        booking5.setBookingDate(LocalDateTime.now().minusDays(4));
        booking5.setPassenger(passenger5);
        booking5.setScheduledFlight(scheduledFlight5);
        booking5.setStatus("Confirmed");

        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);
        bookingRepository.save(booking4);
        bookingRepository.save(booking5);
    }
}