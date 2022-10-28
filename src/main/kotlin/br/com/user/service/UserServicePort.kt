package br.com.user.service

import br.com.user.model.UserRequest

interface UserServicePort {
    fun validationUser(userRequest: UserRequest): String
}