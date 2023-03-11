package com.example.dailynewsadda.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dailynewsadda.R
import com.example.dailynewsadda.model.TopCollectionFactsModel

class TopCollectionFactsAdapter (
    var context: Context,
    var topCollectionFactsList: ArrayList<TopCollectionFactsModel>
): RecyclerView.Adapter<TopCollectionFactsAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var imageView = itemView.findViewById<ImageView>(R.id.ivScience)
        var textView = itemView.findViewById<TextView>(R.id.tvScience)
        fun bind(model: TopCollectionFactsModel){
            imageView.setImageResource(model.image)
            textView.text = model.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_facts, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = topCollectionFactsList[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return topCollectionFactsList.size
    }

}