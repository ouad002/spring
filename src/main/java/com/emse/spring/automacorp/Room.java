package com.emse.spring.automacorp;

public record Room(long id,String name,long floor, SensorEntity currentTemperature, double targetTemperature) {

}
