package com.wordpress.faeldi.toDoListService.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class SuccessfulDTO {

    private int code;
    private String message;

}
