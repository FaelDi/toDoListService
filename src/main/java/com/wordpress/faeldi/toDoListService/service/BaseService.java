package com.wordpress.faeldi.toDoListService.service;

import com.wordpress.faeldi.toDoListService.model.ItemBase;
import com.wordpress.faeldi.toDoListService.model.ItemToInsertDTO;
import com.wordpress.faeldi.toDoListService.model.SuccessfulDTO;
import org.springframework.data.domain.Page;

public interface BaseService<T> {

    public SuccessfulDTO insertItem(T obj);

    public Page<T> listOfItensPageable(int limit, int offset);

    public T findItem(Long id);

    public SuccessfulDTO deleteItem(Long id);
}
