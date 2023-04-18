package com.demo.testcases

import android.app.Application
import com.demo.testcases.api.ProductsApi
import com.demo.testcases.repository.ProductRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class StoreApplication : Application() {

    lateinit var productsApi: ProductsApi
            lateinit var productRepository: ProductRepository

    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder().
                addConverterFactory(GsonConverterFactory.create()).baseUrl("https://fakestoreapi.com/").build()

        productsApi = retrofit.create(ProductsApi::class.java)
        productRepository = ProductRepository(productsApi)
    }


}