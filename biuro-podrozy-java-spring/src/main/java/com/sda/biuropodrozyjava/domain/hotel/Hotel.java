package com.sda.biuropodrozyjava.domain.hotel;

import com.sda.biuropodrozyjava.domain.city.City;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int standard;
    private String description;

    @OneToOne
    @JoinColumn(name = "city_id", foreignKey = @ForeignKey(name = "hotel_city_id_fk"))
    private City city;

    public Hotel(Long id, String name, int standard, String description, City city) {
        this.id = id;
        this.name = name;
        this.standard = standard;
        this.description = description;
        this.city = city;
    }
}
