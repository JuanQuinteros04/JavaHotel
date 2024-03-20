package com.hotel.demo.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "user_preferences")
@EqualsAndHashCode
@Entity
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
