package com.example.core.entities

import com.google.gson.annotations.SerializedName

data class RequestMetaInfo(
    @SerializedName("status")
    val status: Int,
    @SerializedName("msg")
    val msg: String,
    @SerializedName("response_id")
    val response_id: String
)
