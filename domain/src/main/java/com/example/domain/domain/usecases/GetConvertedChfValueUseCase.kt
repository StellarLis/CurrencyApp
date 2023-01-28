package com.example.domain.domain.usecases

import com.example.domain.domain.repository.Repository

class GetConvertedChfValueUseCase(private val repository: Repository) {

    fun execute(valToConvert: Double, isRub: Boolean): Double {
        return repository.getConvertedChfValue(valToConvert, isRub)
    }
}