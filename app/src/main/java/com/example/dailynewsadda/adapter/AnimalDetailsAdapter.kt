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
import com.example.dailynewsadda.model.AnimalDetailsModel

class AnimalDetailsAdapter(
    var context: Context,
    var animalDetailsList: ArrayList<AnimalDetailsModel>
) : RecyclerView.Adapter<AnimalDetailsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView = itemView.findViewById<TextView>(R.id.tvDetails)
        var shareButton = itemView.findViewById<ImageView>(R.id.ivShare)
        var copyButton = itemView.findViewById<ImageView>(R.id.ivCopy)
        fun bind(model: AnimalDetailsModel, context: Context) {
            textView.text = model.text


            val clipBoard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            copyButton.setOnClickListener {
                val clipData = ClipData.newPlainText(null, model.text)
                clipBoard.setPrimaryClip(clipData)
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
        val data = animalDetailsList[position]
        holder.bind(data, context)
    }

    override fun getItemCount(): Int {
        return animalDetailsList.size
    }
}