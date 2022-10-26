package br.com.user

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/user")
class UserController {

    @Get("/get")
    fun getUsers():String{
        return "seja bem vindo"
    }
}