package br.com.user.model

import br.com.user.commons.annotations.NoArg

@NoArg
data class UserEntity(
    val email:String?,
    val name:String,
    val age:Int
)