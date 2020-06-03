package com.stacksmasher.coderswag.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.stacksmasher.coderswag.Adapters.CategoryAdapter
import com.stacksmasher.coderswag.Adapters.CategoryRecycleAdapter
import com.stacksmasher.coderswag.Model.Category
import com.stacksmasher.coderswag.R
import com.stacksmasher.coderswag.Services.DataService
import com.stacksmasher.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.category_list_item.*

class MainActivity : AppCompatActivity() {

    //middle man between our data models and list views
    private lateinit var adapter : CategoryRecycleAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setting adapter
        adapter = CategoryRecycleAdapter(this, DataService.categories) {category ->
            val productIntent = Intent(this, ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productIntent)
        }
        categoryListView.adapter = adapter

        //setting layoutmanager
        val viewManager = LinearLayoutManager(this)
        categoryListView.layoutManager = viewManager
        //if we know each cell will have the exact same size
        categoryListView.setHasFixedSize(true)




        //setting a click listener for the list view cells, doesnt work for recycler views
//        categoryListView.setOnItemClickListener { parent, view, position, id ->
//            val category = DataService.categories[position]
//            Toast.makeText(this, "you clicked on the ${category.title} cell", Toast.LENGTH_SHORT).show()
//        }

    }
}
