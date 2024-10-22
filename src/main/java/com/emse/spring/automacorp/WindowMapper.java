package com.emse.spring.automacorp;

public class WindowMapper {
    public static Window of(WindowEntity window) {
        return new Window(
                window.getId(),
                window.getName(),
                window.getWindowStatus(),
                window.getRoom().getId()
        );
    }
}
