package com.pjsoft.fms.repository.jpa;

import com.pjsoft.fms.model.Flight;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FlightCriteriaRepository {

    @PersistenceContext
    EntityManager em;
    public List<Flight> findFlightsByCarrierNameAndSeatCapacity(String carrierName, int seatCapacity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Flight> cq = cb.createQuery(Flight.class);

        Root<Flight> flight = cq.from(Flight.class);
        // SQL wildcards
        Predicate carrierNamePredicate = cb.like(flight.get("carrierName"), "%" +carrierName+ "%");
        Predicate seatCapacityPredicate = cb.equal(flight.get("seatCapacity"),  seatCapacity );
        cq.where(carrierNamePredicate, seatCapacityPredicate);

        TypedQuery<Flight> query = em.createQuery(cq);
        return query.getResultList();
    }
}
