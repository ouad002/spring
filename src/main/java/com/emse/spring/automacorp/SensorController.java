package com.emse.spring.automacorp;

import com.emse.spring.automacorp.SensorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger logger = LoggerFactory.getLogger(SensorController.class);

    // Retrieve a sensor list via GET
    @GetMapping
    public List<SensorEntity> getAllSensors() {
        logger.info("Fetching all sensors");
        List<SensorEntity> sensors = entityManager.createQuery("SELECT s FROM SensorEntity s", SensorEntity.class).getResultList();
        logger.debug("Found {} sensors", sensors.size());
        return sensors;
    }

    // Retrieve a particular sensor via GET
    @GetMapping("/{id}")
    public ResponseEntity<SensorEntity> getSensorById(@PathVariable Long id) {
        logger.info("Fetching sensor with ID: {}", id);
        SensorEntity sensor = entityManager.find(SensorEntity.class, id);
        if (sensor != null) {
            logger.debug("Sensor found: {}", sensor);
            return ResponseEntity.ok(sensor);
        } else {
            logger.warn("Sensor with ID {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    // Create a sensor via POST
    @PostMapping
    @Transactional
    public SensorEntity createSensor(@RequestBody SensorEntity sensor) {
        logger.info("Creating new sensor: {}", sensor.getName());
        entityManager.persist(sensor); // Save sensor to the database
        logger.debug("Sensor created with ID: {}", sensor.getId());
        return sensor;
    }

    // Update a sensor via PUT
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<SensorEntity> updateSensor(@PathVariable Long id, @RequestBody SensorEntity sensorDetails) {
        logger.info("Updating sensor with ID: {}", id);
        SensorEntity sensor = entityManager.find(SensorEntity.class, id);
        if (sensor != null) {
            logger.debug("Original sensor details: {}", sensor);
            sensor.setName(sensorDetails.getName());
            sensor.setValue(sensorDetails.getValue());
            sensor.setSensorType(sensorDetails.getSensorType());
            entityManager.merge(sensor); // Update the existing sensor in the database
            logger.debug("Updated sensor details: {}", sensor);
            return ResponseEntity.ok(sensor);
        } else {
            logger.warn("Sensor with ID {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a sensor via DELETE
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteSensor(@PathVariable Long id) {
        logger.info("Deleting sensor with ID: {}", id);
        SensorEntity sensor = entityManager.find(SensorEntity.class, id);
        if (sensor != null) {
            entityManager.remove(sensor); // Remove the sensor from the database
            logger.debug("Sensor with ID {} deleted", id);
            return ResponseEntity.ok().build();
        } else {
            logger.warn("Sensor with ID {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }
}



