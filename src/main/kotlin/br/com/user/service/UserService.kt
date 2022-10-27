package br.com.user.service

import br.com.user.model.UserRequest

class UserService{
    fun validationUser(userRequest: UserRequest): String {
        if(userRequest.age>=18){
            return "maior de idade"
        }
        return "menor de idade"

    }
}