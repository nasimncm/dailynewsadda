package com.example.dailynewsadda.db

import androidx.room.*


@Dao
interface BookmarkDao {

    @Query("SELECT * FROM bookmark")
    fun getAll(): List<BookmarkEntity>

    @Query("SELECT * FROM bookmark")
    fun viewData(): BookmarkEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(bookmarkEntity: BookmarkEntity)

    @Delete
    fun delete(bookmarkEntity: BookmarkEntity) : Int

        @Query("DELETE FROM bookmark WHERE id = :id")
        fun deleteItem(id:Int)

}