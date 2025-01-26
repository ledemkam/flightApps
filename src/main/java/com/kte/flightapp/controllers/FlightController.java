package com.kte.flightapp.controllers;

import com.kte.flightapp.modells.dto.FlightDTO;
import com.kte.flightapp.modells.entity.Flight;
import com.kte.flightapp.services.FlightService;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(path = "/api/v1/flight")
public class FlightController {

    private final FlightService flightService;
    private ModelMapper modelMapper;



    public FlightController(FlightService flightService, ModelMapper modelMapper) {
        this.flightService = flightService;
        this.modelMapper = modelMapper;
        this.modelMapper.addMappings(companyFieldMapping);
    }

    @PostMapping(path = "/addFlight")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        Flight addedFlight = flightService.addFlight(flight);

        return new ResponseEntity<>(addedFlight, new HttpHeaders(), HttpStatus.CREATED);
    }


    PropertyMap<Flight, FlightDTO> companyFieldMapping = new PropertyMap<Flight, FlightDTO>() {
        protected void configure() {
            map().setCompanyName(source.getCompany().getCompanyName());
            map().setCabinDetails(source.getCompany().getCabinDetails());
            map().setInflightInfos(source.getCompany().getInflightInfos());
        }
    };

    @GetMapping(path = "/allFlights")
    public ResponseEntity<List<FlightDTO>> getAllFlights() {
        List<FlightDTO> flights = flightService.getAllFlights()
                                               .stream()
                                               .map(flight -> modelMapper.map(flight, FlightDTO.class))
                                               .collect(Collectors.toList());

        return new ResponseEntity<List<FlightDTO>>(flights,new HttpHeaders(), HttpStatus.OK);
    }
}
