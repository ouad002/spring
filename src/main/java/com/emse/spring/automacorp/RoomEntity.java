package com.emse.spring.automacorp;

import jakarta.persistence.*;
import java.util.*;

@Entity // (1).
@Table(name = "ROOM") // (2).
public class RoomEntity {
    @Id // (3)
    private Long id;

    @Column(nullable=false, length=255) // (4)
    private long floor;

    @Column(nullable=false, length=255)  // (4).
    private String name;

    // (5)
    @ManyToOne
    private SensorEntity currentTemperature;

    @Column
    private Double targetTemperature;

    @OneToMany(mappedBy = "room", orphanRemoval = true)
    private List<WindowEntity> windows = new ArrayList<>();


    public void setCurrentTemperature(SensorEntity currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public  RoomEntity() {}

    public RoomEntity(long id,String name,long floor, SensorEntity currentTemperature, double targetTemperature) {
        this.currentTemperature = currentTemperature;
        this.floor = floor;
        this.targetTemperature = targetTemperature;
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public SensorEntity getCurrentTemperature() {
        return currentTemperature;
    }
    public double getTargetTemperature() {
        return this.targetTemperature;
    }

    public void setTargetTemperature(double targetTemperature) {
        this.targetTemperature= targetTemperature;
    }

    public void setFloor(long floor) {
        this.floor = floor;
    }
}
