package com.ceiba.melimobiletest.detailproduct.view

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ceiba.domain.models.Product
import com.ceiba.melimobiletest.adapter.DetailProductAdapter
import com.ceiba.melimobiletest.databinding.ActivityDetailProductBinding
import com.ceiba.melimobiletest.main.MainActivity.Companion.PRODUCT_KEY
import com.squareup.picasso.Picasso

class DetailProductActivity : AppCompatActivity() {
    lateinit var mActivityDetailProductBinding: ActivityDetailProductBinding
    lateinit var mDetailProductAdapter: DetailProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityDetailProductBinding = ActivityDetailProductBinding.inflate(layoutInflater)
        setContentView(mActivityDetailProductBinding.root)

        initializeWidgets()
    }

    private fun initializeWidgets() {
        intent.extras?.let {
            val product = it.getSerializable(PRODUCT_KEY) as Product

            mDetailProductAdapter = DetailProductAdapter(this, product.specs)
            with(mActivityDetailProductBinding.listSpecs) {
                layoutManager = LinearLayoutManager(this@DetailProductActivity)
                adapter = mDetailProductAdapter
            }

            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)

            showDataDetailProduct(product)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showDataDetailProduct(product: Product) {
        val cityState = "${product.addressProduct.stateName} - ${product.addressProduct.cityName}"
        val price = "$${product.price}"

        Picasso.get().load(product.imageProduct).into(mActivityDetailProductBinding.imageProduct)
        mActivityDetailProductBinding.titleProduct.text = product.title
        mActivityDetailProductBinding.priceProduct.text = price
        mActivityDetailProductBinding.cityProduct.text = cityState
    }
}