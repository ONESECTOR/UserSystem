package com.sector.usersystem.di.module

import androidx.room.Room
import com.sector.usersystem.di.provider.DatabaseProvider
import com.sector.usersystem.presentation.App
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provide(app: App): DatabaseProvider {
        return Room
        .databaseBuilder(
            app,
            DatabaseProvider::class.java,
            DatabaseProvider.DATABASE_NAME
        )
        .fallbackToDestructiveMigration()
        .build()
    }
}