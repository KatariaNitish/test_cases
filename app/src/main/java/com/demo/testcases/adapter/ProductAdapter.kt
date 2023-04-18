package com.demo.testcases.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.demo.testcases.R
import com.demo.testcases.models.ProductListItem
import okhttp3.internal.notifyAll

class ProductAdapter(private val productList: List<ProductListItem.ProductListItemItem>):
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>()
{
    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val image = itemView.findViewById<ImageView>(R.id.ivProduct)
        val name = itemView.findViewById<TextView>(R.id.productName)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item_layout,parent,false)

        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {

        return productList.size

    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val product = productList[position]
        holder.name.text = product.title
        Glide.with(holder.image.context).load(product.image).into(holder.image)


    }


}