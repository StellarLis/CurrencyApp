package com.example.domain.domain.usecases

import com.example.domain.domain.models.CurrencyRVModel
import com.example.domain.domain.repository.Repository
import com.example.domain.domain.util.Resource

class GetCurrencyListUseCase(private val repository: Repository) {
    suspend fun execute(): Resource<List<CurrencyRVModel>> {
        return repository.getCurrencyList()
    }
}