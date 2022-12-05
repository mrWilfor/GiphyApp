package com.example.data.gifs

import com.example.core.entities.NetworkResponse
import com.example.data.gifs.network.GifInfoNetwork
import com.example.data.gifs.network.GifsApi
import retrofit2.Response

class GifInfoRemoteDataSource(
    private val gifsApi: GifsApi,
    private val apiKeyProvider: ApiKeyProvider
) {
    suspend fun searchGifs(searchStr: String, offset: Int, pageSize: Int): Response<NetworkResponse<GifInfoNetwork>> {
        return gifsApi.searchGifs(apiKeyProvider.apiKey, searchStr, pageSize, offset, "g", "en")
    }
}