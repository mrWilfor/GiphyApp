package com.example.data.gifs.network

import com.google.gson.annotations.SerializedName

data class GifInfoNetwork(
    @SerializedName("type")
    val type: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("rating")
    val rating: String,
    @SerializedName("mp4")
    val url: String,
    @SerializedName("url")
    val previewUrl: String,
)
