package com.kte.flightapp.modells.embeddable;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@Embeddable
public class InflightInfo {
    private String title;
    private String description;
}
