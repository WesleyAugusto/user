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
        println(email)
      val response = getColaction().find(Filters.eq("email", email)).toList().first()
        print(response)
        return response
    }

    override fun postUserRepository(userEntity: UserEntity): UserEntity {
        getColaction().insertOne(userEntity)
        return userEntity
    }

    private fun getColaction() =
        mongoClient.getDatabase("user").getCollection("user", UserEntity::class.java)
}