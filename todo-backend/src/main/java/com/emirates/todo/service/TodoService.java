package com.emirates.todo.service;

import com.emirates.todo.domain.req.TodoRequest;
import com.emirates.todo.domain.req.TodoUpdateRequest;
import org.springframework.http.ResponseEntity;
import com.emirates.todo.domain.util.ApiResponse;


/**
 * Created by nilashan on 3/30/18.
 */
public interface TodoService {

    ResponseEntity<ApiResponse> getAllTodoList();

    ResponseEntity<ApiResponse> addTodoList(TodoRequest todoRequest);

    ResponseEntity<ApiResponse> updateTodoList(TodoUpdateRequest todoUpdateRequest);

    ResponseEntity<ApiResponse> deleteTodoList(String todoId);

}
