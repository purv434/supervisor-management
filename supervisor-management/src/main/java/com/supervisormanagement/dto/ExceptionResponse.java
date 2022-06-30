package com.supervisormanagement.dto;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ExceptionResponse {
    private String path;

    private String message;

    private HttpStatus status;

    private Date timestamp;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public ExceptionResponse() {
    }

    public ExceptionResponse(String path, String message, HttpStatus status) {
        this.path = path;
        this.message = message;
        this.status = status;
        this.timestamp = new Date();
    }
}
