package com.emirates.todo.domain.req;

import lombok.Data;
/**
 * Created by nilashan on 4/1/18.
 */
@Data
public class TodoUpdateRequest {

    private Integer todoId;

    private String status;
}
