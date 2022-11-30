package com.example.domain

import kotlinx.coroutines.flow.Flow

interface GifInfoRepository {
    val searchedGifsInfos: Flow<List<GifInfoDomain>>

    suspend fun searchGifs(searchStr: String)
}