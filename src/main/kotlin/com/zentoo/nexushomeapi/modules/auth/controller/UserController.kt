package com.zentoo.nexushomeapi.modules.auth.controller

import com.zentoo.nexushomeapi.modules.auth.dto.RegisterRequest
import com.zentoo.nexushomeapi.modules.auth.dto.UserResponse
import com.zentoo.nexushomeapi.modules.auth.service.UserService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class UserController(
    private val userService: UserService
) {
    @PostMapping("/register")
    fun register(@Valid @RequestBody request: RegisterRequest): ResponseEntity<UserResponse> {
        return try {
            val user = userService.registerUser(request);
            ResponseEntity.ok(UserResponse.fromEntity(user));
        } catch(e: IllegalArgumentException) {
            ResponseEntity.badRequest().build();
        }
    }
}