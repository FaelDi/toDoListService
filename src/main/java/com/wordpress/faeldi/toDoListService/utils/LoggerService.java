package com.wordpress.faeldi.toDoListService.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerService {

    private static Logger getInstance(Class<?> clazz){
        return LoggerFactory.getLogger(clazz);
    }
}
