package com.dynamos.dto;

/**
 * Created by adelmo on 2/14/16.
 */
public class ValidationErrorMessage extends Message {

    private String field;

    private String message;

    private  ValidationErrorMessage(){}

    public ValidationErrorMessage(String field, String message){
        super("Error", message, MessageType.DANGER);

        this.field = field;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
