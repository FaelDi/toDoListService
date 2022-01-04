package com.wordpress.faeldi.toDoListService.impl;

import com.wordpress.faeldi.toDoListService.exception.NotFoundElement;
import com.wordpress.faeldi.toDoListService.model.ItemEntity;
import com.wordpress.faeldi.toDoListService.model.ItemSearchedDTO;
import com.wordpress.faeldi.toDoListService.model.ItemToInsertDTO;
import com.wordpress.faeldi.toDoListService.model.SuccessfulDTO;
import com.wordpress.faeldi.toDoListService.repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class ToDoListImpl {

    @Autowired
    private ToDoListRepository toDoListRepository;

    @Transactional
    public SuccessfulDTO insertItem(ItemToInsertDTO itemToInsertDTO) {
        toDoListRepository.insertItem(itemToInsertDTO.getTitle(),itemToInsertDTO.getDescription());
        return SuccessfulDTO.builder().code(HttpStatus.OK.value()).message("Item inserido com sucesso").build();
    }

    public Page<ItemEntity> listItemsFromList(int _limit,int _offset) {
        Pageable page =  PageRequest.of(_offset,_limit,Sort.unsorted());
        Page<ItemEntity> entityPage = toDoListRepository.listItemsFromList(page);
        return entityPage;
    }

    public ItemSearchedDTO findItemInList(Long id) {
        Optional<ItemEntity> itemEntity = toDoListRepository.findById(id);
        if(itemEntity.isPresent()){
            ItemEntity entity = itemEntity.get();
            return ItemSearchedDTO.builder().description(entity.getDescription())
                    .title(entity.getTitle()).build();
        }
        throw new NotFoundElement("Not Found");
    }

    public SuccessfulDTO deleteItemInList(Long id) {
        Optional<ItemEntity> itemEntity = toDoListRepository.findById(id);
        if(itemEntity.isPresent()){
            toDoListRepository.deleteById(id);
            return SuccessfulDTO.builder().code(HttpStatus.OK.value()).message("Item removido com sucesso").build();
        }
        throw new NotFoundElement("Not Found");
    }
}
