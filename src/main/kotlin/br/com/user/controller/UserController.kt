package br.com.user.controller

import br.com.user.model.UserRequest
import br.com.user.service.UserServicePort
import io.micronaut.context.annotation.Parameter
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

@Controller("/user")
class UserController(private val userServicePort: UserServicePort) {

    @Get("/{name}")
    fun getUser(@Parameter name: String): String {
        return "seja bem vindo $name"
    }

    @Post
    fun postUser(@Body user: UserRequest): String {
        return userServicePort.validationUser(user)
    }
}