package com.kte.flightapp.modells.entity;

import com.kte.flightapp.modells.embeddable.CabinDetail;
import com.kte.flightapp.modells.embeddable.InflightInfo;
import com.kte.flightapp.modells.enumeration.CompanyName;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

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
}
