package com.sda.biuropodrozyjava.domain.role;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role {

    @Id
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    private String description;

    // nie chcemy relacji dwustromnnej
//    @OneToMany(mappedBy = "role")
//    private List<Uzytkownik> users;

    // todo brak konstruktora bo nie wiadomo czy potrzebny

    @Override
    public String toString() {
        return "Role{" +
                "name=" + name +
                ", description='" + description + '\'' +
                '}';
    }
}
