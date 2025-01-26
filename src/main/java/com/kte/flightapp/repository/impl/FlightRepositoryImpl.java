package com.kte.flightapp.repository.impl;

import com.kte.flightapp.modells.Criteria.FlightCriteria;
import com.kte.flightapp.modells.entity.Flight;
import com.kte.flightapp.repository.FlightRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;


import java.util.ArrayList;
import java.util.List;

public class FlightRepositoryImpl implements FlightRepositoryCustom {


    private EntityManager entityManager;

    @Override
    public List<Flight> searchFlight(FlightCriteria flightCriteria) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Flight> query = criteriaBuilder.createQuery(Flight.class);
        Root<Flight> flightRoot = query.from(Flight.class);
        List<Predicate> predicates = new ArrayList<>();

        if (flightCriteria.getCompany() != null) {
            predicates.add(criteriaBuilder.equal(flightRoot.get("company").get("companyName"), flightCriteria.getCompany()));
        }

        if (flightCriteria.getFlightType() != null) {
            predicates.add(criteriaBuilder.equal(flightRoot.get("flightType"), flightCriteria.getFlightType()));
        }

        if (flightCriteria.getTravelType() != null) {
            predicates.add(criteriaBuilder.equal(flightRoot.get("travelType"), flightCriteria.getTravelType()));
        }

        query.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(query).getResultList();
    }
}
