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

    override fun validationUser(userRequest: UserRequest): String {
        return if (userRequest.age < 18) {
            "Voce e menor de idade"
        } else if (userRequest.email?.contains("@") != true) {
            "email invalido "
        } else if (userRequest.name.length < 3) {
            "nome invalido"
        } else {
            val userEntity = UserEntity(email = userRequest.email, name = userRequest.name, age = userRequest.age)
            val userRepository = userRepositoryPort.postUserRepository(userEntity)
            "parabens cadastrou"
        }
    }
}