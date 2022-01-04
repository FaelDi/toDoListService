package com.wordpress.faeldi.toDoListService.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NotFoundElement.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> handlePersonNotFound(NotFoundElement ex) {
        ErrorTemplate errorTemplate = new ErrorTemplate(ex.getMessage(), LocalTime.now());
        return new ResponseEntity<>(errorTemplate,HttpStatus.NO_CONTENT);
    }
}