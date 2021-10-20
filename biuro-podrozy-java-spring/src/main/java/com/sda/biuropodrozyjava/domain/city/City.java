package com.sda.biuropodrozyjava.domain.city;

import com.sda.biuropodrozyjava.domain.country.Country;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id", foreignKey = @ForeignKey(name = "city_country_id_fk"))
    private Country country;

    public City(Long id, String name, Country country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }
}
