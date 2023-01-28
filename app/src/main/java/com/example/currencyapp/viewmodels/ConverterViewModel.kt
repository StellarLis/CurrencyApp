package com.example.currencyapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.domain.usecases.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ConverterViewModel @Inject constructor(
    private val getConvertedUsdValueUseCase: GetConvertedUsdValueUseCase,
    private val getConvertedEurValueUseCase: GetConvertedEurValueUseCase,
    private val getConvertedGbpValueUseCase: GetConvertedGbpValueUseCase,
    private val getConvertedCnyValueUseCase: GetConvertedCnyValueUseCase,
    private val getConvertedJpyValueUseCase: GetConvertedJpyValueUseCase,
    private val getConvertedInrValueUseCase: GetConvertedInrValueUseCase,
    private val getConvertedTryValueUseCase: GetConvertedTryValueUseCase,
    private val getConvertedChfValueUseCase: GetConvertedChfValueUseCase,
    private val getConvertedIlsValueUseCase: GetConvertedIlsValueUseCase
) : ViewModel() {

    val rubToUsdData = MutableLiveData<Double>()
    val rubToEurData = MutableLiveData<Double>()
    val rubToGbpData = MutableLiveData<Double>()
    val rubToCnyData = MutableLiveData<Double>()
    val rubToJpyData = MutableLiveData<Double>()
    val rubToInrData = MutableLiveData<Double>()
    val rubToTryData = MutableLiveData<Double>()
    val rubToChfData = MutableLiveData<Double>()
    val rubToIlsData = MutableLiveData<Double>()

    val usdData = MutableLiveData<Double>()
    val eurData = MutableLiveData<Double>()
    val gbpData = MutableLiveData<Double>()
    val cnyData = MutableLiveData<Double>()
    val jpyData = MutableLiveData<Double>()
    val inrData = MutableLiveData<Double>()
    val tryData = MutableLiveData<Double>()
    val chfData = MutableLiveData<Double>()
    val ilsData = MutableLiveData<Double>()

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
    fun setRubToGbpData(valToConvert: Double) {
        rubToGbpData.value = getConvertedGbpValueUseCase.execute(valToConvert, true)
    }
    fun setGbpData(valToConvert: Double) {
        gbpData.value = getConvertedGbpValueUseCase.execute(valToConvert, false)
    }
    fun setRubToCnyData(valToConvert: Double) {
        rubToCnyData.value = getConvertedCnyValueUseCase.execute(valToConvert, true)
    }
    fun setCnyData(valToConvert: Double) {
        cnyData.value = getConvertedCnyValueUseCase.execute(valToConvert, false)
    }
    fun setRubToJpyData(valToConvert: Double) {
        rubToJpyData.value = getConvertedJpyValueUseCase.execute(valToConvert, true)
    }
    fun setJpyData(valToConvert: Double) {
        jpyData.value = getConvertedJpyValueUseCase.execute(valToConvert, false)
    }
    fun setRubToInrData(valToConvert: Double) {
        rubToInrData.value = getConvertedInrValueUseCase.execute(valToConvert, true)
    }
    fun setInrData(valToConvert: Double) {
        inrData.value = getConvertedInrValueUseCase.execute(valToConvert, false)
    }
    fun setRubToTryData(valToConvert: Double) {
        rubToTryData.value = getConvertedTryValueUseCase.execute(valToConvert, true)
    }
    fun setTryData(valToConvert: Double) {
        tryData.value = getConvertedTryValueUseCase.execute(valToConvert, false)
    }
    fun setRubToChfData(valToConvert: Double) {
        rubToChfData.value = getConvertedChfValueUseCase.execute(valToConvert, true)
    }
    fun setChfData(valToConvert: Double) {
        chfData.value = getConvertedChfValueUseCase.execute(valToConvert, false)
    }
    fun setRubToIlsData(valToConvert: Double) {
        rubToIlsData.value = getConvertedIlsValueUseCase.execute(valToConvert, true)
    }
    fun setIlsData(valToConvert: Double) {
        ilsData.value = getConvertedIlsValueUseCase.execute(valToConvert, false)
    }
}