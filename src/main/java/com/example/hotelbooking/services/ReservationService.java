package com.example.hotelbooking.services;

import com.example.hotelbooking.entities.ReservationEntity;
import com.example.hotelbooking.entities.RoomEntity;
import com.example.hotelbooking.exceptions.RoomNotAvailableException;
import com.example.hotelbooking.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RoomService roomService;

    public List<ReservationEntity> getAllReservations() {
        return reservationRepository.findAll();
    }

    public ReservationEntity createReservation(ReservationEntity reservationEntity) {
        RoomEntity roomEntity = roomService.getRoomById(reservationEntity.getRoomId());
        if (!roomEntity.isAvailable()) throw new RoomNotAvailableException("Room is not available");

        // Additional logic to check reservation conflicts
        return reservationRepository.save(reservationEntity);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public List<RoomEntity> searchAvailableRooms(LocalDate startDate, LocalDate endDate) {
        List<RoomEntity> availableRoomEntities = roomService.findAvailableRooms();
        List<RoomEntity> results = new ArrayList<>();

        for (RoomEntity roomEntity : availableRoomEntities) {
            boolean isAvailable = reservationRepository.findByRoomIdAndStartDateBetween(
                    roomEntity.getId(), startDate, endDate).isEmpty();
            if (isAvailable) {
                results.add(roomEntity);
            }
        }
        return results;
    }
}
