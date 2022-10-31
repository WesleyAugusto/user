package br.com.user.repository

import br.com.user.model.UserEntity
import com.mongodb.client.MongoClient
import com.mongodb.client.model.Filters
import jakarta.inject.Singleton

@Singleton
class UserRepository(
    private val mongoClient: MongoClient
) : UserRepositoryPort {
    override fun findOneUserRepository(email: String): UserEntity? {
        return getColaction().find(Filters.eq("email", email)).toList().first()
    }

    override fun postUserRepository(userEntity: UserEntity): UserEntity {
        val response = getColaction().find(Filters.eq("email", userEntity.email)).toList().first()
        if (response != null) {
            throw Exception("Email Ja Cadastrado")
        }
        getColaction().insertOne(userEntity)
        return userEntity
    }

    override fun putUserRepository(userEntity: UserEntity): UserEntity {
         val response = getColaction().replaceOne(Filters.eq("email", userEntity.email), userEntity).modifiedCount
        if (response == 0L){
            throw Exception("conta nao modificada")
        }
        return userEntity
    }

    private fun getColaction() =
        mongoClient.getDatabase("user").getCollection("user", UserEntity::class.java)
}