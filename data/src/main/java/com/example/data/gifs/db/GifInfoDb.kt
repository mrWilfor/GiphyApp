package com.example.data.gifs.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GifInfoDb(
    @ColumnInfo
    @PrimaryKey(autoGenerate=true)
    val id: Long? = null,
     @ColumnInfo(name = "type")
    val type: String,
     @ColumnInfo(name = "gif_id")
    val gifId: String,
     @ColumnInfo(name = "title")
    val title: String,
     @ColumnInfo(name = "rating")
    val rating: String,
     @ColumnInfo(name = "url")
    val url: String,
     @ColumnInfo(name = "preview_url")
    val previewUrl: String,
)