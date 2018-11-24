/*
 * Copyright (C) 2018 Przemyslaw Sikora
 */

package com.przemyslawsikora.demos.spring.controller;

import com.przemyslawsikora.demos.spring.datamodel.ErrorCode;
import com.przemyslawsikora.demos.spring.datamodel.ErrorResponse;
import com.przemyslawsikora.demos.spring.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleResourceNotFound(
            final EntityNotFoundException exception, final HttpServletRequest request) {
        return new ErrorResponse(ErrorCode.NOT_FOUND, exception.getMessage(), null);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    public ErrorResponse handleHttpRequestMethodNotSupported(
            final HttpRequestMethodNotSupportedException exception, final HttpServletRequest request) {
        return new ErrorResponse(ErrorCode.METHOD_NOT_ALLOWED, exception.getMessage(), null);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleMethodArgumentTypeMismatch(
            final MethodArgumentTypeMismatchException exception, final HttpServletRequest request) {
        return new ErrorResponse(
                ErrorCode.METHOD_ARGUMENT_TYPE_MISMATCH,
                String.format("Argument %s should be of type %s",
                        exception.getName(), exception.getRequiredType().getName()),
                exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleAllExceptions(final Exception exception,
                                             final HttpServletRequest request) {
        return new ErrorResponse(ErrorCode.SERVICE_ERROR, exception.getMessage(), null);
    }
}
