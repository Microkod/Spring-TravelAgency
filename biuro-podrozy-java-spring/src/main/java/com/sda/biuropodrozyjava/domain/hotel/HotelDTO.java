package com.sda.biuropodrozyjava.domain.hotel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelDTO {

    private Long id;
    private String name;
    private int standard;
    private String description;

}
