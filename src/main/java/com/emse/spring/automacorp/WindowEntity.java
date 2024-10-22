package com.emse.spring.automacorp;
import jakarta.persistence.*;

@Entity // (1).
@Table(name = "SP_WINDOW") // (2).
public class WindowEntity {
    @Id // (3)
    private Long id;

    @Column(nullable=false, length=255) // (4)
    private String name;

    // (5)
    @ManyToOne
    @JoinColumn(name = "window_status_id", nullable=false)
    private SensorEntity windowStatus;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private RoomEntity room;

    public void setWindowStatus(SensorEntity windowStatus) {
        this.windowStatus = windowStatus;
    }

    public WindowEntity() {
    }

    public WindowEntity(String name, SensorEntity sensor, RoomEntity room) {
        this.windowStatus = sensor;
        this.name = name;
        this.room = room;
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

    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SensorEntity getWindowStatus() {
        return windowStatus;
    }


}
