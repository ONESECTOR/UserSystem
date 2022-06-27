package com.sector.usersystem.model.repository.database

import com.sector.usersystem.entity.User
import com.sector.usersystem.model.data.database.UserDao

interface UserRepository {

    suspend fun getUsers(): MutableList<User>

    suspend fun addUser(user: User)
}