package br.com.user

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/user")
class UserController {

    @Get("/get")
    fun getUsers(){
        println("entrou aqui")
    }
}