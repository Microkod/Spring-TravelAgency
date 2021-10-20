package com.sda.biuropodrozyjava.domain.continent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "continent")
public class Continent {

    @Id
    private Long id;
    private String name;

    public Continent(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
