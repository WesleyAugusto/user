package br.com.user.service

import br.com.user.model.UserEntity
import br.com.user.model.UserRequest

interface UserServicePort {
    fun getUser(email: String): UserEntity?
    fun validationUser(userRequest: UserRequest): String
}