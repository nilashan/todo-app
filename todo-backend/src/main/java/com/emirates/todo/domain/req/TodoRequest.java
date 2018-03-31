package com.emirates.todo.domain.req;

import lombok.Data;

/**
 * Created by nilashan on 3/31/18.
 */
@Data
public class TodoRequest {

    private String title;

    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
