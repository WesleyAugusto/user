package br.com.user.repository

import br.com.user.model.UserEntity

interface UserRepositoryPort {
    fun findOneUserRepository(email:String):UserEntity?
    fun postUserRepository(userEntity: UserEntity): UserEntity
}