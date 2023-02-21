package com.wordpress.faeldi.toDoListService.service;

import com.wordpress.faeldi.toDoListService.model.ItemBase;
import com.wordpress.faeldi.toDoListService.model.SuccessfulDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class BaseController<T, S extends BaseService>{

    protected S service;

    public BaseController(S service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SuccessfulDTO> insertItemToList(@RequestBody T body) {
        SuccessfulDTO successfulDTO = service.insertItem(body);
        return new ResponseEntity<>(successfulDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<ItemBase>> listItemsFromList(@RequestParam(value = "_limit",defaultValue = "10") int _limit,
                                                            @RequestParam(value = "_offset",defaultValue = "0") int _offset) {
        Page<ItemBase> itemEntityPage = service.listOfItensPageable(_limit,_offset);
        return new ResponseEntity<>(itemEntityPage, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findItemInList(@PathVariable Long id) {
        Object itemSearchedDTO = service.findItem(id);
        return new ResponseEntity<>(itemSearchedDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<SuccessfulDTO> deleteItemInList(@PathVariable Long id) {
        SuccessfulDTO successfulDTO = service.deleteItem(id);
        return new ResponseEntity<>(successfulDTO, HttpStatus.OK);
    }
}
