package com.stacksmasher.coderswag.Controller

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
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //middle man between our data models and list views
    lateinit var adapter : CategoryRecycleAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this, DataService.categories)
        categoryListView.adapter = adapter

        val layoutmanager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutmanager
        //if we know each cell will have the exact same size
        categoryListView.setHasFixedSize(true)






        //setting a click listener for the list view cells, doesnt work for recycler views
//        categoryListView.setOnItemClickListener { parent, view, position, id ->
//            val category = DataService.categories[position]
//            Toast.makeText(this, "you clicked on the ${category.title} cell", Toast.LENGTH_SHORT).show()
//        }

    }
}
