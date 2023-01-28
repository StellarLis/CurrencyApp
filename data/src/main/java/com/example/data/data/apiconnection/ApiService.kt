package com.example.data.data.apiconnection

import com.example.data.constance.Constance
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("latest?symbols=USD,EUR,GBP,CNY,JPY,INR,TRY,CHF,ILS&base=RUB&apikey=${Constance.API_KEY}")
    suspend fun getRates(): Response<CurrencyModel>
}