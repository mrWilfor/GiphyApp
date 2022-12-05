package com.example.domain

import kotlinx.coroutines.flow.Flow

interface GifInfoRepository {
    val searchedGifsInfos: Flow<List<GifInfoDomain>>

    suspend fun searchGifs(searchStr: String, offset: Int, pageSize: Int)
    suspend fun saveGifLocalUrl(gifId: String, bytes: ByteArray)
    suspend fun deleteGifFromLocalCache(gifId: String, localFilePath: String)
}