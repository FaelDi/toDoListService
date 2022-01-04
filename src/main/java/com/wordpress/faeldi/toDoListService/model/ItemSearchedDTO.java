package com.wordpress.faeldi.toDoListService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ItemSearchedDTO implements Serializable {

    private String title;

    private String description;

}
