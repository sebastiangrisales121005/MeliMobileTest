package com.ceiba.melimobiletest.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ceiba.domain.models.Product
import com.ceiba.melimobiletest.databinding.ItemProductBinding
import com.squareup.picasso.Picasso

class MainAdapter(private val context: Context, private val listProducts: List<Product>):
    RecyclerView.Adapter<MainAdapter.ViewHolder>(), View.OnClickListener {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    class ViewHolder(private val itemProductBinding: ItemProductBinding):
        RecyclerView.ViewHolder(itemProductBinding.root) {
            fun addItemProduct(product: Product) {
                itemProductBinding.titleProduct.text = product.title
                Picasso.get().load(product.imageProduct).into(itemProductBinding.imageProduct)
            }

        fun onClickListener(listener: View.OnClickListener) {
            itemProductBinding.buttonSeeDetail.setOnClickListener {
                listener.onClick(itemProductBinding.root)
            }
        }

    }

}