package com.example.hotelbooking.controllers;

import com.example.hotelbooking.dto.SuccessDto;
import com.example.hotelbooking.entities.ReservationEntity;
import com.example.hotelbooking.entities.RoomEntity;
import com.example.hotelbooking.repositories.ReservationRepository;
import com.example.hotelbooking.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservations/")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("get-all")
    public List<ReservationEntity> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @PostMapping("create")
    public ReservationEntity createReservation(@RequestBody ReservationEntity reservationEntity) {
        return reservationRepository.save(reservationEntity);
    }

    @DeleteMapping("delete/{id}")
    public SuccessDto deleteReservation(@PathVariable Long id) {
        reservationRepository.deleteById(id);
        return new SuccessDto();
    }

    @GetMapping("/search")
    public List<RoomEntity> searchAvailableRooms(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        return reservationService.searchAvailableRooms(startDate, endDate);
    }
}
