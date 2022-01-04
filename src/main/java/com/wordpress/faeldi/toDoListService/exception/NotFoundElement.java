package com.wordpress.faeldi.toDoListService.exception;

public class NotFoundElement extends RuntimeException{

    public NotFoundElement(String message) {
        super(message);
    }
}
