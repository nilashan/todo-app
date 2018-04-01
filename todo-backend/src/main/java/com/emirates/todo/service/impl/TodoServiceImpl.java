package com.emirates.todo.service.impl;


import com.emirates.todo.domain.dto.TodoList;
import com.emirates.todo.domain.req.TodoRequest;
import com.emirates.todo.domain.req.TodoUpdateRequest;
import com.emirates.todo.domain.util.TodoDisplayMessage;
import com.emirates.todo.repository.TodoRepository;
import com.emirates.todo.service.TodoService;
import com.emirates.todo.domain.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

/**
 * Created by nilashan on 3/30/18.
 */

@Service
@Transactional
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoRepository todoRepository;

    private static final String ERROR_MESSAGE = "errorMessage";
    private static final String RETURN_MESSAGE = "returnMsg";
    private static final String RETURN = "return";

    private static ResponseEntity<ApiResponse> buildErrorResponse(String message) {
        return new ApiResponse.ApiResponseBuilder<>()
                .withHttpStatus(INTERNAL_SERVER_ERROR)
                .withMessage(message)
                .build();
    }

    private static ResponseEntity<ApiResponse> buildSuccessResponse(String successResName, Object successResponse) {
        return new ApiResponse.ApiResponseBuilder<Map<String, Object>>()
                .withMessage("Success")
                .withData(Collections.singletonMap(successResName, successResponse))
                .withHttpStatus(OK)
                .build();
    }


    @Override
    public ResponseEntity<ApiResponse> getAllTodoList() {
        List<TodoList> todoLists = todoRepository.getAllTodoList();
        return new ApiResponse.ApiResponseBuilder<Map<String, Object>>()
                .withMessage("Success")
                .withData(Collections.singletonMap("todoList", todoLists))
                .withHttpStatus(OK)
                .build();

    }

    @Override
    public ResponseEntity<ApiResponse> addTodoList(TodoRequest todoRequest) {
        ResponseEntity<ApiResponse> repoEntity;
        //dataValidator.validateInstallmentAttachmentEligibilityRequest(installmentEligibilityRequest);
        Map<String, Object> todoInsertMap = new HashMap<>();
        Map<String, Object> params = new HashMap<>();
        List<Map<String, String>> todoIdList = todoRepository.getMaxTodoId();
        int inId = Integer.parseInt(todoIdList.get(0).get("todo_id"));
        params.put("todo_id", inId+1);
        params.put("title", todoRequest.getTitle());
        params.put("description", todoRequest.getDescription());
        params.put("status", "Incompleted");
        int i = todoRepository.addTodoList(params);
        if (i > 0) {
            todoInsertMap.put(RETURN_MESSAGE, TodoDisplayMessage.SAVE_SUCCSESS.getMessage());
            repoEntity = buildSuccessResponse("todoInsertMap", todoInsertMap);
        } else {
            todoInsertMap.put(ERROR_MESSAGE, TodoDisplayMessage.NO_INSERT.getMessage());
            repoEntity = buildSuccessResponse("todoInsertMap", todoInsertMap);
        }
        return repoEntity;
    }

    @Override
    public ResponseEntity<ApiResponse> deleteTodoList(String todoId) {
        ResponseEntity<ApiResponse> repoEntity;
        Map<String, Object> deleteMap = new HashMap<>();
        int i = todoRepository.deleteTodoList(todoId);
        if (i > 0) {
            deleteMap.put(RETURN_MESSAGE, TodoDisplayMessage.DELETE_SUCCSESS.getMessage());
            repoEntity = buildSuccessResponse("deleteMap", deleteMap);
        } else {
            deleteMap.put(ERROR_MESSAGE, TodoDisplayMessage.NO_DELETE.getMessage());
            repoEntity = buildSuccessResponse("deleteMap", deleteMap);
        }
        return repoEntity;
    }

    @Override
    public ResponseEntity<ApiResponse> updateTodoList(TodoUpdateRequest todoUpdateRequest) {
        ResponseEntity<ApiResponse> repoEntity;
        //dataValidator.validateInstallmentAttachmentEligibilityRequest(installmentEligibilityRequest);
        Map<String, Object> todoUpdateMap = new HashMap<>();
        Map<String, Object> params = new HashMap<>();
        params.put("todo_id", todoUpdateRequest.getTodoId());
        params.put("status", todoUpdateRequest.getStatus());
        int i = todoRepository.updateTodoList(params);
        if (i > 0) {
            todoUpdateMap.put(RETURN_MESSAGE, TodoDisplayMessage.UPDATE_SUCCESS.getMessage());
            repoEntity = buildSuccessResponse("todoUpdateMap", todoUpdateMap);
        } else {
            todoUpdateMap.put(ERROR_MESSAGE, TodoDisplayMessage.NO_UPDATE.getMessage());
            repoEntity = buildSuccessResponse("todoUpdateMap", todoUpdateMap);
        }
        return repoEntity;
    }

}
