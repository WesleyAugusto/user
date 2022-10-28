package br.com.user.service

import br.com.user.model.UserRequest

class UserService {
    fun validationUser(userRequest: UserRequest): String {
        return if (userRequest.age < 18) {
            "Voce e menor de idade"
        } else if (userRequest.email?.contains("@") ?: false == false) {
            "email invalido "
        } else if (userRequest.name.length < 3) {
            "nome invalido"
        } else {
            "parabens cadastrou"
        }
    }
}