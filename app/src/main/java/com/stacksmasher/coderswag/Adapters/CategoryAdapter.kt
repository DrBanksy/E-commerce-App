package com.stacksmasher.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.Placeholder
import com.stacksmasher.coderswag.Model.Category
import com.stacksmasher.coderswag.R

class CategoryAdapter(context: Context, categories: List<Category>) : BaseAdapter() {
    val context =context
    val categories = categories

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView: View
        val holder: ViewHolder
        if(convertView == null) {
            //layoutinlfater is an object which takes an xml file and turns it into a view we can use in actual code
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
            holder = ViewHolder()

            //set UI element views
            holder.categoryImage = categoryView.findViewById(R.id.categoryImage)
            holder.categoryName = categoryView.findViewById(R.id.categoryName)

            //tag gives unique value to the view
            categoryView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
            categoryView = convertView
        }

        val category = categories[position]

        //setting the correct image and title for each category
        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        holder.categoryImage?.setImageResource(resourceId)
        holder.categoryName?.text = category.title

        return categoryView
    }

    override fun getItem(position: Int): Any {
        return categories[position]

    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    //returning the number of categories in the categories array
    override fun getCount(): Int {
        return categories.count()
    }

    //allows us to reuse and recycle our views
    private class ViewHolder {
        var categoryImage: ImageView? = null
        var categoryName: TextView? = null
    }

}