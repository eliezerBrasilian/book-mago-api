package com.example.demo.exceptions;

import java.util.Date;

public class ExceptionResponse {
    private String message;
    private String details;
    private Date timestamp;

    public ExceptionResponse(String message, String details, Date timestamp) {
        this.message = message;
        this.details = details;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

}
