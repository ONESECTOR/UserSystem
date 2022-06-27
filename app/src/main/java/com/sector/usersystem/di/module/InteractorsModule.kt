package com.sector.usersystem.di.module

import com.sector.usersystem.model.interactor.UserInteractor
import com.sector.usersystem.model.repository.database.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class InteractorsModule {

    @Singleton
    @Provides
    fun provideUserInteractor(
        profileRepository: UserRepository
    ): UserInteractor = UserInteractor(
        profileRepository
    )
}