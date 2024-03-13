package com.hotel.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "type_room")
    private String typeRoom;

    @Column(name = "number_people")
    private Long numberPeople;

    @Column(name = "entry_date")
    private Long entryDate;

    @Column(name = "departure_date")
    private Long departureDate;

    @Column(name = "price")
    private Long price;
}
