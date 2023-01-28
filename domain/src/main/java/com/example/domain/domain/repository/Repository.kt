package com.example.domain.domain.repository

import com.example.domain.domain.models.CurrencyRVModel
import com.example.domain.domain.util.Resource

interface Repository {
    suspend fun getCurrencyList(): Resource<List<CurrencyRVModel>>
    fun getConvertedUsdValue(valToConvert: Double, isValRub: Boolean): Double
    fun getConvertedEurValue(valToConvert: Double, isValRub: Boolean): Double
    fun getConvertedGbpValue(valToConvert: Double, isValRub: Boolean): Double
    fun getConvertedCnyValue(valToConvert: Double, isValRub: Boolean): Double
    fun getConvertedJpyValue(valToConvert: Double, isValRub: Boolean): Double
    fun getConvertedInrValue(valToConvert: Double, isValRub: Boolean): Double
    fun getConvertedTryValue(valToConvert: Double, isValRub: Boolean): Double
    fun getConvertedChfValue(valToConvert: Double, isValRub: Boolean): Double
    fun getConvertedIlsValue(valToConvert: Double, isValRub: Boolean): Double
}