package com.pjsoft.fms.repository.jpa;

import com.pjsoft.fms.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    //@Param("Id") int flightId
    @Query(nativeQuery = true,
            value = " SELECT p.* \n" +
                    "FROM Booking b left join Passenger as p on p.id=b.PASSENGER_ID \n" +
                    "where status='Confirmed'")
    List<Passenger> getConfirmedPassengers();
}
