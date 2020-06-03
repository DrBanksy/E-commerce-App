package com.stacksmasher.coderswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.stacksmasher.coderswag.Model.Product
import com.stacksmasher.coderswag.R
import com.stacksmasher.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_product_detail.*
import org.w3c.dom.Text

//@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class ProductDetailActivity : AppCompatActivity() {

    lateinit var product : Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)
        val resourceId = resources.getIdentifier(product.image, "drawable", packageName)
        productHolder.setImageResource(resourceId)
        detailProductName.text = product.title
        detailProductPrice.text = product.price

    }
}
