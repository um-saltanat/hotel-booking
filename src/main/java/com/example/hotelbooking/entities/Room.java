package com.example.hotelbooking.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;
    private String type; // e.g., Single, Double, Suite
    private double pricePerNight;
    private boolean isAvailable;

}

