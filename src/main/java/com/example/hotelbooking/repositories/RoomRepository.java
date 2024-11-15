package com.example.hotelbooking.repositories;

import com.example.hotelbooking.entities.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
    List<RoomEntity> findByIsAvailableTrue(); // Find available rooms
}
