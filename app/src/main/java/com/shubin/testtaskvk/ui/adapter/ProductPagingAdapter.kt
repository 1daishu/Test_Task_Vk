package com.shubin.testtaskvk.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shubin.testtaskvk.databinding.ItemProductBinding
import com.shubin.testtaskvk.domain.model.Product
import com.shubin.testtaskvk.ui.fragment.ProductViewModel
import javax.inject.Inject

class ProductPagingAdapter @Inject constructor(
    private val viewModel: ProductViewModel
) :
    PagingDataAdapter<Product, ProductPagingAdapter.ProductListViewHolder>(callBack) {
    inner class ProductListViewHolder(
        val binding: ItemProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            Glide.with(binding.root.context).load(product.thumbnail).into(binding.imgProductItem)
            binding.txtDescription.text = product.description
            binding.txtTitle.text = product.id.toString()
        }
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        val productItem = getItem(position)
        productItem?.let {
            holder.bind(productItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        return ProductListViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    companion object {
        val callBack = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem == newItem
            }

        }
    }
}