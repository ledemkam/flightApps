package com.kte.flightapp.services;

import com.kte.flightapp.modells.Criteria.FlightCriteria;
import com.kte.flightapp.modells.Criteria.SynthesisCriteria;
import com.kte.flightapp.modells.entity.Flight;

import java.util.List;

public interface FlightService {
    Flight addFlight(Flight flight);
    List<Flight> getAllFlights();
    List<Flight> searchFlight(FlightCriteria flightCriteria);
    Flight getFlightById(Long id);
    Long getNumberOfFlights(SynthesisCriteria synthesisCriteria);
}
