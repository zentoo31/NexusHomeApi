package com.zentoo.nexushomeapi.modules.auth.dto
import jakarta.validation.constraints.Email

data class RegisterRequest(
    @field:Email(message = "El correo no es válido")
    val email: String

)
