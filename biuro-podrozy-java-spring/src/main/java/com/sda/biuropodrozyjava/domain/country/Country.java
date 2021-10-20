package com.sda.biuropodrozyjava.domain.country;

import com.sda.biuropodrozyjava.domain.continent.Continent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "country")
public class Country {

    @Id
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "continent_id", foreignKey = @ForeignKey(name = "country_continent_id_fk"))
    private Continent continent;

    public Country(Long id, String name, Continent continent) {
        this.id = id;
        this.name = name;
        this.continent = continent;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                '}';
    }
}
