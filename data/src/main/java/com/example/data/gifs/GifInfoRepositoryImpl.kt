package com.example.data.gifs

import com.example.data.gifs.db.GifInfoDb
import com.example.data.gifs.network.GifInfoNetwork
import com.example.domain.GifInfoDomain
import com.example.domain.GifInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GifInfoRepositoryImpl(
    private val gifInfoRemoteDataSource: GifInfoRemoteDataSource,
    private val gifInfoLocalDataSource: GifInfoLocalDataSource
) : GifInfoRepository {
    private var searchStr = ""
    override val searchedGifsInfos: Flow<List<GifInfoDomain>> =
        gifInfoLocalDataSource.getGifsInfoFlow()
            .map { gifsInfos ->
                gifsInfos
                    .filter { it.title.contains(searchStr) }
                    .map(GifInfoDb::toDomain)
            }


    override suspend fun searchGifs(searchStr: String, offset: Int) {
        this.searchStr = searchStr

        gifInfoRemoteDataSource.searchGifs(searchStr, offset)
            .takeIf { searchGifsResponse -> searchGifsResponse.isSuccessful && searchGifsResponse.body()?.meta?.status == 200 }
            .let { searchGifsResponse ->
                val searchGifs = searchGifsResponse?.body()
                    ?.data
                    ?.map(GifInfoNetwork::toDb)
                    ?: emptyList()

                gifInfoLocalDataSource.saveGifsInfo(searchGifs)
            }
    }
}