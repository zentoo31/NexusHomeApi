package com.zentoo.nexushomeapi.modules.auth.dto

import com.zentoo.nexushomeapi.modules.auth.model.User
import java.time.LocalDateTime

data class UserResponse(
    val id: String?,
    val email: String,
    val name: String,
    val createAt: LocalDateTime
) {
    companion object {
        fun fromEntity(user: User) = UserResponse(
            id = user.id,
            email = user.email,
            name = user.name,
            createAt = user.createdAt
        )
    }
}
