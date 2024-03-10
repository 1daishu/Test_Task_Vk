package com.shubin.testtaskvk.ui.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class ProductViewModelFactory @Inject constructor(
    private val viewModel: ProductViewModel
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductViewModel::class.java)) {
            return viewModel as T
        } else {
            throw IllegalAccessException("Unknown class name: $modelClass")
        }
    }
}