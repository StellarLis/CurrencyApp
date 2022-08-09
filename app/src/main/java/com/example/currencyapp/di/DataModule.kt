package com.example.currencyapp.di

import com.example.data.data.repository.RepositoryImpl
import com.example.domain.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun provideRepository(): Repository {
        return RepositoryImpl()
    }
}