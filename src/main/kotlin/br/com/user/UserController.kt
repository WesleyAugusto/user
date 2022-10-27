package br.com.user

import io.micronaut.context.annotation.Parameter
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

@Controller("/user")
class UserController {

    @Get("/{name}")
    fun getUser(@Parameter name:String):String{
        return "seja bem vindo $name"
    }

    @Post
    fun postUser(@Body user:User ):String{
        return "seja bem vindo ${user.email} ${user.name}"
    }
}

data class User(
    val email:String,
    val name:String?
)