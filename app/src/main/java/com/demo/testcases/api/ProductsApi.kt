package com.demo.testcases.api

import com.demo.testcases.models.ProductListItem
import retrofit2.Response
import retrofit2.http.GET


interface ProductsApi {

    @GET("/products")
    suspend fun getProductList(): Response<List<ProductListItem.ProductListItemItem>>

}