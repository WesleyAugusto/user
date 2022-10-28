package br.com.user.repository

import br.com.user.model.UserEntity
import com.mongodb.client.MongoClient
import jakarta.inject.Singleton

@Singleton
class UserRepository(
    private val mongoClient: MongoClient
) : UserRepositoryPort {
    override fun postUserRepository(userEntity: UserEntity): UserEntity {
        getColaction().insertOne(userEntity)
        return userEntity
    }

    private fun getColaction() =
        mongoClient.getDatabase("user").getCollection("user", UserEntity::class.java)
}