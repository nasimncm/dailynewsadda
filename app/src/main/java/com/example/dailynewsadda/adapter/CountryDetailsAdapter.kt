package com.example.dailynewsadda.adapter

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.dailynewsadda.R
import com.example.dailynewsadda.model.CountryDetailsModel

class CountryDetailsAdapter(
    var context: Context,
    var countryDetailsList: ArrayList<CountryDetailsModel>
) : RecyclerView.Adapter<CountryDetailsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.tvDetails)
        val shareButton = itemView.findViewById<ImageView>(R.id.ivShare)
        val copyButton = itemView.findViewById<ImageView>(R.id.ivCopy)
        fun bind(model: CountryDetailsModel, context: Context) {
            textView.text = model.text

            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            copyButton.setOnClickListener {
                val clipData = ClipData.newPlainText(null, model.text)
                clipboard.setPrimaryClip(clipData)
                Toast.makeText(context, "Text Copied", Toast.LENGTH_SHORT).show()
            }
            shareButton.setOnClickListener {
                val shareBody = model.text
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
                context.startActivity(shareIntent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_facts_description, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = countryDetailsList[position]
        return holder.bind(data, context)
    }

    override fun getItemCount(): Int {
        return countryDetailsList.size
    }
}