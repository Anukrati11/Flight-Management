package com.pjsoft.fms.repository.jpa;

import com.pjsoft.fms.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
