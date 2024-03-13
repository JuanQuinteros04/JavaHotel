package com.hotel.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPreferences {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "type_room")
    private String typeRoom;

    @Column(name = "number_people")
    private Long numberPeople;

    @Column(name = "price")
    private Long price;

}
