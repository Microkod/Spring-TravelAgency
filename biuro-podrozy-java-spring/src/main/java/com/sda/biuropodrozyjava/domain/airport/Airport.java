package com.sda.biuropodrozyjava.domain.airport;

import com.sda.biuropodrozyjava.domain.city.City;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "airport")
public class Airport {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToOne
    @JoinColumn(name = "city_id", foreignKey = @ForeignKey(name = "airport_city_id_fk"))
    private City city;

    public Airport(Long id, String name, City city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
}
