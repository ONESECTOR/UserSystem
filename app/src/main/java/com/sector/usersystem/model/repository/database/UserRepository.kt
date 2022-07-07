package com.sector.usersystem.model.repository.database

import com.sector.usersystem.entity.User

interface UserRepository {

    suspend fun getUsers(): MutableList<User>

    suspend fun addUser(user: User)

    suspend fun updateUser(user: User)

    suspend fun deleteUser(user: User)

    suspend fun deleteAllUsers()
}