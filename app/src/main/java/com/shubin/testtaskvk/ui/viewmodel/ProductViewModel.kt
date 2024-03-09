package com.shubin.testtaskvk.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubin.testtaskvk.data.network.ProductX
import com.shubin.testtaskvk.domain.TypeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: TypeRepository
) : ViewModel() {
    private val _getProduct = MutableLiveData<List<ProductX>>()
    val getProduct: LiveData<List<ProductX>> = _getProduct
    fun getAllProduct() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getAllProduct()
            if (response.isSuccessful) {
                val product = response.body()?.products
                product?.let {
                    _getProduct.postValue(it)
                }
            }
        }
    }

}