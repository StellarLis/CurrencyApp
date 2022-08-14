package com.example.currencyapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyapp.R
import com.example.domain.domain.models.CurrencyRVModel
import com.example.domain.domain.usecases.GetCurrencyListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyViewModel @Inject constructor(
    private val getCurrencyListUseCase: GetCurrencyListUseCase
) : ViewModel() {

    val listForRV = MutableLiveData<List<CurrencyRVModel>>()

    fun setList() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = getCurrencyListUseCase.execute()
            list[0].imageSource = R.drawable.us
            list[1].imageSource = R.drawable.european
            listForRV.value = list
        }
    }
}