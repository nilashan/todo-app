package com.emirates.todo.repository.impl;

import com.emirates.todo.domain.dto.TodoList;
import com.emirates.todo.domain.req.TodoUpdateRequest;
import com.emirates.todo.repository.TodoRepository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.util.*;
/**
 * Created by nilashan on 3/30/18.
 */

@Repository
public class TodoRepositoryImpl implements TodoRepository {

    @Autowired
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public TodoRepositoryImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<TodoList> getAllTodoList() {
        String query = "SELECT * FROM TODO";
        return namedParameterJdbcTemplate.query(query, Collections.emptyMap(), new BeanPropertyRowMapper<>(TodoList.class));
    }

    /**
     * @param params
     * @return status
     */
    @Override
    public int addTodoList(Map<String, Object> params) {
        String query = "INSERT INTO TODO \n" +
                "       (TODO_ID, TITLE, DESCRIPTION, STATUS) \n"+
                "       VALUES ( :todo_id, :title, :description, :status)";
        return namedParameterJdbcTemplate.update(query, params);
    }

    @Override
    public int deleteTodoList(String todo_id) {
        String query = "DELETE FROM TODO WHERE TODO_ID =:todo_id";
        Map<String, String> params = new HashMap<>();
        params.put("todo_id", todo_id);
        return namedParameterJdbcTemplate.update(query, params);
    }

    @Override
    public List<Map<String, String>> getMaxTodoId() {
        String query = "SELECT MAX(TODO_ID) from TODO";
        return namedParameterJdbcTemplate.query(query, Collections.emptyMap(),  (rs, i) -> {
            Map<String, String> returnMap = new HashMap<>();
            returnMap.put("todo_id", rs.getString(1));
            return returnMap;
        });
    }

    /**
     * @param params
     * @return status
     */
    @Override
    public int updateTodoList(Map<String, Object> params) {
        String query = "UPDATE TODO SET STATUS =:status WHERE TODO_ID = :todo_id";
        return namedParameterJdbcTemplate.update(query, params);
    }



}
