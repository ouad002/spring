package com.emse.spring.automacorp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Room entities.
 * Provides endpoints to fetch all rooms, fetch a room by ID, and create a new room.
 */
@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private static final Logger logger = LoggerFactory.getLogger(RoomController.class);
    private final RoomDao roomDao;

    /**
     * Constructor for RoomController.
     *
     * @param roomDao the DAO for interacting with the Room database.
     */
    public RoomController(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    /**
     * Fetches all rooms from the database.
     *
     * @return a list of all RoomEntity objects.
     */
    @GetMapping
    public List<RoomEntity> getAllRooms() {
        logger.info("Received request to fetch all rooms");

        List<RoomEntity> rooms = roomDao.findAll();

        if (rooms.isEmpty()) {
            logger.warn("No rooms found in the database");
        } else {
            logger.debug("Fetched {} rooms", rooms.size());
        }

        return rooms;
    }

    /**
     * Fetches a room by its ID.
     *
     * @param id the ID of the room to fetch.
     * @return an Optional containing the RoomEntity, or empty if not found.
     */
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

    /**
     * Creates a new room and saves it to the database.
     *
     * @param room the RoomEntity object to be created.
     * @return the created RoomEntity.
     */
    @PostMapping
    public RoomEntity createRoom(@RequestBody RoomEntity room) {
        logger.info("Received request to create new room: {}", room);

        try {
            RoomEntity createdRoom = roomDao.save(room);
            logger.info("Room successfully created with ID: {}", createdRoom.getId());
            return createdRoom;
        } catch (Exception e) {
            logger.error("Error occurred while creating room: {}", e.getMessage());
            throw e;  // Rethrow exception or handle it appropriately
        }
    }
}




