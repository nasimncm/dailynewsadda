package com.example.dailynewsadda.adapter

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.dailynewsadda.R
import com.example.dailynewsadda.db.AppDatabase
import com.example.dailynewsadda.db.BookmarkEntity
import com.example.dailynewsadda.model.ScienceDetailsModel
import kotlinx.android.synthetic.main.item_facts_description.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ScienceDetailsAdapter(
    var context: Context,
    var scienceDetailsList: ArrayList<ScienceDetailsModel>
) : RecyclerView.Adapter<ScienceDetailsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        private lateinit var appDb: AppDatabase
        private fun writeData(context: Context) {
            val info = itemView.tvDetails.text.toString()
            if (info.isNotEmpty()) {
                val bookmarkEntity = BookmarkEntity(null,info)
                GlobalScope.launch(Dispatchers.IO) {
                    appDb.bookmarkDao().insert(bookmarkEntity)
                }
                Toast.makeText(context, "Bookmark Successful", Toast.LENGTH_SHORT).show()
            }
        }

        var textView = itemView.findViewById<TextView>(R.id.tvDetails)
        var sharebtn = itemView.findViewById<ImageView>(R.id.ivShare)
        var copyBtn = itemView.findViewById<ImageView>(R.id.ivCopy)
        var bookmarkButton = itemView.findViewById<CheckBox>(R.id.ivBookmark)

        fun bind(model: ScienceDetailsModel, context: Context) {
            textView.text = model.text


            appDb = AppDatabase.getDatabase(context)



            bookmarkButton.setOnClickListener {
                writeData(context)
            }


            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

            copyBtn.setOnClickListener {
                val clipData = ClipData.newPlainText(null, model.text)
                clipboard.setPrimaryClip(clipData)
                Toast.makeText(context, "copied", Toast.LENGTH_SHORT).show()
            }

            sharebtn.setOnClickListener {
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
        val data = scienceDetailsList[position]
        holder.bind(data, context)
    }

    override fun getItemCount(): Int {
        return scienceDetailsList.size
    }

}