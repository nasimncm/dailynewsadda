package com.example.dailynewsadda.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmark")
data class BookmarkEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?=null,
    @ColumnInfo(name = "Info")
    val info: String?
)
