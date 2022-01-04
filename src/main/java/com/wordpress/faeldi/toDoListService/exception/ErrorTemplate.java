package com.wordpress.faeldi.toDoListService.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;

@ToString
@Getter
@Setter
public class ErrorTemplate extends Object {
    private final String message;
    private final LocalTime localTime;

    public ErrorTemplate(String message, LocalTime localTime) {
        this.message = message;
        this.localTime = localTime;
    }
}
