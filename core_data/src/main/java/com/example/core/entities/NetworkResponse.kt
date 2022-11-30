package com.example.core.entities

import com.google.gson.annotations.SerializedName

data class NetworkResponse<T>(
    @SerializedName("data")
    val data: List<T>,
    @SerializedName("pagination")
    val pagination: Pagination,
    @SerializedName("meta")
    val meta: RequestMetaInfo
)