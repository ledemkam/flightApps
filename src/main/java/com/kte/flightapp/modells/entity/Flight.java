package com.kte.flightapp.modells.entity;

import com.kte.flightapp.modells.enumeration.FlightType;
import com.kte.flightapp.modells.enumeration.TravelType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;


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

    public Flight() {
    }

    public Flight(LocalDate backDate, Long id, Company company, FlightType flightType, TravelType travelType, LocalDate departureDate, LocalDate arrivalDate, LocalTime departureTime, LocalTime arrivalTime, LocalTime backTime, String departureLocation, String arrivalLocation, LocalTime flightDuration, LocalTime connectionDuration, String aircraftType) {
        this.backDate = backDate;
        this.id = id;
        this.company = company;
        this.flightType = flightType;
        this.travelType = travelType;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.backTime = backTime;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.flightDuration = flightDuration;
        this.connectionDuration = connectionDuration;
        this.aircraftType = aircraftType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public void setFlightType(FlightType flightType) {
        this.flightType = flightType;
    }

    public TravelType getTravelType() {
        return travelType;
    }

    public void setTravelType(TravelType travelType) {
        this.travelType = travelType;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getBackDate() {
        return backDate;
    }

    public void setBackDate(LocalDate backDate) {
        this.backDate = backDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalTime getBackTime() {
        return backTime;
    }

    public void setBackTime(LocalTime backTime) {
        this.backTime = backTime;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public LocalTime getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(LocalTime flightDuration) {
        this.flightDuration = flightDuration;
    }

    public LocalTime getConnectionDuration() {
        return connectionDuration;
    }

    public void setConnectionDuration(LocalTime connectionDuration) {
        this.connectionDuration = connectionDuration;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", company=" + company +
                ", flightType=" + flightType +
                ", travelType=" + travelType +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", backDate=" + backDate +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", backTime=" + backTime +
                ", departureLocation='" + departureLocation + '\'' +
                ", arrivalLocation='" + arrivalLocation + '\'' +
                ", flightDuration=" + flightDuration +
                ", connectionDuration=" + connectionDuration +
                ", aircraftType='" + aircraftType + '\'' +
                '}';
    }
}

