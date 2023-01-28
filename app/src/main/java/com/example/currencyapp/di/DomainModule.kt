package com.example.currencyapp.di

import com.example.domain.domain.repository.Repository
import com.example.domain.domain.usecases.*
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
    @Provides
    fun provideGetConvertedGbpValueUseCase(repository: Repository): GetConvertedGbpValueUseCase {
        return GetConvertedGbpValueUseCase(repository)
    }
    @Provides
    fun provideGetConvertedCnyValueUseCase(repository: Repository): GetConvertedCnyValueUseCase {
        return GetConvertedCnyValueUseCase(repository)
    }
    @Provides
    fun provideGetConvertedJpyValueUseCase(repository: Repository): GetConvertedJpyValueUseCase {
        return GetConvertedJpyValueUseCase(repository)
    }
    @Provides
    fun provideGetConvertedInrValueUseCase(repository: Repository): GetConvertedInrValueUseCase {
        return GetConvertedInrValueUseCase(repository)
    }
    @Provides
    fun provideGetConvertedTryValueUseCase(repository: Repository): GetConvertedTryValueUseCase {
        return GetConvertedTryValueUseCase(repository)
    }
    @Provides
    fun provideGetConvertedChfValueUseCase(repository: Repository): GetConvertedChfValueUseCase {
        return GetConvertedChfValueUseCase(repository)
    }
    @Provides
    fun provideGetConvertedIlsValueUseCase(repository: Repository): GetConvertedIlsValueUseCase {
        return GetConvertedIlsValueUseCase(repository)
    }
}