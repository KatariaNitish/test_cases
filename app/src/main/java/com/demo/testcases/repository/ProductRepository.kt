package com.demo.testcases.repository


import com.demo.testcases.api.ProductsApi
import com.demo.testcases.models.ProductListItem
import com.demo.testcases.utils.NetworkResult

class ProductRepository(private val productsApi: ProductsApi) {

    suspend fun getProducts(): NetworkResult<List<ProductListItem.ProductListItemItem>> {
        val response = productsApi.getProductList()
        return if (response.isSuccessful){
           val responseBody = response.body()
            if (responseBody !=null){
                NetworkResult.Success(responseBody)
            }else{
                NetworkResult.Error("Something went wrong")
            }

        } else {
            NetworkResult.Error("Something went wrong")

        }
    }
}