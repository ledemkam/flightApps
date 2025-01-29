package com.kte.flightapp.repository;

import com.kte.flightapp.modells.Criteria.FlightCriteria;
import com.kte.flightapp.modells.Criteria.SynthesisCriteria;
import com.kte.flightapp.modells.entity.Flight;

import java.util.List;

public interface FlightRepositoryCustom {
    List<Flight> searchFlight(FlightCriteria flightCriteria);
    Long getNumberOfFlights(SynthesisCriteria synthesisCriteria);
}
