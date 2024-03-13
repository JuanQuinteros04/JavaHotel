package com.hotel.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "type_room")
    private String typeRoom;

    @Column(name = "room_capacity")
    private Long roomCapacity;

    @Column(name = "available_room")
    private Boolean availableRoom;

    @Column(name = "price")
    private Long price;


}
