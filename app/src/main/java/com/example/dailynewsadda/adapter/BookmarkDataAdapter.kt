package com.example.dailynewsadda.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.dailynewsadda.R
import com.example.dailynewsadda.db.AppDatabase
import com.example.dailynewsadda.db.BookmarkEntity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class BookmarkDataAdapter (
    var context: Context,
    var bookmarkDataList: ArrayList<BookmarkEntity>
) : RecyclerView.Adapter<BookmarkDataAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var textView = itemView.findViewById<TextView>(R.id.tvBookmark)
        var clDelete = itemView.findViewById<ConstraintLayout>(R.id.clDelete)
        fun bind(model: BookmarkEntity,context:Context){
            val appDb = AppDatabase.getDatabase(context)
            textView.text = model.info


            clDelete.setOnClickListener {
                GlobalScope.launch {
                    appDb.bookmarkDao().deleteItem(model.id!!)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bookmark, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = bookmarkDataList[position]
        holder.bind(data, context)
    }

    override fun getItemCount(): Int {
        return bookmarkDataList.size
    }
}