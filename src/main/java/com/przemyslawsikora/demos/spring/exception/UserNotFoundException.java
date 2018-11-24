/*
 * Copyright (C) 2018 Przemyslaw Sikora
 */

package com.przemyslawsikora.demos.spring.exception;

public class UserNotFoundException extends EntityNotFoundException {
    private final Long userId;

    public UserNotFoundException(Long userId) {
        this.userId = userId;
    }

    @Override
    public String getMessage() {
        return String.format("User with ID %d is not found", userId);
    }
}
