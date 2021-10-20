package com.sda.biuropodrozyjava.domain.order;

import com.sda.biuropodrozyjava.domain.user.User;
import com.sda.biuropodrozyjava.domain.travel.Travel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "number_of_adults")
    private int numberOfAdults;

    @Column(name = "number_of_children")
    private int numberOfChildren;

    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "travel_id", foreignKey = @ForeignKey(name = "orders_travel_id_fk"))
    private Travel travel;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "orders_users_id_fk"))
    private User user;

    public Order(Long id, int numberOfAdults, int numberOfChildren, double totalPrice, Travel travel, User user) {
        this.id = id;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChildren = numberOfChildren;
        this.totalPrice = totalPrice;
        this.travel = travel;
        this.user = user;
    }
}
