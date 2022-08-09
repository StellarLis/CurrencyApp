package com.example.currencyapp.di

import com.example.domain.domain.repository.Repository
import com.example.domain.domain.usecases.GetConvertedEurValueUseCase
import com.example.domain.domain.usecases.GetConvertedUsdValueUseCase
import com.example.domain.domain.usecases.GetCurrencyListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {
    @Provides
    fun provideGetCurrencyListUseCase(repository: Repository): GetCurrencyListUseCase {
        return GetCurrencyListUseCase(repository)
    }
    @Provides
    fun provideGetConvertedUsdValueUseCase(repository: Repository): GetConvertedUsdValueUseCase {
        return GetConvertedUsdValueUseCase(repository)
    }
    @Provides
    fun provideGetConvertedEurValueUseCase(repository: Repository): GetConvertedEurValueUseCase {
        return GetConvertedEurValueUseCase(repository)
    }
}