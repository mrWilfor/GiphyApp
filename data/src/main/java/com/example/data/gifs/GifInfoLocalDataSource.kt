package com.example.data.gifs

import com.example.data.gifs.db.GifInfoDao
import com.example.data.gifs.db.GifInfoDb
import kotlinx.coroutines.flow.first

class GifInfoLocalDataSource(private val gifInfoDao: GifInfoDao) {

    fun getGifsInfoFlow() = gifInfoDao.getAll()

    suspend fun saveGifsInfo(gifsInfos: List<GifInfoDb>) {
        gifInfoDao.insertAll(gifsInfos)
    }

    suspend fun saveGifLocalUrl(gifId: String, localUrl: String) {
        gifInfoDao.saveGifLocalUrl(gifId, localUrl)
    }

    suspend fun markAsDeleted(gifId: String) {
        gifInfoDao.markAsDeleted(gifId)
    }
}