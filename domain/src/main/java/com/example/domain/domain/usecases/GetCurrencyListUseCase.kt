package com.example.domain.domain.usecases

import com.example.domain.domain.models.CurrencyRVModel
import com.example.domain.domain.repository.Repository

class GetCurrencyListUseCase(private val repository: Repository) {

    suspend fun execute(): List<CurrencyRVModel> {
        return repository.getCurrencyList()
    }
}