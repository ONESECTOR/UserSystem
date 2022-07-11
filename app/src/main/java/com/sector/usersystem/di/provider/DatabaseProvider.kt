package com.sector.usersystem.di.provider

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sector.usersystem.entity.User
import com.sector.usersystem.model.data.database.UserDao

@Database(
    entities = [
        User::class
    ],
    version = 2,
    exportSchema = false
)
abstract class DatabaseProvider: RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "usersystem_db"
    }

    abstract fun userDao(): UserDao
}