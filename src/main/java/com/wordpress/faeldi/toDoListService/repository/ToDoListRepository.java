package com.wordpress.faeldi.toDoListService.repository;

import com.wordpress.faeldi.toDoListService.model.ItemBase;
import com.wordpress.faeldi.toDoListService.model.ItemEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ToDoListRepository extends CrudRepository<ItemEntity, Long> {

    @Query(value = "select id,title,description from public.todo_list_item",nativeQuery = true)
    public Page<ItemBase> listItemsFromList(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO public.todo_list_item " +
            "(title, description)" +
            "VALUES(:title, :description);",nativeQuery = true)
    public void insertItem(@Param("title") String title,@Param("description") String description);
}
