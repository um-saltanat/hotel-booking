package com.example.hotelbooking.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomUpdateDto {

    private Long roomNumber;
    private String type;
    private Double pricePerNight;
    private boolean isAvailable;
}
