package com.example.dailynewsadda.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BookmarkEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun bookmarkDao() : BookmarkDao
    companion object{
        @Volatile
        private var INSTANCE : AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java,"database").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}