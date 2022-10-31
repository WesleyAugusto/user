package br.com.user.controller

import br.com.user.model.UserEntity
import br.com.user.model.UserRequest
import br.com.user.service.UserServicePort
import io.micronaut.context.annotation.Parameter
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put

@Controller("/user")
class UserController(private val userServicePort: UserServicePort) {

    @Get("/{email}")
    fun getUser(@Parameter email: String): UserEntity? {
        return userServicePort.getUser(email)
    }

    @Post
    fun postUser(@Body user: UserRequest): UserEntity {
        return userServicePort.postUser(user)
    }

    @Put
    fun putUser(@Body user:UserRequest): UserEntity{
        return userServicePort.putUser(user)
    }
}