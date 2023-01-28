package com.example.domain.domain.usecases

import com.example.domain.domain.repository.Repository

class GetConvertedJpyValueUseCase(private val repository: Repository) {
    fun execute(valToConvert: Double, isRub: Boolean): Double {
        return repository.getConvertedJpyValue(valToConvert, isRub)
    }
}