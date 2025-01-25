package com.kte.flightapp.services.impl;

import com.kte.flightapp.modells.entity.Flight;
import com.kte.flightapp.repository.FlightRepository;
import com.kte.flightapp.services.FlightService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
