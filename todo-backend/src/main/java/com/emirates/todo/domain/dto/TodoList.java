package com.emirates.todo.domain.dto;

import lombok.Data;

/**
 * Created by nilashan on 3/30/18.
 */
@Data
public class TodoList {

    private Integer todo_id;
    private String description;
    private String status;
    private String title;

}
