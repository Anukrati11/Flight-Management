package com.pjsoft.fms.repository.jpa;

import com.pjsoft.fms.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {

    // Criteria Query, Join, Native Queries, Pagination
}
