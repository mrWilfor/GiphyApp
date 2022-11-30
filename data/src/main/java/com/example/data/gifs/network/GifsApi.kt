package com.example.data.gifs.network

import com.example.core.entities.NetworkResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface GifsApi {

    @GET("search")
    suspend fun searchGifs(
        @Query("api_key") apiKey: String,
        @Query("q") searchQuery: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("rating") rating: String,
        @Query("lang") lang: String,
    ): Response<NetworkResponse<GifInfoNetwork>>
}