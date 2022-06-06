package com.ceiba.melimobiletest.main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ceiba.domain.models.Product
import com.ceiba.domain.usecases.ProductUseCase
import com.ceiba.melimobiletest.R
import com.ceiba.melimobiletest.adapter.MainAdapter
import com.ceiba.melimobiletest.databinding.ActivityMainBinding
import com.ceiba.melimobiletest.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var mActivityMainBinding: ActivityMainBinding
    private val mMainViewModel: MainViewModel? by viewModels()

    lateinit var mMainAdapter: MainAdapter
    private val listArrayOfProducts = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mActivityMainBinding.root)

        initializeWidgets()
        observables()

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private fun initializeWidgets() {
        mMainAdapter = MainAdapter(this, listArrayOfProducts)

        with(mActivityMainBinding.listProducts) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mMainAdapter
        }

        mMainViewModel?.showProducts()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observables() {
        mMainViewModel?.showListProducts?.observe(this) {
            listArrayOfProducts.clear()
            listArrayOfProducts.addAll(it)
            mMainAdapter.notifyDataSetChanged()
        }
    }
}
