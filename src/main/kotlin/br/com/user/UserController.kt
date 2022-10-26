package br.com.user

import io.micronaut.context.annotation.Parameter
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/user")
class UserController {

    @Get("/{name}")
    fun getUsers(@Parameter name:String):String{
        return "seja bem vindo $name"
    }
}