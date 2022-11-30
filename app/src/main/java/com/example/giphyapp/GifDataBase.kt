package com.example.giphyapp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.gifs.db.GifInfoDao
import com.example.data.gifs.db.GifInfoDb

@Database(entities = [GifInfoDb::class], version = 1)
abstract class GifDataBase : RoomDatabase() {

    abstract fun gifInfoDao(): GifInfoDao

    companion object {
        const val NAME = "GiphyDataBase"
    }
}

