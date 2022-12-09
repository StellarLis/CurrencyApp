package com.example.domain.domain.repository

import com.example.domain.domain.models.CurrencyRVModel
import com.example.domain.domain.util.Resource

interface Repository {
    suspend fun getCurrencyList(): Resource<List<CurrencyRVModel>>
    fun getConvertedUsdValue(valToConvert: Double, isValRub: Boolean): Double
    fun getConvertedEurValue(valToConvert: Double, isValRub: Boolean): Double
}