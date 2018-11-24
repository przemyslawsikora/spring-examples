/*
 * Copyright (C) 2018 Przemyslaw Sikora
 */

package com.przemyslawsikora.demos.spring

import spock.lang.Specification

class UserRepositorySpec extends Specification {
    def "There shall be ability to find a user by his id"() {
        given: "a user repository"
        def userRepository = new UserRepository()

        expect: "user we want to find by his id has in fact the same id"
        userRepository.findById(1L).id == 1L
    }
}
