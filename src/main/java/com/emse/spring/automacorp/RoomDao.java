package com.emse.spring.automacorp;

import com.emse.spring.automacorp.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDao extends JpaRepository<RoomEntity, Long> {
}
