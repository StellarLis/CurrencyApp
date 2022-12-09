package com.example.data.data.repository

import android.util.Log
import com.example.data.data.apiconnection.CurrencyModel
import com.example.data.data.apiconnection.RetrofitInstance
import com.example.domain.domain.models.CurrencyRVModel
import com.example.domain.domain.repository.Repository
import com.example.domain.domain.util.Resource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import retrofit2.HttpException
import java.io.IOException

class RepositoryImpl() : Repository {
    var usdCurrency: Double? = null
    var eurCurrency: Double? = null
    var rubToUsdCurrency: Double? = null
    var rubToEurCurrency: Double? = null
    val listToRV = ArrayList<CurrencyRVModel>()

    override suspend fun getCurrencyList(): Resource<List<CurrencyRVModel>> {
        if (listToRV.isEmpty()) {
            var errorMessage: String? = null
            val usdResult = try {
                Resource.Success(RetrofitInstance.getClient().getUsdRate())
            } catch(e: IOException) {
                Resource.Error("You might not have internet connection, try to reopen app")
            } catch(e: HttpException) {
                Resource.Error("Unexpected response, try to reopen app")
            }
            val eurResult = try {
                Resource.Success(RetrofitInstance.getClient().getEurRate())
            } catch(e: IOException) {
                Resource.Error("You might not have internet connection, try to reopen app")
            } catch(e: HttpException) {
                Resource.Error("Unexpected response, try to reopen app")
            }
            if (usdResult is Resource.Success) {
                val currencyUsdModel: CurrencyModel = usdResult.data?.body()!!
                val currencyEurModel: CurrencyModel = eurResult.data?.body()!!
                // Initializing currency for getConvertedValue
                usdCurrency = currencyUsdModel.rates.RUB
                eurCurrency = currencyEurModel.rates.RUB
                rubToUsdCurrency = 1 / usdCurrency!!
                rubToEurCurrency = 1 / eurCurrency!!
                //
                val usdRVModel = CurrencyRVModel(
                    currencyUsdModel.base,
                    currencyUsdModel.date,
                    currencyUsdModel.rates.RUB.toString() + " р.",
                    0
                )
                val eurRVModel = CurrencyRVModel(
                    currencyEurModel.base,
                    currencyEurModel.date,
                    currencyEurModel.rates.RUB.toString() + " р.",
                    0
                )
                listToRV.add(usdRVModel)
                listToRV.add(eurRVModel)
                return Resource.Success(listToRV)
            } else {
                usdCurrency = 0.0
                eurCurrency = 0.0
                rubToUsdCurrency = 0.0
                rubToEurCurrency = 0.0
                return Resource.Error(usdResult.message!!)
            }
        } else {
            return Resource.Success(listToRV)
        }
    }

    override fun getConvertedUsdValue(valToConvert: Double, isValRub: Boolean): Double {
        var result: Double? = null
        if (isValRub) {
            result = valToConvert * usdCurrency!!
        } else {
            result = valToConvert * rubToUsdCurrency!!
        }
        return result
    }

    override fun getConvertedEurValue(valToConvert: Double, isValRub: Boolean): Double {
        var result: Double? = null
        if (isValRub) {
            result = valToConvert * eurCurrency!!
        } else {
            result = valToConvert * rubToEurCurrency!!
        }
        return result
    }
}
