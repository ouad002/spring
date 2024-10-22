package com.emse.spring.automacorp;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.emse.spring.automacorp.RoomEntity;
import com.emse.spring.automacorp.RoomDao;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {


    private RoomDao roomDao;

    @GetMapping
    public List<RoomEntity> getAllRooms() {
        return roomDao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<RoomEntity> getRoomById(@PathVariable Long id) {return roomDao.findById(id);}

    @PostMapping
    public RoomEntity createRoom(@RequestBody RoomEntity room) {
        return roomDao.save(room);
    }
}

