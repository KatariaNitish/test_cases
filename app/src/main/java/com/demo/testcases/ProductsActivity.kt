package com.demo.testcases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.testcases.adapter.ProductAdapter
import com.demo.testcases.databinding.ActivityProductsBinding
import com.demo.testcases.utils.NetworkResult
import com.demo.testcases.viewmodels.MainViewModel
import com.demo.testcases.viewmodels.MainViewModelFactory

class ProductsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductsBinding

    lateinit var mainViewModel: MainViewModel
     lateinit var recyclerView: RecyclerView
    lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = findViewById(R.id.rvProducts)
        binding.rvProducts.layoutManager = GridLayoutManager(this,2)

        val repository = (application as StoreApplication).productRepository
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.getProducts()

        mainViewModel.products.observe(this, Observer {
            when(it){
                is NetworkResult.Success ->{
                    Log.d("TestApi",it.data.toString())
                    adapter = ProductAdapter(it.data!!)
                    recyclerView.adapter = adapter

                }

                is NetworkResult.Error -> {}

                else -> {}
            }
         })





    }
}