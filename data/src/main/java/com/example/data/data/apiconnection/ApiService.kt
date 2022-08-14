package com.example.data.data.apiconnection

import com.example.data.constance.Constance
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("latest?symbols=RUB&base=USD&apikey=${Constance.API_KEY}")
    suspend fun getUsdRate(): Response<CurrencyModel>

    @GET("latest?symbols=RUB&base=EUR&apikey=${Constance.API_KEY}")
    suspend fun getEurRate(): Response<CurrencyModel>
}