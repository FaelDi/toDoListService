package com.wordpress.faeldi.toDoListService.controller;

import com.wordpress.faeldi.toDoListService.model.*;
import com.wordpress.faeldi.toDoListService.service.BaseController;
import com.wordpress.faeldi.toDoListService.service.impl.ToDoListImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@RestController()
@RequestMapping("/items")
public class ToDoListServiceController extends BaseController<ItemBase,ToDoListImpl> {

    @Autowired
    public ToDoListServiceController(ToDoListImpl service) {
        super(service);
    }
}
