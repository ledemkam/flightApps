package com.kte.flightapp.modells.embeddable;

import com.kte.flightapp.modells.enumeration.CabinClass;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@Embeddable
public class CabinDetail {

    @Enumerated(EnumType.STRING)
    private CabinClass cabinClass;
    private String bagage;
    private String cancellation;
    private String rebooking;
    private String refund;
    private Double fare;
}
