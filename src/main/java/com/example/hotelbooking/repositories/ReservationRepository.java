package com.example.hotelbooking.repositories;

import com.example.hotelbooking.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByRoomIdAndStartDateBetween(Long roomId, LocalDate startDate, LocalDate endDate);
}
