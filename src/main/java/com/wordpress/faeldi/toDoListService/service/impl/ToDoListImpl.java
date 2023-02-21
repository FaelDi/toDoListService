package com.wordpress.faeldi.toDoListService.service.impl;

import com.wordpress.faeldi.toDoListService.exception.NotFoundElement;
import com.wordpress.faeldi.toDoListService.model.*;
import com.wordpress.faeldi.toDoListService.repository.ToDoListRepository;
import com.wordpress.faeldi.toDoListService.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class ToDoListImpl implements BaseService<ItemBase> {

    @Autowired
    private ToDoListRepository toDoListRepository;

    @Transactional
    @Override
    public SuccessfulDTO insertItem(ItemBase itemToInsertDTO) {
        toDoListRepository.insertItem(itemToInsertDTO.getTitle(),itemToInsertDTO.getDescription());
        return SuccessfulDTO.builder().code(HttpStatus.OK.value()).message("Item inserido com sucesso").build();
    }

    @Override
    public Page<ItemBase> listOfItensPageable(int _limit,int _offset) {
        Pageable page =  PageRequest.of(_offset,_limit,Sort.unsorted());
        Page<ItemBase> entityPage = toDoListRepository.listItemsFromList(page);
        return entityPage;
    }

    @Override
    public ItemSearchedDTO findItem(Long id) {
        Optional<ItemEntity> itemEntity = toDoListRepository.findById(id);
        if(itemEntity.isPresent()){
            ItemEntity entity = itemEntity.get();
            return ItemSearchedDTO.builder().description(entity.getDescription())
                    .title(entity.getTitle()).build();
        }
        throw new NotFoundElement("Not Found");
    }

    @Override
    public SuccessfulDTO deleteItem(Long id) {
        Optional<ItemEntity> itemEntity = toDoListRepository.findById(id);
        if(itemEntity.isPresent()){
            toDoListRepository.deleteById(id);
            return SuccessfulDTO.builder().code(HttpStatus.OK.value()).message("Item removido com sucesso").build();
        }
        throw new NotFoundElement("Not Found");
    }
}
