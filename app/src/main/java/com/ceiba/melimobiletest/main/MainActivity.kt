package com.ceiba.melimobiletest.main

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ceiba.domain.models.Product
import com.ceiba.melimobiletest.adapter.MainAdapter
import com.ceiba.melimobiletest.databinding.ActivityMainBinding
import com.ceiba.melimobiletest.detailproduct.view.DetailProductActivity
import com.ceiba.melimobiletest.idling.EspressoIdlingResource
import com.ceiba.melimobiletest.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var mActivityMainBinding: ActivityMainBinding
    private val mMainViewModel: MainViewModel? by viewModels()

    lateinit var mMainAdapter: MainAdapter
    private val listArrayOfProducts = ArrayList<Product>()

    companion object {
        const val PRODUCT_KEY = "PRODUCT"
        const val PRODUCT_DEFAULT = "Motorola"
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

        showLoading(true)

        //Uso de idling resource para notificar en que momento se finaliza la consulta al webservice
        //para las pruebas funcionales
        EspressoIdlingResource.increment()
        mMainViewModel?.showProducts(PRODUCT_DEFAULT)
        searchProducts()
        onClickDetailProduct()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observables() {
        mMainViewModel?.showListProducts?.observe(this) {
            listArrayOfProducts.clear()
            listArrayOfProducts.addAll(it)
            mMainAdapter.notifyDataSetChanged()
            //Uso de idling resource para notificar en que momento se finaliza la consulta al webservice
            //para las pruebas funcionales
            EspressoIdlingResource.decrement()
        }

        mMainViewModel?.showMessage?.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        mMainViewModel?.showLoading?.observe(this) {
            showLoading(it)
        }
    }

    /**
     * Método que permite pulsar en un ítem de la lista de productos para
     * observar el detalle
     */
    private fun onClickDetailProduct() {
        mMainAdapter.setProductOnClickListener {
            val product = listArrayOfProducts[mActivityMainBinding.listProducts.getChildAdapterPosition(it)]
            startActivity(Intent(this, DetailProductActivity::class.java)
                .putExtra(PRODUCT_KEY, product))

        }
    }

    /**
     * Método que permite la busqueda de productos desde el componente
     * editable
     */
    private fun searchProducts() {
        mActivityMainBinding.searchProducts.addTextChangedListener(object : TextWatcher{
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

    /**
     * Método que muestra componente de cargando dependiendo del estado
     */
    private fun showLoading(isVisible: Boolean) {
        when(isVisible) {
            true -> mActivityMainBinding.loading.visibility = View.VISIBLE
            else -> {mActivityMainBinding.loading.visibility = View.GONE}
        }
    }
}
