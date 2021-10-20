package com.sda.biuropodrozyjava.domain.travel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TravelSearchCriteria {

    private Long continentId;
    private Long countryId;

}
