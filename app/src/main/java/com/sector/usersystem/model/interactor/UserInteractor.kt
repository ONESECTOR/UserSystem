package com.sector.usersystem.model.interactor

import com.sector.usersystem.entity.User
import com.sector.usersystem.model.repository.database.UserRepository
import javax.inject.Inject

class UserInteractor @Inject constructor(
    private var userRepository: UserRepository
) {

    suspend fun getUsers() = userRepository.getUsers()

    suspend fun addUser(user: User) {
        userRepository.addUser(user)
    }

    suspend fun updateUser(user: User) {
        userRepository.updateUser(user)
    }

    suspend fun deleteUser(user: User) {
        userRepository.deleteUser(user)
    }

    suspend fun deleteAll() {
        userRepository.deleteAll()
    }
}