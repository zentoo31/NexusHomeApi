package com.zentoo.nexushomeapi.modules.auth.dto
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class RegisterRequest(
    @field:Email(message = "El correo no es válido")
    @field:NotBlank(message = "El correo no puede estar vacío")
    val email: String,

    @field:NotBlank(message = "La contraseña no puede estar vacía")
    @field:Size(min = 6, max = 100 , message = "La contraseña debe tener entre 6 y 100 caracteres")
    val password: String,

    @field:NotBlank(message = "El nombre no puede estar vacío")
    val name: String
)
