package com.ceiba.melimobiletest.main.viewmodel

import androidx.lifecycle.*
import com.ceiba.dataaccess.models.Result
import com.ceiba.domain.exception.ProductException
import com.ceiba.domain.models.Product
import com.ceiba.domain.usecases.ProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val savedStateHandle: SavedStateHandle?,
                                        private val productUseCase: ProductUseCase): ViewModel() {

    companion object {
        const val PRODUCT_KEY = "PRODUCTS"
    }

    val showMessage = MutableLiveData<String>()

    /**
     * Método que retorna la lista de productos obtenidos desde el webservice
     * a través de una corrutina
     */
    fun getProducts(filterSearch: String) = liveData {
        withContext(Dispatchers.IO) {
            emit(Result.Loading)

            kotlin.runCatching {
                productUseCase
            }.onSuccess {
                try {
                    val products = it.getProducts(filterSearch)
                    emit(Result.Success(products))
                    saveDataInChangeOrientation(products)
                } catch (exception: ProductException) {
                    showMessage.value = exception.message
                }

            }.onFailure {
                emit(Result.Error(it))
            }

        }
    }

    private fun saveDataInChangeOrientation(listProducts: List<Product>) = savedStateHandle?.set(PRODUCT_KEY, listProducts)

    fun getDataInChangeOrientation() = savedStateHandle?.get<List<Product>>(PRODUCT_KEY)


}