/*
 * Copyright (C) 2018 Przemyslaw Sikora
 */

package com.przemyslawsikora.demos.spring

import com.przemyslawsikora.demos.spring.exception.UserNotFoundException
import org.springframework.stereotype.Repository

@Repository
class UserRepository {

    @Throws(UserNotFoundException::class)
    fun findById(id: Long): User {
        return when (id) {
            1L -> User(1, "John")
            2L -> User(2, "Lloyd")
            3L -> User(3, "Teresa")
            else -> throw UserNotFoundException(id)
        }
    }
}
