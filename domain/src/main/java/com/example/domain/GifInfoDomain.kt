package com.example.domain

data class GifInfoDomain(
    val gifId: String,
    val title: String,
    val url: String,
    val localUrl: String? = null,
    val isDeleted: Boolean,
    val searchRequest: String
)