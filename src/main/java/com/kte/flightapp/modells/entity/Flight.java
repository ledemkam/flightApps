package com.kte.flightapp.modells.entity;

import com.kte.flightapp.modells.enumeration.FlightType;
import com.kte.flightapp.modells.enumeration.TravelType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "flight_type")
    @Enumerated(EnumType.STRING)
    private FlightType flightType;

    @Column(name = "travel_type")
    @Enumerated(EnumType.STRING)
    private TravelType travelType;

    @Column(name = "departure_date")
    private LocalDate departureDate;

    @Column(name = "arrival_date")
    private LocalDate arrivalDate;

    @Column(name = "back_date")
    private LocalDate backDate;

    @Column(name = "departure_time")
    private LocalTime departureTime;

    @Column(name = "arrival_time")
    private LocalTime arrivalTime;

    @Column(name = "back_time")
    private LocalTime backTime;

    @Column(name = "departure_location")
    private String departureLocation;

    @Column(name = "arrival_location")
    private String arrivalLocation;

    @Column(name = "flight_duration")
    private LocalTime flightDuration;

    @Column(name = "connection_duration")
    private LocalTime connectionDuration;

    @Column(name = "aircraft_type")
    private String aircraftType;
}
