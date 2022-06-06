package com.ceiba.melimobiletest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ceiba.domain.models.Specs
import com.ceiba.melimobiletest.databinding.ItemSpecBinding

class DetailProductAdapter(private val context: Context, private val listSpecs: List<Specs>):
    RecyclerView.Adapter<DetailProductAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemSpecBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.addItemSpec(listSpecs[position])


    override fun getItemCount(): Int = listSpecs.size


    class ViewHolder(private val itemSpecBinding: ItemSpecBinding):
        RecyclerView.ViewHolder(itemSpecBinding.root) {
            fun addItemSpec(specs: Specs) {
                itemSpecBinding.nameSpecProduct.text = specs.nameSpecs
                itemSpecBinding.valueSpecProduct.text = specs.valueSpecs
            }
    }

}