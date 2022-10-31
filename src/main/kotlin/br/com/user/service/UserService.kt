package br.com.user.service

import br.com.user.model.UserEntity
import br.com.user.model.UserRequest
import br.com.user.repository.UserRepositoryPort
import jakarta.inject.Singleton

@Singleton
class UserService(
    private val userRepositoryPort: UserRepositoryPort
) : UserServicePort {
    override fun getUser(email: String): UserEntity? {
        return userRepositoryPort.findOneUserRepository(email)
    }

    override fun postUser(userRequest: UserRequest): UserEntity {
        validationUser(userRequest)
        val userEntity = UserEntity(email = userRequest.email, name = userRequest.name, age = userRequest.age)
        return userRepositoryPort.postUserRepository(userEntity)
    }

    override fun putUser(userRequest: UserRequest): UserEntity {
        validationUser(userRequest)
        val userEntity = UserEntity(email = userRequest.email, name = userRequest.name, age = userRequest.age)
        return userRepositoryPort.putUserRepository(userEntity)
    }


    private fun validationUser(userRequest: UserRequest) {
        if (userRequest.age < 18) {
            throw Exception("Voce e menor de idade")
        } else if (userRequest.email?.contains("@") != true) {
            throw Exception("email invalido ")
        } else if (userRequest.name.length < 3) {
            throw Exception("nome invalido")
        }
    }
}