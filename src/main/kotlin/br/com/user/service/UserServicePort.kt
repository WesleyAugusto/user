package br.com.user.service

import br.com.user.model.UserEntity
import br.com.user.model.UserRequest

interface UserServicePort {
    fun getAllUsers(): List<UserEntity>
    fun getUser(email: String): UserEntity?
    fun postUser(userRequest: UserRequest): UserEntity
    fun putUser(userRequest: UserRequest): UserEntity
    fun deleteUser(email: String): String
}