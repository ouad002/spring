package com.emse.spring.automacorp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SensorDao extends JpaRepository<SensorEntity, Long> {
    @Query("select c from SensorEntity c where c.name=:name")
    SensorEntity findByName(@Param("name") String name);

    @Modifying // (3)
    @Query("delete from SensorEntity c where c.name = ?1")
    void deleteByName(String name);

    List<SensorEntity> findById(long Id);

}
