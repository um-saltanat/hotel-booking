package com.example.hotelbooking.repositories;

import com.example.hotelbooking.entities.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    List<ReservationEntity> findByRoomIdAndStartDateBetween(Long roomId, LocalDate startDate, LocalDate endDate);
}
