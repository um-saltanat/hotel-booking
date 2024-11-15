package com.example.hotelbooking.services;

import com.example.hotelbooking.entities.RoomEntity;
import com.example.hotelbooking.exceptions.ResourceNotFoundException;
import com.example.hotelbooking.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<RoomEntity> getAllRooms() {
        return roomRepository.findAll();
    }

    public RoomEntity getRoomById(Long id) {
        return roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room not found"));
    }

    public List<RoomEntity> findAvailableRooms() {
        return roomRepository.findByIsAvailableTrue();
    }
}
