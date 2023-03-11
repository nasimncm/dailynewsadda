package com.example.dailynewsadda

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.dailynewsadda.adapter.BookmarkDataAdapter
import com.example.dailynewsadda.db.AppDatabase
import com.example.dailynewsadda.db.BookmarkEntity
import kotlinx.android.synthetic.main.activity_bookmark.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class BookmarkActivity : AppCompatActivity() {

    private lateinit var rvBookmarkDetails: RecyclerView
    private lateinit var bookmarkDetailsAdapter: BookmarkDataAdapter
    private lateinit var bookmarkDetailsList: ArrayList<BookmarkEntity>

    private lateinit var appDb: AppDatabase
    private var bookmarkLiveData = MutableLiveData<List<BookmarkEntity>>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookmark)

        rvBookmarkDetails = findViewById(R.id.rvBookmarkDetails)
        bookmarkDetailsList = arrayListOf()
        bookmarkDetailsAdapter = BookmarkDataAdapter(this, bookmarkDetailsList)
        rvBookmarkDetails.adapter = bookmarkDetailsAdapter



        appDb = AppDatabase.getDatabase(this)

        //On Back Press Action Handle
        ivBack.setOnClickListener {
            onBackPressed()
        }




        readData()

        bookmarkLiveData.observe(this, Observer {
            if (it.isNotEmpty()) {
                bookmarkDetailsList.addAll(it)
                bookmarkDetailsAdapter.notifyDataSetChanged()
            }
        })
    }


    private fun readData() {

        var bookmarkEntity: List<BookmarkEntity> = arrayListOf()
        GlobalScope.launch {
            bookmarkEntity = appDb.bookmarkDao().getAll()
            bookmarkLiveData.postValue(bookmarkEntity)
        }

    }

}