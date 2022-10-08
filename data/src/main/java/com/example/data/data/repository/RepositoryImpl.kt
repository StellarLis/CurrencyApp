package com.example.data.data.repository

import com.example.data.data.apiconnection.CurrencyModel
import com.example.data.data.apiconnection.RetrofitInstance
import com.example.domain.domain.models.CurrencyRVModel
import com.example.domain.domain.repository.Repository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class RepositoryImpl() : Repository {
    var usdCurrency: Double? = 60.31
    var eurCurrency: Double? = 61.1615
    var rubToUsdCurrency: Double? = 1 / usdCurrency!!
    var rubToEurCurrency: Double? = 1 / eurCurrency!!
    val listToRV = ArrayList<CurrencyRVModel>()

    override suspend fun getCurrencyList(): List<CurrencyRVModel> {
        if (listToRV.isEmpty()) {
            val currencyUsdModel: CurrencyModel? = RetrofitInstance.getClient().getUsdRate().body()
            val currencyEurModel: CurrencyModel? = RetrofitInstance.getClient().getEurRate().body()
            // Initializing currency for getConvertedValue
            usdCurrency = currencyUsdModel?.rates?.RUB
            eurCurrency = currencyEurModel?.rates?.RUB
            rubToUsdCurrency = 1 / usdCurrency!!
            rubToEurCurrency = 1 / eurCurrency!!
            //
            val usdRVModel = CurrencyRVModel(
                currencyUsdModel?.base,
                currencyUsdModel?.date,
                currencyUsdModel?.rates?.RUB.toString() + " р.",
                0
            )
            val eurRVModel = CurrencyRVModel(
                currencyEurModel?.base,
                currencyEurModel?.date,
                currencyEurModel?.rates?.RUB.toString() + " р.",
                0
            )
            listToRV.add(usdRVModel)
            listToRV.add(eurRVModel)
        }
        return listToRV
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
