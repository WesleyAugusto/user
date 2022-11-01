package br.com.user.controller

import br.com.user.model.UserEntity
import br.com.user.model.UserRequest
import br.com.user.service.UserServicePort
import io.micronaut.context.annotation.Parameter
import io.micronaut.http.annotation.*

@Controller("/user")
class UserController(private val userServicePort: UserServicePort) {

    @Get
    fun getAllUsers(): List<UserEntity> {
        return userServicePort.getAllUsers()
    }

    @Get("/{email}")
    fun getUser(@Parameter email: String): UserEntity? {
        return userServicePort.getUser(email)
    }

    @Post
    fun postUser(@Body user: UserRequest): UserEntity {
        return userServicePort.postUser(user)
    }

    @Put
    fun putUser(@Body user: UserRequest): UserEntity {
        return userServicePort.putUser(user)
    }

    @Delete("/{email}")
    fun deleteUSer(@Parameter email: String): String {
        return userServicePort.deleteUser(email)
    }
}