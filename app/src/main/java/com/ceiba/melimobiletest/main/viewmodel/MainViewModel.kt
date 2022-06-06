package com.ceiba.melimobiletest.main.viewmodel

import androidx.lifecycle.ViewModel
import com.ceiba.domain.usecases.ProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val productUseCase: ProductUseCase): ViewModel() {

    
}