package com.wordpress.faeldi.toDoListService.controller;

import com.wordpress.faeldi.toDoListService.impl.ToDoListImpl;
import com.wordpress.faeldi.toDoListService.model.ItemEntity;
import com.wordpress.faeldi.toDoListService.model.ItemSearchedDTO;
import com.wordpress.faeldi.toDoListService.model.ItemToInsertDTO;
import com.wordpress.faeldi.toDoListService.model.SuccessfulDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("/")
public class ToDoListServiceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ToDoListServiceController.class);

    private ToDoListImpl toDoListImpl;

    @Autowired
    public ToDoListServiceController(ToDoListImpl toDoListImpl) {
        this.toDoListImpl = toDoListImpl;
    }

    @PostMapping(value = "items")
    public ResponseEntity<SuccessfulDTO> insertItemToList(@RequestBody ItemToInsertDTO itemEntity) {
        LOGGER.info("Recieving item to insert with properties");
        SuccessfulDTO successfulDTO = toDoListImpl.insertItem(itemEntity);
        LOGGER.info("Item inserted to the list");
        return new ResponseEntity<>(successfulDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "items",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<ItemEntity>> listItemsFromList(@RequestParam(value = "_limit",defaultValue = "10") int _limit,
                                                           @RequestParam(value = "_offset",defaultValue = "0") int _offset) {
        LOGGER.info("Recieving item to insert with properties");
        Page<ItemEntity> itemEntityPage = toDoListImpl.listItemsFromList(_limit,_offset);
        LOGGER.info("Item inserted to the list");
        return new ResponseEntity<>(itemEntityPage, HttpStatus.OK);
    }

    @GetMapping(value = "items/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemSearchedDTO> findItemInList(@PathVariable Long id) {
        ItemSearchedDTO itemSearchedDTO = toDoListImpl.findItemInList(id);
        return new ResponseEntity<>(itemSearchedDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "items/{id}")
    public ResponseEntity<SuccessfulDTO> deleteItemInList(@PathVariable Long id) {
        SuccessfulDTO successfulDTO = toDoListImpl.deleteItemInList(id);
        return new ResponseEntity<>(successfulDTO, HttpStatus.OK);
    }
}
