package com.kte.flightapp.repository;

import com.kte.flightapp.modells.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
