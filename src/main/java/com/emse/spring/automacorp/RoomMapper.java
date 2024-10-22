package com.emse.spring.automacorp;

public class RoomMapper {
    public static Room of(RoomEntity room) {
        return new Room(
                room.getId(),
                room.getName(),
                room.getFloor(),
                room.getCurrentTemperature(),
                room.getTargetTemperature()
        );
    }
}
