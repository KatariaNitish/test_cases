package com.demo.testcases.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.testcases.models.ProductListItem
import com.demo.testcases.repository.ProductRepository
import com.demo.testcases.utils.NetworkResult
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ProductRepository): ViewModel() {

    private val _products = MutableLiveData<NetworkResult<List<ProductListItem.ProductListItemItem>>>()

    val products: LiveData<NetworkResult<List<ProductListItem.ProductListItemItem>>>
    get() = _products

    fun getProducts(){
        viewModelScope.launch {
            val result = repository.getProducts()
            _products.postValue(result)

        }
    }


}