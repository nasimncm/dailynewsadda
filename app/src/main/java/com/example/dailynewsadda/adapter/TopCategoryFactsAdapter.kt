package com.example.dailynewsadda.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dailynewsadda.R
import com.example.dailynewsadda.model.TopCategoryModel

class TopCategoryFactsAdapter (
    var context: Context,
    var topCategoryFactsList: ArrayList<TopCategoryModel>
) : RecyclerView.Adapter<TopCategoryFactsAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imageView = itemView.findViewById<ImageView>(R.id.ivCategory)
        var textView = itemView.findViewById<TextView>(R.id.tvCategory)
        fun bind(model: TopCategoryModel){
            imageView.setImageResource(model.image)
            textView.text = model.name

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_category_facts, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = topCategoryFactsList[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return topCategoryFactsList.size
    }
}