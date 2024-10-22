package com.emse.spring.automacorp;

public record Window(Long id, String name, SensorEntity windowStatus, Long roomId) {
}

