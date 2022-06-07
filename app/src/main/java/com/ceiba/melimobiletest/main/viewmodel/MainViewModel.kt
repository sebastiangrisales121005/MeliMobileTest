package com.ceiba.melimobiletest.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ceiba.domain.exception.ProductException
import com.ceiba.domain.models.Product
import com.ceiba.domain.usecases.ProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val productUseCase: ProductUseCase): ViewModel() {

    val showListProducts = MutableLiveData<List<Product>>()
    val showMessage = MutableLiveData<String>()
    val showLoading = MutableLiveData<Boolean>()

    fun showProducts(filterSearch: String) {
        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                try {
                    val products = getProducts(filterSearch)
                    if (products.isNotEmpty()) {
                        showListProducts.value = getProducts(filterSearch)
                        showLoading.value = false
                    }
                } catch (exception: ProductException) {
                    showMessage.value = exception.message
                }

            }
        }
    }

    private suspend fun getProducts(filterSearch: String): List<Product> =
        withContext(Dispatchers.IO) { productUseCase.getProducts(filterSearch) }


}