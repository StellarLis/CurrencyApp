package com.example.data.data.repository

import com.example.data.data.apiconnection.RetrofitInstance
import com.example.domain.domain.models.CurrencyRVModel
import com.example.domain.domain.repository.Repository
import com.example.domain.domain.util.Resource
import retrofit2.HttpException
import java.io.IOException
import kotlin.math.roundToInt

class RepositoryImpl : Repository {
    var usdCurrency: Double = 0.0
    var eurCurrency: Double = 0.0
    var gbpCurrency: Double = 0.0
    var cnyCurrency: Double = 0.0
    var jpyCurrency: Double = 0.0
    var inrCurrency: Double = 0.0
    var tryCurrency: Double = 0.0
    var chfCurrency: Double = 0.0
    var ilsCurrency: Double = 0.0
    var rubToUsdCurrency: Double = 0.0
    var rubToEurCurrency: Double = 0.0
    var rubToGbpCurrency: Double = 0.0
    var rubToCnyCurrency: Double = 0.0
    var rubToJpyCurrency: Double = 0.0
    var rubToInrCurrency: Double = 0.0
    var rubToTryCurrency: Double = 0.0
    var rubToChfCurrency: Double = 0.0
    var rubToIlsCurrency: Double = 0.0
    val listToRV = ArrayList<CurrencyRVModel>()

    override suspend fun getCurrencyList(): Resource<List<CurrencyRVModel>> {
        if (listToRV.isEmpty()) {
            val ratesResult = try {
                Resource.Success(RetrofitInstance.getClient().getRates())
            } catch(e: IOException) {
                Resource.Error("You might not have internet connection, try to reopen app")
            } catch(e: HttpException) {
                Resource.Error("Unexpected response, try to reopen app")
            }
            if (ratesResult is Resource.Success) {
                // Initializing currency for getConvertedValue
                rubToUsdCurrency = ratesResult.data?.body()?.rates?.USD!!
                rubToEurCurrency = ratesResult.data?.body()?.rates?.EUR!!
                rubToGbpCurrency = ratesResult.data?.body()?.rates?.GBP!!
                rubToCnyCurrency = ratesResult.data?.body()?.rates?.CNY!!
                rubToJpyCurrency = ratesResult.data?.body()?.rates?.JPY!!
                rubToInrCurrency = ratesResult.data?.body()?.rates?.INR!!
                rubToTryCurrency = ratesResult.data?.body()?.rates?.TRY!!
                rubToChfCurrency = ratesResult.data?.body()?.rates?.CHF!!
                rubToIlsCurrency = ratesResult.data?.body()?.rates?.ILS!!
                usdCurrency = 1 / rubToUsdCurrency
                eurCurrency = 1 / rubToEurCurrency
                gbpCurrency = 1 / rubToGbpCurrency
                cnyCurrency = 1 / rubToCnyCurrency
                jpyCurrency = 1 / rubToJpyCurrency
                inrCurrency = 1 / rubToInrCurrency
                tryCurrency = 1 / rubToTryCurrency
                chfCurrency = 1 / rubToChfCurrency
                ilsCurrency = 1 / rubToIlsCurrency
                //
                val usdRVModel = CurrencyRVModel("USD", ratesResult.data?.body()?.date!!, ((usdCurrency * 100.0).roundToInt() / 100.0).toString() + " р.", 0)
                val eurRVModel = CurrencyRVModel("EUR", ratesResult.data?.body()?.date!!, ((eurCurrency * 100.0).roundToInt() / 100.0).toString() + " р.", 0)
                val gbpRVModel = CurrencyRVModel("GBP", ratesResult.data?.body()?.date!!, ((gbpCurrency * 100.0).roundToInt() / 100.0).toString() + " р.", 0)
                val cnyRVModel = CurrencyRVModel("CNY", ratesResult.data?.body()?.date!!, ((cnyCurrency * 100.0).roundToInt() / 100.0).toString() + " р.", 0)
                val jpyRVModel = CurrencyRVModel("JPY", ratesResult.data?.body()?.date!!, ((jpyCurrency * 100.0).roundToInt() / 100.0).toString() + " р.", 0)
                val inrRVModel = CurrencyRVModel("INR", ratesResult.data?.body()?.date!!, ((inrCurrency * 100.0).roundToInt() / 100.0).toString() + " р.", 0)
                val tryRVModel = CurrencyRVModel("TRY", ratesResult.data?.body()?.date!!, ((tryCurrency * 100.0).roundToInt() / 100.0).toString() + " р.", 0)
                val chfRVModel = CurrencyRVModel("CHF", ratesResult.data?.body()?.date!!, ((chfCurrency * 100.0).roundToInt() / 100.0).toString() + " р.", 0)
                val ilsRVModel = CurrencyRVModel("ILS", ratesResult.data?.body()?.date!!, ((ilsCurrency * 100.0).roundToInt() / 100.0).toString() + " р.", 0)
                listToRV.add(usdRVModel)
                listToRV.add(eurRVModel)
                listToRV.add(gbpRVModel)
                listToRV.add(cnyRVModel)
                listToRV.add(jpyRVModel)
                listToRV.add(inrRVModel)
                listToRV.add(tryRVModel)
                listToRV.add(chfRVModel)
                listToRV.add(ilsRVModel)
                return Resource.Success(listToRV)
            } else {
                return Resource.Error(ratesResult.message!!)
            }
        } else {
            return Resource.Success(listToRV)
        }
    }

