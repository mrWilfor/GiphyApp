package com.example.data.gifs

import com.example.data.gifs.db.GifInfoDb
import com.example.domain.GifInfoDomain
import com.example.domain.GifInfoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class GifInfoRepositoryImpl(
    private val gifInfoRemoteDataSource: GifInfoRemoteDataSource,
    private val gifInfoLocalDataSource: GifInfoLocalDataSource,
    private val localCacheManager: LocalCacheManager
) : GifInfoRepository {
    override val searchedGifsInfos: Flow<List<GifInfoDomain>> =
        gifInfoLocalDataSource.getGifsInfoFlow()
            .map { gifsInfos ->
                gifsInfos.map(GifInfoDb::toDomain)
            }


    override suspend fun searchGifs(searchStr: String, offset: Int, pageSize: Int) {
        withContext(Dispatchers.IO) {
            gifInfoRemoteDataSource.searchGifs(searchStr, offset, pageSize)
                .takeIf { searchGifsResponse -> searchGifsResponse.isSuccessful && searchGifsResponse.body()?.meta?.status == 200 }
                ?.let { searchGifsResponse ->
                    val searchGifs = searchGifsResponse.body()?.data
                        ?.map { it.toDb(searchStr) }
                        ?: emptyList()

                    gifInfoLocalDataSource.saveGifsInfo(searchGifs)
                }
        }
    }

    override suspend fun saveGifLocalUrl(gifId: String, bytes: ByteArray) {
        withContext(Dispatchers.IO) {
            val savedGif = localCacheManager.saveGifLocally(gifId, bytes)

            gifInfoLocalDataSource.saveGifLocalUrl(gifId, savedGif.path)
        }
    }

    override suspend fun deleteGifFromLocalCache(gifId: String, localFilePath: String) {
        withContext(Dispatchers.IO) {
            gifInfoLocalDataSource.markAsDeleted(gifId)
            localCacheManager.deleteGifFromLocalCache(localFilePath)
        }
    }
}