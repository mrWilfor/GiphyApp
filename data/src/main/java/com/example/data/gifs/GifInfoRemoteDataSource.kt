package com.example.data.gifs

import com.example.core.entities.NetworkResponse
import com.example.data.gifs.network.GifInfoNetwork
import com.example.data.gifs.network.GifsApi
import retrofit2.Response

class GifInfoRemoteDataSource(
    private val gifsApi: GifsApi
) {
    suspend fun searchGifs(searchStr: String): Response<NetworkResponse<GifInfoNetwork>> {
        return gifsApi.searchGifs("ibOl4CbrqH8xxe8HrKIo0jOIXIVhzSVy", searchStr, 20, 0, "g", "en")
    }
}