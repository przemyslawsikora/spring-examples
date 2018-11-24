/*
 * Copyright (C) 2018 Przemyslaw Sikora
 */

package com.przemyslawsikora.demos.spring.datamodel;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.io.Serializable;

@JsonTypeName("error")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class ErrorResponse {
    private ErrorCode code;
    private String message;
    private Serializable details;

    public ErrorResponse() {
    }

    public ErrorResponse(ErrorCode code, String message, Serializable details) {
        this.code = code;
        this.message = message;
        this.details = details;
    }

    public ErrorCode getCode() {
        return code;
    }

    public void setCode(ErrorCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Serializable getDetails() {
        return details;
    }

    public void setDetails(Serializable details) {
        this.details = details;
    }
}
