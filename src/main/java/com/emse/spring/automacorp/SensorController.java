package com.emse.spring.automacorp;

import com.emse.spring.automacorp.SensorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    @PersistenceContext
    private EntityManager entityManager;

    // Retrieve a sensor list via GET
    @GetMapping
    public List<SensorEntity> getAllSensors() {
        return entityManager.createQuery("SELECT s FROM SensorEntity s", SensorEntity.class).getResultList();
    }

    // Retrieve a particular sensor via GET
    @GetMapping("/{id}")
    public ResponseEntity<SensorEntity> getSensorById(@PathVariable Long id) {
        SensorEntity sensor = entityManager.find(SensorEntity.class, id);
        if (sensor != null) {
            return ResponseEntity.ok(sensor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a sensor via POST
    @PostMapping
    @Transactional
    public SensorEntity createSensor(@RequestBody SensorEntity sensor) {
        entityManager.persist(sensor); // Save sensor to the database
        return sensor;
    }

    // Update a sensor via PUT
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<SensorEntity> updateSensor(@PathVariable Long id, @RequestBody SensorEntity sensorDetails) {
        SensorEntity sensor = entityManager.find(SensorEntity.class, id);
        if (sensor != null) {
            sensor.setName(sensorDetails.getName());
            sensor.setValue(sensorDetails.getValue());
            sensor.setSensorType(sensorDetails.getSensorType());
            entityManager.merge(sensor); // Update the existing sensor in the database
            return ResponseEntity.ok(sensor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a sensor via DELETE
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteSensor(@PathVariable Long id) {
        SensorEntity sensor = entityManager.find(SensorEntity.class, id);
        if (sensor != null) {
            entityManager.remove(sensor); // Remove the sensor from the database
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


