package com.emirates.todo.domain.util;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by nilashan on 3/30/18.
 */
@JsonPropertyOrder({"statusCode", "statusDescription"})
public class ErrorResponse {

    private int statusCode;
    private String statusDescription;


    public ErrorResponse(int statusCode, String statusDescription) {
        this.statusCode = statusCode;
        this.statusDescription = statusDescription;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "statusCode=" + statusCode +
                ", statusDescription='" + statusDescription + '\'' +
                '}';
    }
}
