package com.kte.flightapp.services.impl;

import com.kte.flightapp.modells.Criteria.FlightCriteria;
import com.kte.flightapp.modells.Criteria.SynthesisCriteria;
import com.kte.flightapp.modells.entity.Flight;
import com.kte.flightapp.repository.FlightRepository;
import com.kte.flightapp.services.FlightService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional(readOnly = true)
@Service
public class FligServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    public FligServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    @Transactional
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    @Transactional
    public List<Flight> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();

        if (flights.isEmpty()) {
            return flights;
        }else {
            return new ArrayList<>();
        }
    }

    @Override
    @Transactional
    public List<Flight> searchFlight(FlightCriteria flightCriteria) {
        return flightRepository.searchFlight(flightCriteria);
    }

    @Override
    @Transactional
    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Long getNumberOfFlights(SynthesisCriteria synthesisCriteria) {
        return flightRepository.getNumberOfFlights(synthesisCriteria);
    }
}
