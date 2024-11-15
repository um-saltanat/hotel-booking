package com.example.hotelbooking.entities;

import com.example.hotelbooking.RoomType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "rooms")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long roomNumber;

    @Enumerated(EnumType.STRING)
    RoomType type;

    double pricePerNight;

    @Column(name = "is_available")
    boolean isAvailable = true;


}

