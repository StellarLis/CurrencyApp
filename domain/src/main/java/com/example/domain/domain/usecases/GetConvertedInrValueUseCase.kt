package com.example.domain.domain.usecases

import com.example.domain.domain.repository.Repository

class GetConvertedInrValueUseCase(private val repository: Repository) {
    fun execute(valToConvert: Double, isRub: Boolean): Double {
        return repository.getConvertedInrValue(valToConvert, isRub)
    }
}