package com.example.hotelbooking.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long roomId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String guestName;
    private String guestEmail;

}
