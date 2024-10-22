package com.emse.spring.automacorp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WindowDao extends JpaRepository<WindowEntity, Long>,WindowDaoCustom {
    @Query("select w from WindowEntity w where w.name=:name")
    SensorEntity findByName(@Param("name") String name);

    @Modifying // (3)
    @Query("delete from WindowEntity w where w.name = ?1")
    void deleteByName(String name);

    List<WindowEntity> findById(long Id);

}
