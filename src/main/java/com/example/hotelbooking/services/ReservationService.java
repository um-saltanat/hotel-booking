package com.example.hotelbooking.services;

import com.example.hotelbooking.entities.Reservation;
import com.example.hotelbooking.entities.Room;
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

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation createReservation(Reservation reservation) {
        Room room = roomService.getRoomById(reservation.getRoomId());
        if (!room.isAvailable()) throw new RoomNotAvailableException("Room is not available");

        // Additional logic to check reservation conflicts
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public List<Room> searchAvailableRooms(LocalDate startDate, LocalDate endDate) {
        List<Room> availableRooms = roomService.findAvailableRooms();
        List<Room> results = new ArrayList<>();

        for (Room room : availableRooms) {
            boolean isAvailable = reservationRepository.findByRoomIdAndStartDateBetween(
                    room.getId(), startDate, endDate).isEmpty();
            if (isAvailable) {
                results.add(room);
            }
        }
        return results;
    }
}
