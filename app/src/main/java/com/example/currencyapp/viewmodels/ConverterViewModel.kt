package com.example.currencyapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.domain.usecases.GetConvertedEurValueUseCase
import com.example.domain.domain.usecases.GetConvertedUsdValueUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ConverterViewModel @Inject constructor(
    private val getConvertedUsdValueUseCase: GetConvertedUsdValueUseCase,
    private val getConvertedEurValueUseCase: GetConvertedEurValueUseCase
) : ViewModel() {

    val rubToUsdData = MutableLiveData<Double>()
    val usdData = MutableLiveData<Double>()
    val rubToEurData = MutableLiveData<Double>()
    val eurData = MutableLiveData<Double>()

    fun setRubToUsdData(valToConvert: Double) {
        rubToUsdData.value = getConvertedUsdValueUseCase.execute(valToConvert, true)
    }
    fun setUsdData(valToConvert: Double) {
        usdData.value = getConvertedUsdValueUseCase.execute(valToConvert, false)
    }
    fun setRubToEurData(valToConvert: Double) {
        rubToEurData.value = getConvertedEurValueUseCase.execute(valToConvert, true)
    }
    fun setEurData(valToConvert: Double) {
        eurData.value = getConvertedEurValueUseCase.execute(valToConvert, false)
    }
}