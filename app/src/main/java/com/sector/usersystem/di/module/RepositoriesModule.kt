package com.sector.usersystem.di.module

import com.sector.usersystem.di.provider.DatabaseProvider
import com.sector.usersystem.model.repository.database.UserRepository
import com.sector.usersystem.model.repository.database.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoriesModule {

    @Singleton
    @Provides
    fun provideUserRepository(databaseProvider: DatabaseProvider): UserRepository =
        UserRepositoryImpl(databaseProvider)

}