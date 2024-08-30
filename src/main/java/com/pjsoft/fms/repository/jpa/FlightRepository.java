package com.pjsoft.fms.repository.jpa;

import com.pjsoft.fms.model.Flight;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Long> {


    // Native queries
    @Query(nativeQuery = true,
           value = "SELECT max(SEAT_CAPACITY) FROM FLIGHT")
    Integer getMaxSeat();




}
