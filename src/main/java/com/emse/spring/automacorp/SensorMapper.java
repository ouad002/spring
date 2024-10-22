package com.emse.spring.automacorp;

public class SensorMapper {
    public static Sensor of(SensorEntity sensor) {
        return new Sensor(
                sensor.getId(),
                sensor.getName(),
                sensor.getValue(),
                sensor.getSensorType()
        );
    }
}
