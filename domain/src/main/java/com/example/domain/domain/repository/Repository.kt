package com.example.domain.domain.repository

import com.example.domain.domain.models.CurrencyRVModel

interface Repository {
    suspend fun getCurrencyList(): List<CurrencyRVModel>
    fun getConvertedUsdValue(valToConvert: Double, isValRub: Boolean): Double
    fun getConvertedEurValue(valToConvert: Double, isValRub: Boolean): Double
}