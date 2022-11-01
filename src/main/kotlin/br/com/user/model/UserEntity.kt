package br.com.user.model

import br.com.user.commons.annotations.NoArg
import io.micronaut.core.annotation.Introspected

@NoArg
@Introspected
data class UserEntity(
    var email: String?,
    var name: String,
    var age: Int
)