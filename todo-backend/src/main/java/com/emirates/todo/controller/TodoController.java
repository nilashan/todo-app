package com.emirates.todo.controller;

import com.emirates.todo.domain.req.TodoRequest;
import com.emirates.todo.domain.req.TodoUpdateRequest;
import com.emirates.todo.service.TodoService;
import com.emirates.todo.domain.util.ApiResponse;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/todo")
@CrossOrigin(methods = {POST, PUT, GET, DELETE}, allowCredentials = "true")
@Api(produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class TodoController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @Autowired
    private TodoService todoService;

    /**
     * Get all todolists
     *
     * @param
     * @return todoList
     */
    @ApiOperation(value = "/get-todo-lists", notes = "get todo}")
    @GetMapping(value = "/get-todo-lists")
    public ResponseEntity<ApiResponse> getAllTodoList() {
        return todoService.getAllTodoList();
    }

    @ApiOperation(value = "/add-todo-lists", notes = "add todo lists")
    @RequestMapping(value = "/add-todo-lists", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse> addTodoList(@RequestBody TodoRequest todoRequest) {
        return todoService.addTodoList(todoRequest);
    }

    @ApiOperation(value = "/delete-todo-list", notes = "add todo lists")
    @RequestMapping(value = "/delete-todo-list/{todoId}", method = RequestMethod.DELETE)
    public ResponseEntity<ApiResponse> deleteTodoList(@PathVariable("todoId") String todoId) {
        return todoService.deleteTodoList(todoId);
    }

    @ApiOperation(value = "/update-todo-lists", notes = "update todo lists")
    @RequestMapping(value = "/update-todo-lists", method = RequestMethod.PUT)
    public ResponseEntity<ApiResponse> addTodoList(@RequestBody TodoUpdateRequest todoUpdateRequest) {
        return todoService.updateTodoList(todoUpdateRequest);
    }



}