    override fun getConvertedUsdValue(valToConvert: Double, isValRub: Boolean): Double {
        var result = if (isValRub) {
            valToConvert * rubToUsdCurrency
        } else {
            valToConvert * usdCurrency
        }
        result = (result * 100.0).roundToInt() / 100.0
        return result
    }

    override fun getConvertedEurValue(valToConvert: Double, isValRub: Boolean): Double {
        var result: Double
        if (isValRub) {
            result = valToConvert * rubToEurCurrency
        } else {
            result = valToConvert * eurCurrency
        }
        result = (result * 100.0).roundToInt() / 100.0
        return result
    }

    override fun getConvertedGbpValue(valToConvert: Double, isValRub: Boolean): Double {
        var result: Double
        if (isValRub) {
            result = valToConvert * rubToGbpCurrency
        } else {
            result = valToConvert * gbpCurrency
        }
        result = (result * 100.0).roundToInt() / 100.0
        return result
    }

    override fun getConvertedCnyValue(valToConvert: Double, isValRub: Boolean): Double {
        var result: Double
        if (isValRub) {
            result = valToConvert * rubToCnyCurrency
        } else {
            result = valToConvert * cnyCurrency
        }
        result = (result * 100.0).roundToInt() / 100.0
        return result
    }

    override fun getConvertedJpyValue(valToConvert: Double, isValRub: Boolean): Double {
        var result: Double
        if (isValRub) {
            result = valToConvert * rubToJpyCurrency
        } else {
            result = valToConvert * jpyCurrency
        }
        result = (result * 100.0).roundToInt() / 100.0
        return result
    }

    override fun getConvertedInrValue(valToConvert: Double, isValRub: Boolean): Double {
        var result: Double
        if (isValRub) {
            result = valToConvert * rubToInrCurrency
        } else {
            result = valToConvert * inrCurrency
        }
        result = (result * 100.0).roundToInt() / 100.0
        return result
    }

    override fun getConvertedTryValue(valToConvert: Double, isValRub: Boolean): Double {
        var result: Double
        if (isValRub) {
            result = valToConvert * rubToTryCurrency
        } else {
            result = valToConvert * tryCurrency
        }
        result = (result * 100.0).roundToInt() / 100.0
        return result
    }

    override fun getConvertedChfValue(valToConvert: Double, isValRub: Boolean): Double {
        var result: Double
        if (isValRub) {
            result = valToConvert * rubToChfCurrency
        } else {
            result = valToConvert * chfCurrency
        }
        result = (result * 100.0).roundToInt() / 100.0
        return result
    }

    override fun getConvertedIlsValue(valToConvert: Double, isValRub: Boolean): Double {
        var result: Double
        if (isValRub) {
            result = valToConvert * rubToIlsCurrency
        } else {
            result = valToConvert * ilsCurrency
        }
        result = (result * 100.0).roundToInt() / 100.0
        return result
    }
}
