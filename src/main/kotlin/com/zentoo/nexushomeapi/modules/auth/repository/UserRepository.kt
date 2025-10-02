package com.zentoo.nexushomeapi.modules.auth.repository

import com.zentoo.nexushomeapi.modules.auth.model.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository: MongoRepository<User, String> {
    fun findByEmail(email: String): User?
}