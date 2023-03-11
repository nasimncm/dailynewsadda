package com.example.dailynewsadda.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dailynewsadda.R
import com.example.dailynewsadda.model.TrendingFactsModel

class TrendingFactsAdapter(
    var context: Context,
    var trendingFactsList: ArrayList<TrendingFactsModel>
) : RecyclerView.Adapter<TrendingFactsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_home_facts, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = trendingFactsList[position]
        holder.bind(data)

    }

    override fun getItemCount(): Int {
        return trendingFactsList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView = itemView.findViewById<ImageView>(R.id.ivScience)
        var textview = itemView.findViewById<TextView>(R.id.tvScience)

        fun bind(model: TrendingFactsModel) {
            imageView.setImageResource(model.image)
            textview.text = model.name
        }

    }
}
