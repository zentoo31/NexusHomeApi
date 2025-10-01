package com.zentoo.nexushomeapi.modules.auth.model
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
data class User(
    @Id
    val id: String? = null,
    val email: String,
    val password: String,
    val name: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
