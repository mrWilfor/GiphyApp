package com.example.data.gifs

import com.example.data.gifs.db.GifInfoDao
import com.example.data.gifs.db.GifInfoDb

class GifInfoLocalDataSource(private val gifInfoDao: GifInfoDao) {

    fun getGifsInfoFlow() = gifInfoDao.getAll()

    suspend fun saveGifsInfo(gifsInfos: List<GifInfoDb>) {
        gifInfoDao.insertAll(gifsInfos)
    }
}