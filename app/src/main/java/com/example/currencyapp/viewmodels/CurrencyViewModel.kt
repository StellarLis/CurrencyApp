package com.example.currencyapp.viewmodels

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyapp.R
import com.example.domain.domain.models.CurrencyRVModel
import com.example.domain.domain.usecases.GetCurrencyListUseCase
import com.example.domain.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyViewModel @Inject constructor(
    private val getCurrencyListUseCase: GetCurrencyListUseCase
) : ViewModel() {

    val listForRV = MutableLiveData<List<CurrencyRVModel>>()
    val errorMessage = MutableLiveData<String>()

    fun setList() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getCurrencyListUseCase.execute()
            val list: List<CurrencyRVModel>
            when (result) {
                is Resource.Success -> {
                    list = result.data!!
                    list[0].imageSource = R.drawable.us
                    list[1].imageSource = R.drawable.european
                    listForRV.postValue(list)
                }
                is Resource.Error -> {
                    errorMessage.postValue(result.message!!)
                }
            }
        }
    }
}