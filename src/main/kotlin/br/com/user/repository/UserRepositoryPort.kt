package br.com.user.repository

import br.com.user.model.UserEntity

interface UserRepositoryPort {
    fun postUserRepository(userEntity: UserEntity): UserEntity
}