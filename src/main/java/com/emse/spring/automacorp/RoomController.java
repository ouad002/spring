package com.emse.spring.automacorp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private static final Logger logger = LoggerFactory.getLogger(RoomController.class);
    private final RoomDao roomDao;

    public RoomController(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    // Fetch all rooms
    @GetMapping
    public List<RoomEntity> getAllRooms() {
        logger.info("Received request to fetch all rooms");

        // Fetch all rooms from the database
        List<RoomEntity> rooms = roomDao.findAll();

        if (rooms.isEmpty()) {
            logger.warn("No rooms found in the database");
        } else {
            logger.debug("Fetched {} rooms", rooms.size());
        }

        return rooms;
    }

    // Fetch room by ID
    @GetMapping("/{id}")
    public Optional<RoomEntity> getRoomById(@PathVariable Long id) {
        logger.info("Received request to fetch room with id: {}", id);

        Optional<RoomEntity> room = roomDao.findById(id);

        if (room.isPresent()) {
            logger.debug("Room with id {} found: {}", id, room.get());
        } else {
            logger.warn("Room with id {} not found", id);
        }

        return room;
    }

    // Create a new room
    @PostMapping
    public RoomEntity createRoom(@RequestBody RoomEntity room) {
        logger.info("Received request to create new room: {}", room);

        try {
            // Save room to the database
            RoomEntity createdRoom = roomDao.save(room);
            logger.info("Room successfully created with ID: {}", createdRoom.getId());
            return createdRoom;
        } catch (Exception e) {
            logger.error("Error occurred while creating room: {}", e.getMessage());
            throw e;  // Rethrow exception or handle it appropriately
        }
    }
}



