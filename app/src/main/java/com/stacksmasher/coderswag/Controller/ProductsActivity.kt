package com.stacksmasher.coderswag.Controller

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.stacksmasher.coderswag.Adapters.ProductsAdapter
import com.stacksmasher.coderswag.R
import com.stacksmasher.coderswag.Services.DataService
import com.stacksmasher.coderswag.Services.DataService.getProducts
import com.stacksmasher.coderswag.Utilities.EXTRA_CATEGORY
import com.stacksmasher.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter : ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductsAdapter(this, DataService.getProducts(categoryType)) { product ->
            val productDetailIntent = Intent(this, ProductDetailActivity::class.java)
            productDetailIntent.putExtra(EXTRA_PRODUCT, product)
            startActivity(productDetailIntent)

        }
        //adapter = ProductsAdapter(this, DataService.getProducts(categoryType))

        //returns an integer number 1 is portrait and 2 is landscape
        var spanCount = 2
        val orientation = resources.configuration.orientation
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //so if its landscape we want three columns
            spanCount = 4
        }

        val screenSize = resources.configuration.screenWidthDp
        if(screenSize > 720) {
            spanCount = 3
        }


        val viewManager = GridLayoutManager(this, spanCount)
        productListView.layoutManager = viewManager
        productListView.adapter = adapter
    }


}
