package br.com.user.service

import br.com.user.model.UserRequest

class UserService{
    fun validationUser(userRequest: UserRequest): String {
        if(userRequest.age < 18){
            return "Voce e menor de idade"
        }
        if(userRequest.email?.contains("@") ?: false == false){
            return "email invalido "
        }

        if (userRequest.name.length < 3){
            return "nome invalido"
        }
        return "parabens cadastrou"
    }
}