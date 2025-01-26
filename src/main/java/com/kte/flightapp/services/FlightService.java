package com.kte.flightapp.services;

import com.kte.flightapp.modells.entity.Flight;

import java.util.List;

public interface FlightService {
    Flight addFlight(Flight flight);
    List<Flight> getAllFlights();
}
