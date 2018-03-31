package com.emirates.todo.domain.util;

/**
 * Created by nilashan on 3/31/18.
 */
public enum TodoDisplayMessage {

    NO_RECORD(0001, "No record found!"),
    SAVE_SUCCSESS(0002, "Saved successfully!"),
    DELETE_SUCCSESS(0003, "Todo list deleted successfully!"),
    NO_DELETE(0004, "Unable to delete the todo item!"),
    NO_INSERT(0005, "No record inserted!"),
    UPDATE_SUCCESS(0006, "Updated successfully!"),
    NO_UPDATE(0007, "No record updated!");

    private int messageCode;
    private String message;

    TodoDisplayMessage(int messageCode, String message) {
        this.messageCode = messageCode;
        this.message = message;
    }

    public int getMessageCode() {
        return messageCode;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "TodoDisplayMessage{" +
                "messageCode=" + messageCode +
                ", message='" + message + '\'' +
                '}';
    }
}
