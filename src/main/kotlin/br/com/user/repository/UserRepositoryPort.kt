package br.com.user.repository

import br.com.user.model.UserEntity

interface UserRepositoryPort {
    fun findAllUsersRepository(): List<UserEntity>
    fun findOneUserRepository(email: String): UserEntity?
    fun postUserRepository(userEntity: UserEntity): UserEntity
    fun putUserRepository(userEntity: UserEntity): UserEntity
    fun deleteUserRepository(email: String): String
}