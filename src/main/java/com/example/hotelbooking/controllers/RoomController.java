package com.example.hotelbooking.controllers;

import com.example.hotelbooking.RoomType;
import com.example.hotelbooking.dto.RoomUpdateDto;
import com.example.hotelbooking.dto.SuccessDto;
import com.example.hotelbooking.entities.RoomEntity;
import com.example.hotelbooking.repositories.RoomRepository;
import com.example.hotelbooking.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms/")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomService roomService;

    @GetMapping("get-all")
    public List<RoomEntity> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("get/{id}")
    public RoomEntity getRoomById(@PathVariable("id") Long id) {
        return roomRepository.findById(id).orElseThrow();
    }

    @PostMapping("create")
    public RoomEntity createRoom(@RequestBody RoomEntity roomEntity) {
        return roomRepository.save(roomEntity);
    }

    @PutMapping("update/{id}")
    public RoomEntity updateRoom(@PathVariable Long id, @RequestBody RoomUpdateDto room) {
        RoomEntity toUpdate = roomRepository.findById(id).get();
        if (room.getRoomNumber() != null) {
            toUpdate.setRoomNumber(room.getRoomNumber());
        }
        if (room.getType() != null) {
            toUpdate.setType(RoomType.valueOf(room.getType()));
        }
        if (room.getPricePerNight() != null) {
            toUpdate.setPricePerNight(room.getPricePerNight());
        }
        return roomRepository.save(toUpdate);
    }

    @DeleteMapping("delete/{id}")
    public SuccessDto deleteRoom(@PathVariable("id") Long id) {
        roomRepository.deleteById(id);
        return new SuccessDto();
    }

    @GetMapping("get/available")
    public List<RoomEntity> getAvailableRooms() {
        return roomService.findAvailableRooms();
    }
}
