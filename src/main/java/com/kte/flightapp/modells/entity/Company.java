package com.kte.flightapp.modells.entity;

import com.kte.flightapp.modells.embeddable.CabinDetail;
import com.kte.flightapp.modells.embeddable.InflightInfo;
import com.kte.flightapp.modells.enumeration.CompanyName;
import jakarta.persistence.*;

import java.util.Set;



@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "compagny_name")
    private CompanyName companyName;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<Flight> flights;

    @ElementCollection
    @CollectionTable(name = "cabin_details", joinColumns = @JoinColumn(name = "company_id"))
    private Set<CabinDetail> cabinDetails;

    @ElementCollection
    @CollectionTable(name = "inflight_infos", joinColumns = @JoinColumn(name = "company_id"))
    private Set<InflightInfo> inflightInfos;

    public Company() {
    }

    public Company(Long id, CompanyName companyName, Set<Flight> flights, Set<CabinDetail> cabinDetails, Set<InflightInfo> inflightInfos) {
        this.id = id;
        this.companyName = companyName;
        this.flights = flights;
        this.cabinDetails = cabinDetails;
        this.inflightInfos = inflightInfos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompanyName getCompanyName() {
        return companyName;
    }

    public void setCompanyName(CompanyName companyName) {
        this.companyName = companyName;
    }

    public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }

    public Set<CabinDetail> getCabinDetails() {
        return cabinDetails;
    }

    public void setCabinDetails(Set<CabinDetail> cabinDetails) {
        this.cabinDetails = cabinDetails;
    }

    public Set<InflightInfo> getInflightInfos() {
        return inflightInfos;
    }

    public void setInflightInfos(Set<InflightInfo> inflightInfos) {
        this.inflightInfos = inflightInfos;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName=" + companyName +
                ", flights=" + flights +
                ", cabinDetails=" + cabinDetails +
                ", inflightInfos=" + inflightInfos +
                '}';
    }
}
