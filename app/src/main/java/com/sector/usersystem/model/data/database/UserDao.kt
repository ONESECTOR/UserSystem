package com.sector.usersystem.model.data.database

import androidx.room.*
import com.sector.usersystem.entity.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend  fun addUser(user: User)

    @Query("SELECT * FROM users ORDER BY id ASC")
    fun getUsers(): MutableList<User>

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM users")
    fun deleteAllUsers()
}