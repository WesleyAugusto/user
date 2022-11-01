package br.com.user.repository

import br.com.user.model.UserEntity
import com.mongodb.client.MongoClient
import com.mongodb.client.model.Filters
import jakarta.inject.Singleton

@Singleton
class UserRepository(
    private val mongoClient: MongoClient
) : UserRepositoryPort {

    override fun findAllUsersRepository(): List<UserEntity> {
        return getColaction().find().toList()
    }

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
        if (response == 0L) {
            throw Exception("conta nao modificada")
        }
        return userEntity
    }

    override fun deleteUserRepository(email: String): String {
        val response = getColaction().findOneAndDelete(Filters.eq("email", email)) ?: 0
        if (response == 0) {
            return "Este Email: $email Nao Foi Deletado"
        }
        return "Este Email: $email Foi Deletado "
    }

    private fun getColaction() =
        mongoClient.getDatabase("user").getCollection("user", UserEntity::class.java)
}