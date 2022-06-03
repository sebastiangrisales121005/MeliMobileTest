package com.ceiba.melimobiletest.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ceiba.domain.usecases.ProductUseCase
import com.ceiba.melimobiletest.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var productUseCase: ProductUseCase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      CoroutineScope(Dispatchers.Main).launch {
          withContext(Dispatchers.IO) {
              Log.e("PRODUCTS", productUseCase.getProducts().toString())
          }
      }
    }
}
