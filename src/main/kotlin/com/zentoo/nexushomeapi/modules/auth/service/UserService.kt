package com.zentoo.nexushomeapi.modules.auth.service

import com.zentoo.nexushomeapi.modules.auth.dto.RegisterRequest
import com.zentoo.nexushomeapi.modules.auth.model.User
import com.zentoo.nexushomeapi.modules.auth.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService (
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
){
    fun registerUser(request: RegisterRequest): User {
        if (userRepository.findByEmail(request.email) != null) {
            throw IllegalArgumentException("El usuario ya existe");
        }

        val hashedPassword = passwordEncoder.encode(request.password);

        val newUser = User(
            email = request.email,
            password = hashedPassword,
            name = request.name
        );

        return userRepository.save(newUser);
    }

    fun getAllUsers(): List<User> {
        return userRepository.findAll();
    }
}