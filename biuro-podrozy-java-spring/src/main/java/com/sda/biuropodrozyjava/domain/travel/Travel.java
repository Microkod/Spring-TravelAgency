package com.sda.biuropodrozyjava.domain.travel;

import com.sda.biuropodrozyjava.domain.hotel.Hotel;
import com.sda.biuropodrozyjava.domain.airport.Airport;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Entity
@Table(name = "travel")
@Getter
@Setter
@ToString
public class Travel {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "departure_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate;

    @Column(name = "arrival_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate arrivalDate;

    @Column(name = "number_of_days")
    private int numberOfDays;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private OfferType type;

    @Column(name = "price_adult", nullable = false)
    private Double priceAdult;

    @Column(name = "price_child", nullable = false)
    private Double priceChild;

    @Column(name = "number_of_adults", nullable = false)
    private int numberOfAdults;

    @Column(name = "number_of_children", nullable = false)
    private int numberOfChildren;

    private boolean promoted;

    @ManyToOne
    @JoinColumn(name = "airport_id", foreignKey = @ForeignKey(name = "travel_airport_id_fk"))
    private Airport airport;

    @ManyToOne
    @JoinColumn(name = "hotel_id", foreignKey = @ForeignKey(name = "travel_hotel_id_fk"))
    private Hotel hotel;

    public Travel(Long id, LocalDate departureDate, LocalDate arrivalDate, int numberOfDays, OfferType type, Double priceAdult,
                  Double priceChild, int numberOfAdults, int numberOfChildren, boolean promoted, Airport airport, Hotel hotel) {
        this.id = id;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.numberOfDays = numberOfDays;
        this.type = type;
        this.priceAdult = priceAdult;
        this.priceChild = priceChild;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChildren = numberOfChildren;
        this.promoted = promoted;
        this.airport = airport;
        this.hotel = hotel;
    }
}
