package com.ceiba.melimobiletest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ceiba.domain.models.Product
import com.ceiba.melimobiletest.databinding.ItemProductBinding
import com.squareup.picasso.Picasso

class MainAdapter(private val context: Context, private val listProducts: List<Product>):
    RecyclerView.Adapter<MainAdapter.ViewHolder>(), View.OnClickListener {
    var mListenerProduct: View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemProductBinding.inflate(LayoutInflater.from(context), parent, false)
        view.root.setOnClickListener(this)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.addItemProduct(listProducts[position])
        mListenerProduct?.let { holder.onClickListener(it) }

    }

    override fun getItemCount(): Int {
        return listProducts.size
    }

    override fun onClick(view: View?) {
        mListenerProduct?.onClick(view)
    }

    fun setProductOnClickListener(listener: View.OnClickListener) {
        mListenerProduct = listener
    }

    class ViewHolder(private val itemProductBinding: ItemProductBinding):
        RecyclerView.ViewHolder(itemProductBinding.root) {
            fun addItemProduct(product: Product) {
                val price = PESO_SIGN + product.price.toString()
                itemProductBinding.titleProduct.text = product.title
                itemProductBinding.priceProduct.text = price
                Picasso.get().load(product.imageProduct).into(itemProductBinding.imageProduct)
            }

        fun onClickListener(listener: View.OnClickListener) {
            itemProductBinding.buttonSeeDetail.setOnClickListener {
                listener.onClick(itemProductBinding.root)
            }
        }

    }

    companion object {
        const val PESO_SIGN = "$"
    }

}