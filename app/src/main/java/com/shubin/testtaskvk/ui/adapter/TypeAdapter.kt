package com.shubin.testtaskvk.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shubin.testtaskvk.data.network.ProductX
import com.shubin.testtaskvk.databinding.ItemProductBinding

class TypeAdapter : ListAdapter<ProductX, TypeAdapter.ProductViewHolder>(ProductDiffUtil) {
    inner class ProductViewHolder(val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(productX: ProductX) {
            binding.apply {
                Glide.with(binding.root.context).load(productX.thumbnail)
                    .into(binding.imgProductItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = getItem(position)
        holder.bind(product)
    }

    private object ProductDiffUtil : DiffUtil.ItemCallback<ProductX>() {
        override fun areItemsTheSame(oldItem: ProductX, newItem: ProductX): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProductX, newItem: ProductX): Boolean {
            return oldItem == newItem
        }

    }

}