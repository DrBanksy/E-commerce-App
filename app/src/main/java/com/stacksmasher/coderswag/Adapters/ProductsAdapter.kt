package com.stacksmasher.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.stacksmasher.coderswag.Model.Product
import com.stacksmasher.coderswag.R

class ProductsAdapter(val context: Context, val products: List<Product>, val itemClicked: (Product) -> Unit) : RecyclerView.Adapter<ProductsAdapter.ProductHolder>(){


    inner class ProductHolder(itemView: View, val itemClicked: (Product) -> Unit) : RecyclerView.ViewHolder(itemView) {
        //this is just finding the view holders and then assigning them
        val productImage = itemView.findViewById<ImageView>(R.id.productImage)
        val productName = itemView.findViewById<TextView>(R.id.detailProductName)
        val productPrice = itemView.findViewById<TextView>(R.id.detailProductPrice)

        fun bindProduct(product: Product, context: Context) {
            val resourceId = context.resources.getIdentifier(product.image, "drawable", context.packageName)
            productImage?.setImageResource(resourceId)
            productName?.text = product.title
            productPrice?.text = product.price
            itemView.setOnClickListener { itemClicked(product) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view =  LayoutInflater.from(context).inflate(R.layout.product_list_item, parent, false)
        return ProductHolder(view, itemClicked)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bindProduct(products[position], context)
    }

}