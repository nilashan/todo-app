package com.emirates.todo.repository;

import com.emirates.todo.domain.dto.TodoList;

import java.util.List;
import java.util.Map;

/**
 * Created by nilashan on 3/30/18.
 */
public interface TodoRepository {

    List<TodoList> getAllTodoList();

    int addTodoList(Map<String, Object> params);

    int deleteTodoList(String todo_id);

    List<Map<String, String>> getMaxTodoId();

    int updateTodoList(Map<String, Object> params);

}
