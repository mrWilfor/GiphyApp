package com.example.data.gifs.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GifInfoDb(
    @PrimaryKey
    @ColumnInfo(name = "gif_id")
    val gifId: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "rating")
    val rating: String,
    @ColumnInfo(name = "url")
    val url: String,
    @ColumnInfo(name = "local_url")
    val localUrl: String? = null,
    @ColumnInfo(name = "is_deleted")
    val isDeleted: Boolean = false,
    @ColumnInfo(name = "search_request")
    val searchRequest: String
)