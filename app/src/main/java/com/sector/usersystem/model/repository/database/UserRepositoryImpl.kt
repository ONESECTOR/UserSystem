package com.sector.usersystem.model.repository.database

import com.sector.usersystem.di.provider.DatabaseProvider
import com.sector.usersystem.entity.User
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private var databaseProvider: DatabaseProvider
): UserRepository {

    override suspend fun getUsers(): MutableList<User> =
        databaseProvider.userDao().getUsers()

    override suspend fun addUser(user: User) {
        databaseProvider.userDao().addUser(user)
    }

    override suspend fun updateUser(user: User) {
        databaseProvider.userDao().updateUser(user)
    }

    override suspend fun deleteAll() {
        databaseProvider.userDao().deleteAll()
    }
}