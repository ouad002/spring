package com.emse.spring.automacorp;

public record Sensor(Long id, String name, Double value, SensorType sensorType) {
}
