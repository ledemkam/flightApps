package com.kte.flightapp.repository.impl;

import com.kte.flightapp.modells.Criteria.FlightCriteria;
import com.kte.flightapp.modells.Criteria.SynthesisCriteria;
import com.kte.flightapp.modells.entity.Flight;
import com.kte.flightapp.repository.FlightRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;


import java.util.ArrayList;
import java.util.List;

public class FlightRepositoryImpl implements FlightRepositoryCustom {

    @PersistenceContext
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

        if (flightCriteria.getDepartureLocation() != null) {
            predicates.add(criteriaBuilder.equal(flightRoot.get("departureLocation"),"%" + flightCriteria.getDepartureLocation()));
        }

        if(flightCriteria.getAircraftType() != null){
            predicates.add(criteriaBuilder.equal(flightRoot.get("aircraftType"), "%" + flightCriteria.getAircraftType()));
        }

        if (flightCriteria.getDepartureDateMax() != null) {
            predicates.add(criteriaBuilder.lessThan(flightRoot.get("departureDate"), flightCriteria.getDepartureDateMax()));
        }

        if (flightCriteria.getDepartureDateMin() != null) {
            predicates.add(criteriaBuilder.greaterThan(flightRoot.get("departureDate"), flightCriteria.getDepartureDateMin()));
        }

        if (flightCriteria.getDepartureTimeMax() != null) {
            predicates.add(criteriaBuilder.lessThan(flightRoot.get("departureTime"), flightCriteria.getDepartureTimeMax()));
        }

        if (flightCriteria.getDepartureTimeMin() != null) {
            predicates.add(criteriaBuilder.greaterThan(flightRoot.get("departureTime"), flightCriteria.getDepartureTimeMin()));
        }

        if (flightCriteria.getArrivalDateMax() != null) {
            predicates.add(criteriaBuilder.equal(flightRoot.get("arrivalDate"),   flightCriteria.getArrivalDateMax()));
        }

        if (flightCriteria.getArrivalDateMin() != null) {
            predicates.add(criteriaBuilder.equal(flightRoot.get("arrivalDate"),  flightCriteria.getArrivalDateMin()));
        }

        if (flightCriteria.getArrivalTimeMax() != null) {
            predicates.add(criteriaBuilder.lessThan(flightRoot.get("arrivalTime"), flightCriteria.getArrivalTimeMax()));
        }

        if (flightCriteria.getArrivalTimeMin() != null) {
            predicates.add(criteriaBuilder.greaterThan(flightRoot.get("arrivalTime"), flightCriteria.getArrivalTimeMin()));
        }

        if (flightCriteria.getBackDateMax() != null) {
            predicates.add(criteriaBuilder.equal(flightRoot.get("backDate"),  flightCriteria.getBackDateMax()));
        }

        if (flightCriteria.getBackDateMin() != null) {
            predicates.add(criteriaBuilder.equal(flightRoot.get("backDate"), flightCriteria.getBackDateMin()));
        }

        if (flightCriteria.getBackTimeMax() != null) {
            predicates.add(criteriaBuilder.lessThan(flightRoot.get("backTime"), flightCriteria.getBackTimeMax()));
        }

        if (flightCriteria.getBackTimeMin() != null) {
            predicates.add(criteriaBuilder.greaterThan(flightRoot.get("backTime"), flightCriteria.getBackTimeMin()));
        }

        if (flightCriteria.getConnectionDurationMax() != null) {
            predicates.add(criteriaBuilder.lessThan(flightRoot.get("connectionDuration"), flightCriteria.getConnectionDurationMax()));
        }

        if (flightCriteria.getConnectionDurationMin() != null) {
            predicates.add(criteriaBuilder.greaterThan(flightRoot.get("connectionDuration"), flightCriteria.getConnectionDurationMin()));
        }

        query.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Long getNumberOfFlights(SynthesisCriteria synthesisCriteria) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);
        Root<Flight> flightRoot = query.from(Flight.class);
        query.select(criteriaBuilder.count(flightRoot));
        List<Predicate> predicates = new ArrayList<>();

        if (synthesisCriteria.getDepartureDateMax() != null) {
            predicates.add(criteriaBuilder.lessThan(flightRoot.get("departureDate"), synthesisCriteria.getDepartureDateMax()));
        }

        if (synthesisCriteria.getDepartureDateMin() != null) {
            predicates.add(criteriaBuilder.greaterThan(flightRoot.get("departureDate"), synthesisCriteria.getDepartureDateMin()));
        }

        query.select(criteriaBuilder.count(flightRoot)).where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(query).getSingleResult();
    }
}
