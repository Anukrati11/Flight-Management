package com.pjsoft.fms.repository.jpa;

import com.pjsoft.fms.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    // Native queries
    @Query(nativeQuery = true,
            value = "SELECT passenger_Id FROM Booking where status=:status")
    List<Long> findPassengerIdsByStatus(@Param("status") String status);
}
