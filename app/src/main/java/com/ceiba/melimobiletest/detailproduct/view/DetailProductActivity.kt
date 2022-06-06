package com.ceiba.melimobiletest.detailproduct.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ceiba.domain.models.Specs
import com.ceiba.melimobiletest.adapter.DetailProductAdapter
import com.ceiba.melimobiletest.databinding.ActivityDetailProductBinding

class DetailProductActivity : AppCompatActivity() {
    lateinit var mActivityDetailProductBinding: ActivityDetailProductBinding
    lateinit var mDetailProductAdapter: DetailProductAdapter

    private val listArraySpecs = ArrayList<Specs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityDetailProductBinding = ActivityDetailProductBinding.inflate(layoutInflater)
        setContentView(mActivityDetailProductBinding.root)

        initializeWidgets()
    }

    private fun initializeWidgets() {
        mDetailProductAdapter = DetailProductAdapter(this, listArraySpecs)
        with(mActivityDetailProductBinding.listSpecs) {
            layoutManager = LinearLayoutManager(this@DetailProductActivity)
            adapter = mDetailProductAdapter
        }

    }
}