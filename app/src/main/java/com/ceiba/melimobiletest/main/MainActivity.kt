package com.ceiba.melimobiletest.main

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ceiba.domain.models.Product
import com.ceiba.domain.usecases.ProductUseCase
import com.ceiba.melimobiletest.R
import com.ceiba.melimobiletest.adapter.MainAdapter
import com.ceiba.melimobiletest.databinding.ActivityMainBinding
import com.ceiba.melimobiletest.detailproduct.view.DetailProductActivity
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

    companion object {
        const val PRODUCT_KEY = "PRODUCT"
    }

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

        mMainViewModel?.showProducts("Motorola")
        searchProducts()
        onClickDetailProduct()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observables() {
        mMainViewModel?.showListProducts?.observe(this) {
            listArrayOfProducts.clear()
            listArrayOfProducts.addAll(it)
            mMainAdapter.notifyDataSetChanged()
        }
    }

    private fun onClickDetailProduct() {
        mMainAdapter.setProductOnClickListener {
            val product = listArrayOfProducts[mActivityMainBinding.listProducts.getChildAdapterPosition(it)]
            startActivity(Intent(this, DetailProductActivity::class.java)
                .putExtra(PRODUCT_KEY, product))

        }
    }

    private fun searchProducts() {
        mActivityMainBinding.searchUsers.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                p0?.let {
                    if (it.isNotEmpty()) {
                        mMainViewModel?.showProducts(it.toString())
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }
}
